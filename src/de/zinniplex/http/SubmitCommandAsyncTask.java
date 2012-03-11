package de.zinniplex.http;

import android.os.AsyncTask;
import de.zinniplex.eventghost.HttpSender;

public class SubmitCommandAsyncTask extends AsyncTask<String, Void, Boolean> {

	@Override
	protected Boolean doInBackground(String... arg0) {
		HttpSender.sendCommand(arg0[0]);
		return null;
	}

}
