package de.zinniplex.activities;

import android.os.Bundle;
import android.view.View;
import de.zinniplex.R;
import de.zinniplex.eventghost.EventGhostCommands;
import de.zinniplex.http.SubmitCommandAsyncTask;

public class OnkyoActivity extends GlobalActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onkyo_layout);
		initializeVolControlBar();
	}

	public void prevlistening(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_PREV_LISTEN);
	}

	public void nextlistening(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_NEXT_LISTEN);
	}

}
