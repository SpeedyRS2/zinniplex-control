package de.zinniplex;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TabHost;
import de.zinniplex.activities.BlurayActivity;
import de.zinniplex.activities.HomeActivity;
import de.zinniplex.activities.LightActivity;
import de.zinniplex.activities.MaskActivity;
import de.zinniplex.activities.OnkyoActivity;

public class MainTabWidget extends TabActivity {

	private static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
	private static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
	private static final int SCREEN_BRIGHTNESS_MODE_AUTO = 1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initializeScreen();

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, HomeActivity.class);
		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost.newTabSpec("Home").setIndicator("Home", res.getDrawable(R.drawable.ic_tab_home))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, OnkyoActivity.class);
		spec = tabHost.newTabSpec("Onkyo").setIndicator("Onkyo").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, BlurayActivity.class);
		spec = tabHost.newTabSpec("Blu-ray").setIndicator("Blu-ray").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, LightActivity.class);
		spec = tabHost.newTabSpec("Light").setIndicator("Light").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, MaskActivity.class);
		spec = tabHost.newTabSpec("Mask").setIndicator("Mask").setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}

	/**
	 * Helligkeit der App ganz runter regeln und den Portraitmodus fest vorgeben
	 */
	private void initializeScreen() {
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		Settings.System.putInt(getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_MANUAL);
		lp.buttonBrightness = 1f;
		lp.screenBrightness = 0.1f;
		getWindow().setAttributes(lp);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		switch (item.getItemId()) {
		case R.id.dimlevelmin:
			// Screenbrightness auf Max gesetzt
			Settings.System.putInt(getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_MANUAL);
			lp.screenBrightness = 0.1f;
			getWindow().setAttributes(lp);
			return true;
		case R.id.dimlevelmax:
			// Screenbrightness auf Min gesetzt
			Settings.System.putInt(getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_MANUAL);
			lp.screenBrightness = 1f;
			getWindow().setAttributes(lp);
			return true;

		case R.id.beenden:
			// Anwendung wird beendet, Screenbrightness wieder auf Auto gesetzt
			Settings.System.putInt(getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_AUTO);
			super.finish();

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void finish() {
		// Anwendung wird beendet, Screenbrightness wieder auf Auto gesetzt
		Settings.System.putInt(getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_AUTO);
		// TODO Auto-generated method stub
		super.finish();
	}
	
	

}
