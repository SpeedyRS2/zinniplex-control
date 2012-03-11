package de.zinniplex.eventghost;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

public class EventGhostIntent {
	public static final String EVENTGHOST_PACKAGE = "com.timhoeck.android.eventghost";
	public static final String ACTIONS = EVENTGHOST_PACKAGE + ".action";
	public static final String PERMISSIONS = EVENTGHOST_PACKAGE + ".permission";
	private final static String MARKET_DOWNLOAD_URL_PREFIX = "market://search?q=pname:";
	private final static String EVENTGHOST_MARKET_URL =  MARKET_DOWNLOAD_URL_PREFIX + EVENTGHOST_PACKAGE;
	
	public static final String ACTION_SEND_EVENT = ACTIONS + ".SEND_EVENT";						//action used to send an event
	public static final String ACTION_RECEIVED_EVENT = ACTIONS + ".RECEIVED_EVENT";				//action broadcast when an event is received
	public static final String ACTION_GENERATE_EVENT = ACTIONS + ".GENERATE_EVENT";
	
	public static final String PERMISSION_SEND_EVENT = PERMISSIONS + ".SEND_EVENTS";			//required to send an event to an EventGhost server
	public static final String PERMISSION_RECEIVE_EVENTS = PERMISSIONS + ".RECEIVE_EVENTS";		//required to receive incoming events from an EventGhost server or other Applications
	public static final String PERMISSION_GENERATE_EVENTS = PERMISSIONS + ".GENERATE_EVENTS";	//required to generate incoming events from another application	
	
	//Extras when sending or receiving
	public static final String EXTRA_EVENT = "event";				//Event being sent or received
	public static final String EXTRA_PAYLOAD = "payload";			//Payload passed with the event
	public static final String EXTRA_FROM_NAME = "from_name";		//Name of Server/App the event came from
	public static final String EXTRA_SERVERID = "server";			//the server an event came from or is being sent to
	
	//Extras provided to you when receiving broadcasts
	public static final String EXTRA_SERVER_NAMES = "server_names";	//List of user servers passed to interested plugins/apps
	public static final String EXTRA_SERVER_IDS = "server";		//List of ids for the servers, required when sending an event to a specific server
	public static final String EXTRA_LAYOUTS = "layouts";			//List of user layouts passed to interested plugins
	
	public static class ReceiveEventsExampleReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String event = intent.getStringExtra(EXTRA_EVENT);
			String payload = intent.getStringExtra(EXTRA_PAYLOAD);
			String from = intent.getStringExtra(EXTRA_FROM_NAME);
			String serverId = intent.getStringExtra(EXTRA_SERVERID);
			ArrayList<String> servers = intent.getStringArrayListExtra(EXTRA_SERVER_NAMES);
			ArrayList<String> serverids = intent.getStringArrayListExtra(EXTRA_SERVER_IDS);
			String serverName = getServerName(servers, serverids, serverId);
			Log.d("ReceivedEvent", "Event: " + event + " Payload: " + payload + " from " + serverName);
			Toast toast = Toast.makeText(context, "Event: " + event + " Payload: " + payload + " from " + serverName, 10);
			toast.show();
		}
		
	}
	
	public static String getServerName(ArrayList<String> serverNames, ArrayList<String> serverIds, String serverId) {
		for (int i = 0; i < serverIds.size(); i++) {
			if (serverIds.get(i) == serverId) return serverNames.get(i);
		}
		return "Unknown";
	}
	
	public static final void sendEvent(Context context, String event) {
		sendEvent(context, event, null, null, null);
	}
	
	public static final void sendEvent(Context context, String event, String payload) {
		sendEvent(context, event, payload, null, null);
	}
	
	public static final void sendEvent(Context context, String event, String payload, String serverId) {
		sendEvent(context, event, payload, null, serverId);
	}
	
	public static final void sendEvent(Context context, String event, String payload, String from, String serverId) {
		if (havePermission(context, PERMISSION_SEND_EVENT)) {
			Intent sendEvent = new Intent(EventGhostIntent.ACTION_SEND_EVENT);
			sendEvent.putExtra(EXTRA_EVENT, event);
			sendEvent.putExtra(EXTRA_PAYLOAD, payload);
			sendEvent.putExtra(EXTRA_FROM_NAME, from);
			sendEvent.putExtra(EXTRA_SERVERID, serverId);
			context.sendBroadcast(sendEvent);
		}
	}
	
	public static final void generateEvent(Context context, String event) {
		generateEvent(context, event, null);
	}
	
	public static final void generateEvent(Context context, String event, String payload) {
		generateEvent(context, event, payload, null);
	}
	
	public static final void generateEvent(Context context, String event, String payload, String from) {
		if (havePermission(context, PERMISSION_GENERATE_EVENTS)) {
			Intent generate = new Intent(ACTION_GENERATE_EVENT);
			generate.putExtra(EXTRA_EVENT, event);
			if (payload != null) generate.putExtra(EXTRA_PAYLOAD, payload);
			if (from != null) generate.putExtra(EXTRA_FROM_NAME, from);
			context.sendBroadcast(generate);
			if(!isInstalled(context)){
				Toast toast = Toast.makeText(context, "EventGhost nicht installiert", 30);
				toast.show();
			} else {
				Toast toast = Toast.makeText(context, "Event: " + event, 30);
				toast.show();
			}

		}
	}
	
	public static boolean isInstalled( Context context ) {
		boolean foundFlag = false;
		
		try {
			context.getPackageManager().getPackageInfo(EVENTGHOST_PACKAGE, 0 );
			foundFlag = true;
		}
		catch ( Exception e ) {
		}
		
		return foundFlag;
	}
	
	public static Intent getInstallIntent( boolean marketFlag ) {
		
		return new Intent( 
				Intent.ACTION_VIEW, 
				Uri.parse(EVENTGHOST_MARKET_URL)
				);
	}
	
	public static boolean havePermission(Context context, String permission) {
		return context.checkPermission(permission, Process.myPid(), Process.myUid() ) == 
			PackageManager.PERMISSION_GRANTED;
	}
	
}