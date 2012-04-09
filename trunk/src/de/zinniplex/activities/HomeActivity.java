package de.zinniplex.activities;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import de.zinniplex.R;
import de.zinniplex.eventghost.EventGhostCommands;
import de.zinniplex.http.SubmitCommandAsyncTask;

public class HomeActivity extends GlobalActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home_layout);
		initializeVolControlBar();

		// Spots dimmen
		Button spotsButton = (Button) this.findViewById(R.id.switchspots);
		spotsButton.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SPOTS_PRESSED);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SPOTS_RELEASED);
				}
				return false;
			}
		});

		// Saeulen dimmen
		Button saeulenButton = (Button) this.findViewById(R.id.switchsaeulen);
		saeulenButton.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SAEULEN_PRESSED);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SAEULEN_RELEASED);
				}
				return false;
			}
		});

		// Maskierung rauf fahren, solange gedrueckt wird
		Button maskupButton = (Button) this.findViewById(R.id.mask219);
		maskupButton.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_OPEN_PRESSED);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_OPEN_RELEASED);
				}
				return false;
			}
		});

		// Maskierung runter fahren, solange gedrueckt wird
		Button maskdownButton = (Button) this.findViewById(R.id.mask169);
		maskdownButton.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_CLOSE_PRESSED);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_CLOSE_RELEASED);
				}
				return false;
			}
		});
	}

	// public void switchspots(View view) {
	// new
	// SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SPOTS);
	// // HttpSender.sendCommand(EventGhostCommands.COMMAND_SWITCH_SPOTS);
	// }
	//
	// public void switchsaeulen(View view) {
	// // Button bt = (Button) findViewById(R.id.switchsaeulen);
	// new
	// SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SAUELEN);
	// }

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

	// public void mask169(View view) {
	// new
	// SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_169);
	// }
	//
	// public void mask219(View view) {
	// new
	// SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_MASK_219);
	// }

}
