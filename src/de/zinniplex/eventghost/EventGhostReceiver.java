package de.zinniplex.eventghost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import de.zinniplex.GlobalConstants;

public class EventGhostReceiver extends BroadcastReceiver {
	// Constants
	private static final String ACTION_RECEIVED_EVENT = "com.timhoeck.android.eventghost.action.RECEIVED_EVENT";
	private static final String EXTRA_EVENT = "event";
	private static final String EXTRA_PAYLOAD = "payload";

	// private static final String EXTRA_FROM = "from_name";
	// private static final ArrayList EXTRA_SERVER_NAMES = "server_names";
	// private static final ArrayList EXTRA_SERVER_IDS = new ArrayList();
	// private static final ArrayList EXTRA_LAYOUTS = "layouts";

	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(ACTION_RECEIVED_EVENT)) {
			String event = intent.getStringExtra(EXTRA_EVENT);
			String payload = intent.getStringExtra(EXTRA_PAYLOAD);
			Log.i("onReceive", "Received event:" + event + " with payload " + payload + ", time to do something");
			saveReceivedEvent(context, event);
			// do something here
		}
	}

	private void saveReceivedEvent(Context context, String event) {
		// SharedPreferences prefs =
		// PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences onkyoData = context.getSharedPreferences(GlobalConstants.PREFS_ONKYO, 0);
		SharedPreferences.Editor editor = onkyoData.edit();
		// SharedPreferences.Editor editor = prefs.edit();
		editor.putString(GlobalConstants.PREFS_LISTENING_MODE, event);
		editor.commit();
		// Intent intent = new Intent(context, MainTabWidget.class);
		// intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// intent.putExtra("volume", event);
		// context.startActivity(intent);
	}

}
