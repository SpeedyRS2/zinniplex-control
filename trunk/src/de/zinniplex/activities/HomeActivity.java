package de.zinniplex.activities;

import android.os.Bundle;
import android.view.View;
import de.zinniplex.R;
import de.zinniplex.R.layout;
import de.zinniplex.eventghost.EventGhostCommands;
import de.zinniplex.http.SubmitCommandAsyncTask;

public class HomeActivity extends GlobalActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home_layout);
		initializeVolControlBar();
	}

	public void switchspots(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SPOTS);
		// HttpSender.sendCommand(EventGhostCommands.COMMAND_SWITCH_SPOTS);
	}

	public void switchsaeulen(View view) {
		// Button bt = (Button) findViewById(R.id.switchsaeulen);
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SAUELEN);
	}

	public void pl2xmovie(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_LISTEN_PL_2_MOVIE);
	}

	public void pl2xmusic(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_LISTEN_PL_2_MUSIC);
	}

	public void fanon(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_FAN_ON);
	}

	public void fanoff(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_FAN_OFF);
	}

	public void mask169(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_169);
	}

	public void mask219(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_219);
	}

}
