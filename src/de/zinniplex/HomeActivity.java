package de.zinniplex;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import de.zinniplex.eventghost.EventGhostCommands;

public class HomeActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home_layout);
		SeekBar volControl = (SeekBar) findViewById(R.id.volbar);
		//
		// LinearGradient test = new LinearGradient(0.f, 0.f, 500.f, 0.0f,
		// Color.YELLOW, Color.RED, TileMode.CLAMP);
		// ShapeDrawable shape = new ShapeDrawable(new RectShape());
		// shape.getPaint().setShader(test);
		//
		// volControl.setProgressDrawable((Drawable) shape);
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
		} else if (vol == 1) {
			tv.setText("Volume: " + VolumeConverter.minus30db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus30db.getConvertedVol());
		} else if (vol == 2) {
			tv.setText("Volume: " + VolumeConverter.minus25db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus25db.getConvertedVol());
		} else if (vol == 3) {
			tv.setText("Volume: " + VolumeConverter.minus24db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus24db.getConvertedVol());
		} else if (vol == 4) {
			tv.setText("Volume: " + VolumeConverter.minus23db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus23db.getConvertedVol());
		} else if (vol == 5) {
			tv.setText("Volume: " + VolumeConverter.minus22db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus22db.getConvertedVol());
		} else if (vol == 6) {
			tv.setText("Volume: " + VolumeConverter.minus21db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus21db.getConvertedVol());
		} else if (vol == 7) {
			tv.setText("Volume: " + VolumeConverter.minus20db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus20db.getConvertedVol());
		} else if (vol == 8) {
			tv.setText("Volume: " + VolumeConverter.minus19db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus19db.getConvertedVol());
		} else if (vol == 9) {
			tv.setText("Volume: " + VolumeConverter.minus18db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus18db.getConvertedVol());
		} else if (vol == 10) {
			tv.setText("Volume: " + VolumeConverter.minus17db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus17db.getConvertedVol());
		} else if (vol == 11) {
			tv.setText("Volume: " + VolumeConverter.minus16db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus16db.getConvertedVol());
		} else if (vol == 12) {
			tv.setText("Volume: " + VolumeConverter.minus15db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus15db.getConvertedVol());
		} else if (vol == 13) {
			tv.setText("Volume: " + VolumeConverter.minus14db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus14db.getConvertedVol());
		} else if (vol == 14) {
			tv.setText("Volume: " + VolumeConverter.minus13db.getConvertedVol());
			new SubmitCommandAsyncTask().execute(VolumeConverter.minus13db.getConvertedVol());
		}
		// if (vol == 0) {
		// tv.setText("Volume: " + VolumeConverter.minus35db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus35db.getConvertedVol());
		// } else if (vol == 1) {
		// tv.setText("Volume: " + VolumeConverter.minus30db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus30db.getConvertedVol());
		// } else if (vol == 2) {
		// tv.setText("Volume: " + VolumeConverter.minus25db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus25db.getConvertedVol());
		// } else if (vol == 3) {
		// tv.setText("Volume: " + VolumeConverter.minus24db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus24db.getConvertedVol());
		// } else if (vol == 4) {
		// tv.setText("Volume: " + VolumeConverter.minus23db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus23db.getConvertedVol());
		// } else if (vol == 5) {
		// tv.setText("Volume: " + VolumeConverter.minus22db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus22db.getConvertedVol());
		// } else if (vol == 6) {
		// tv.setText("Volume: " + VolumeConverter.minus21db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus21db.getConvertedVol());
		// } else if (vol == 7) {
		// tv.setText("Volume: " + VolumeConverter.minus20db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus20db.getConvertedVol());
		// } else if (vol == 8) {
		// tv.setText("Volume: " + VolumeConverter.minus19db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus19db.getConvertedVol());
		// } else if (vol == 9) {
		// tv.setText("Volume: " + VolumeConverter.minus18db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus18db.getConvertedVol());
		// } else if (vol == 10) {
		// tv.setText("Volume: " + VolumeConverter.minus17db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus17db.getConvertedVol());
		// } else if (vol == 11) {
		// tv.setText("Volume: " + VolumeConverter.minus16db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus16db.getConvertedVol());
		// } else if (vol == 12) {
		// tv.setText("Volume: " + VolumeConverter.minus15db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus15db.getConvertedVol());
		// } else if (vol == 13) {
		// tv.setText("Volume: " + VolumeConverter.minus14db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus14db.getConvertedVol());
		// } else if (vol == 14) {
		// tv.setText("Volume: " + VolumeConverter.minus13db.getConvertedVol());
		// HttpSender.sendCommand(VolumeConverter.minus13db.getConvertedVol());
		// }
	}

	public void switchspots(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SPOTS);
		// HttpSender.sendCommand(EventGhostCommands.COMMAND_SWITCH_SPOTS);
	}

	public void switchsaeulen(View view) {
		// Button bt = (Button) findViewById(R.id.switchsaeulen);
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_SWITCH_SAUELEN);
	}

	public void volmute(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_VOL_MUTE);
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

	public void refresh(View view) {
		new SubmitCommandAsyncTask().execute(EventGhostCommands.COMMAND_REFRESH_LISTENING);
		updateTextViews();
	}

	public void refreshVolume() {
		TextView tv = (TextView) findViewById(R.id.statusvolume);
		String msg = getIntent().getStringExtra("volume");
		tv.setText("Volume: " + msg);

	}

	public void updateTextViews() {
		SharedPreferences settings = getSharedPreferences(GlobalConstants.PREFS_ONKYO, 0);
		String listeningMode = settings.getString(GlobalConstants.PREFS_LISTENING_MODE, "");
		TextView tv = (TextView) findViewById(R.id.statuslisteningmode);
		tv.setText(listeningMode);

	}

}
