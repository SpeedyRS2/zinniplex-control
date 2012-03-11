package de.zinniplex.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import de.zinniplex.GlobalConstants;
import de.zinniplex.R;
import de.zinniplex.eventghost.EventGhostCommands;
import de.zinniplex.http.SubmitCommandAsyncTask;
import de.zinniplex.tools.VolumeConverter;

/**
 * Hier werden die generellen Funktionen, die über mehrer Tabs gehen, geregelt
 * 
 * @author SpeedyRS2
 * 
 */
public class GlobalActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// initializeVolControlBar();
	}

	public void initializeVolControlBar() {
		// setContentView(R.layout.home_layout);
		SeekBar volControl = (SeekBar) findViewById(R.id.volbar);

		updateTextViews();

		volControl.setMax(14);

		volControl.setProgress(1);
		volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				updateTextViews();
				TextView tv2 = (TextView) findViewById(R.id.statusinput);
				tv2.setText("Input: Blu-ray");
				refreshVolumeText(arg1);

			}
		});
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		int action = event.getAction();
		int keyCode = event.getKeyCode();
		switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_UP:
			if (action == KeyEvent.ACTION_UP) {
				SeekBar volControl = (SeekBar) findViewById(R.id.volbar);
				int level = volControl.getProgress();
				int newLevel = level + 1;
				volControl.setProgress(newLevel);
				volControl.setFocusable(true);
				refreshVolumeText(newLevel);
			}
			return true;
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			if (action == KeyEvent.ACTION_DOWN) {
				SeekBar volControl = (SeekBar) findViewById(R.id.volbar);
				int level = volControl.getProgress();
				int newLevel = level - 1;
				volControl.setProgress(newLevel);
				volControl.setFocusable(true);
				refreshVolumeText(newLevel);
			}
			return true;
		default:
			return super.dispatchKeyEvent(event);
		}
	}

	public void refreshVolumeText(int vol) {
		TextView tv = (TextView) findViewById(R.id.statusvolume);
		if (vol == 0) {
			tv.setText("Volume: " + VolumeConverter.minus35db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus35db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus35db.getConvertedVol());
		} else if (vol == 1) {
			tv.setText("Volume: " + VolumeConverter.minus30db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus30db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus30db.getConvertedVol());
		} else if (vol == 2) {
			tv.setText("Volume: " + VolumeConverter.minus25db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus25db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus25db.getConvertedVol());
		} else if (vol == 3) {
			tv.setText("Volume: " + VolumeConverter.minus24db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus24db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus24db.getConvertedVol());
		} else if (vol == 4) {
			tv.setText("Volume: " + VolumeConverter.minus23db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus23db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus23db.getConvertedVol());
		} else if (vol == 5) {
			tv.setText("Volume: " + VolumeConverter.minus22db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus22db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus22db.getConvertedVol());
		} else if (vol == 6) {
			tv.setText("Volume: " + VolumeConverter.minus21db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus21db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus21db.getConvertedVol());
		} else if (vol == 7) {
			tv.setText("Volume: " + VolumeConverter.minus20db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus20db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus20db.getConvertedVol());
		} else if (vol == 8) {
			tv.setText("Volume: " + VolumeConverter.minus19db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus19db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus19db.getConvertedVol());
		} else if (vol == 9) {
			tv.setText("Volume: " + VolumeConverter.minus18db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus18db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus18db.getConvertedVol());
		} else if (vol == 10) {
			tv.setText("Volume: " + VolumeConverter.minus17db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus17db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus17db.getConvertedVol());
		} else if (vol == 11) {
			tv.setText("Volume: " + VolumeConverter.minus16db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus16db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus16db.getConvertedVol());
		} else if (vol == 12) {
			tv.setText("Volume: " + VolumeConverter.minus15db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus15db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus15db.getConvertedVol());
		} else if (vol == 13) {
			tv.setText("Volume: " + VolumeConverter.minus14db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus14db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus14db.getConvertedVol());
		} else if (vol == 14) {
			tv.setText("Volume: " + VolumeConverter.minus13db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus13db.getConvertedVol());
			updateVolumeInSharedPreferences(VolumeConverter.minus13db.getConvertedVol());
		}

	}

	public void volmute(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_VOL_MUTE);
	}

	public void refresh(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_REFRESH_LISTENING);
		updateTextViews();
	}

	// /**
	// * holt die Lautstraerke von Receiver
	// */
	// public void refreshVolume() {
	// TextView tv = (TextView) findViewById(R.id.statusvolume);
	// String msg = getIntent().getStringExtra("volume");
	// tv.setText("Volume: " + msg);
	//
	// }

	public void updateTextViews() {
		SharedPreferences settings = getSharedPreferences(GlobalConstants.PREFS_ONKYO, 0);
		String listeningMode = settings.getString(GlobalConstants.PREFS_LISTENING_MODE, "");
		String volume = settings.getString(GlobalConstants.PREFS_VOLUME, "");
		String source = settings.getString(GlobalConstants.PREFS_SOURCE, "");
		TextView tvVolume = (TextView) findViewById(R.id.statusvolume);
		tvVolume.setText("Volume: " + volume);
		TextView tvListentingMode = (TextView) findViewById(R.id.statuslisteningmode);
		tvListentingMode.setText(listeningMode);
		TextView tvSource = (TextView) findViewById(R.id.statusinput);
		tvSource.setText("Input: " + source);

	}

	/**
	 * speichert die Lautstärke in den Shared Preferences
	 * 
	 * @param volume
	 */
	public void updateVolumeInSharedPreferences(String volume) {
		SharedPreferences onkyoData = getSharedPreferences(GlobalConstants.PREFS_ONKYO, 0);
		SharedPreferences.Editor editor = onkyoData.edit();
		editor.putString(GlobalConstants.PREFS_VOLUME, volume);
		editor.commit();
	}

	/**
	 * speichert die Quelle in den Shared Preferences
	 * 
	 * @param source
	 */
	public void updateSourceInSharedPreferences(String source) {
		SharedPreferences onkyoData = getSharedPreferences(GlobalConstants.PREFS_ONKYO, 0);
		SharedPreferences.Editor editor = onkyoData.edit();
		editor.putString(GlobalConstants.PREFS_SOURCE, source);
		editor.commit();
	}

	/**
	 * speichert Lautstärke und Quelle in den Shared Preferences
	 * 
	 * @param volume
	 * @param source
	 */
	public void writeSharedPreferences(String volume, String source) {
		updateVolumeInSharedPreferences(volume);
		updateSourceInSharedPreferences(source);
	}

}
