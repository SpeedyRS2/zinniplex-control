package de.zinniplex;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TabHost;

public class MainTabWidget extends TabActivity {
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
		lp.screenBrightness = 0.1f;
		getWindow().setAttributes(lp);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
