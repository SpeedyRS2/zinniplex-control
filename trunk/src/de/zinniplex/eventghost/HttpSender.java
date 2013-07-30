package de.zinniplex.eventghost;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpSender {
	
	public static final String HTPC_IP = "http://192.168.178.29:80?";
	public static final String CONTENTTYPE = "contentType";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String TEXT_HTML = "text/html";

	public static void sendCommand(String command){
		HttpGet method = new HttpGet(HTPC_IP + command);
		method.addHeader(CONTENTTYPE, CONTENT_TYPE);
		method.addHeader(TEXT_HTML, TEXT_HTML);
		HttpClient client = new DefaultHttpClient();
		try {
			client.execute(method);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
