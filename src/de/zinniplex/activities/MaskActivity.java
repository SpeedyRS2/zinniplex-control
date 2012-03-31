package de.zinniplex.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import de.zinniplex.R;
import de.zinniplex.eventghost.EventGhostCommands;
import de.zinniplex.http.SubmitCommandAsyncTask;

public class MaskActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mask_layout);

		// Maskierung rauf fahren, solange gedrueckt wird
		Button maskupButton = (Button) this.findViewById(R.id.maskopen);
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
		Button maskdownButton = (Button) this.findViewById(R.id.maskclose);
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
}
