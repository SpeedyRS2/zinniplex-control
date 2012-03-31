package de.zinniplex.eventghost;

public interface EventGhostCommands {

	// Onkyo Commands
	public static final String COMMAND_VOL_UP = "VolUp";
	public static final String COMMAND_VOL_DOWN = "VolDown";
	public static final String COMMAND_VOL_MUTE = "VolMute";

	public static final String COMMAND_VOL_13DB = "Vol-13db";
	public static final String COMMAND_VOL_15DB = "Vol-15db";
	public static final String COMMAND_VOL_18DB = "Vol-18db";
	public static final String COMMAND_VOL_21DB = "Vol-21db";
	public static final String COMMAND_VOL_24DB = "Vol-24db";
	public static final String COMMAND_VOL_35DB = "Vol-35db";

	public static final String COMMAND_LISTEN_PL_2_MOVIE = "listenPL2Movie";
	public static final String COMMAND_LISTEN_PL_2_MUSIC = "listenPL2Music";
	public static final String COMMAND_LISTEN_ALL_CH_STEREO = "listenAllChanelStereo";
	public static final String COMMAND_PREV_LISTEN = "prevListenMode";
	public static final String COMMAND_NEXT_LISTEN = "nextListenMode";

	public static final String COMMAND_REFRESH_LISTENING = "refreshListening";

	// Lights
	public static final String COMMAND_SWITCH_SPOTS = "switch_Spots";
	public static final String COMMAND_SPOTS_PRESSED = "spots_Pressed";
	public static final String COMMAND_SPOTS_RELEASED = "spots_Released";
	public static final String COMMAND_SWITCH_SAUELEN = "switch_Sauelen";
	public static final String COMMAND_SAEULEN_PRESSED = "saeulen_Pressed";
	public static final String COMMAND_SAEULEN_RELEASED = "saeulen_Released";

	// Fan
	public static final String COMMAND_FAN_ON = "fan_On";
	public static final String COMMAND_FAN_OFF = "fan_Off";

	// Mask
	public static final String COMMAND_MASK_169 = "mask169";
	public static final String COMMAND_MASK_219 = "mask219";
	public static final String COMMAND_MASK_OPEN_PRESSED = "mask_Open_Pressed";
	public static final String COMMAND_MASK_OPEN_RELEASED = "mask_Open_Released";
	public static final String COMMAND_MASK_CLOSE_PRESSED = "mask_Close_Pressed";
	public static final String COMMAND_MASK_CLOSE_RELEASED = "mask_Close_Released";

	// Blu-ray
	public static final String COMMAND_BR_PLAY = "bluray_play";
	public static final String COMMAND_BR_STOP = "bluray_stop";
	public static final String COMMAND_BR_SKIP_FORWARD = "bluray_skipFW";
	public static final String COMMAND_BR_SKIP_BACK = "bluray_skipBack";
	public static final String COMMAND_BR_SEEK_FORWARD = "bluray_seekFW";
	public static final String COMMAND_BR_SEEK_BACK = "bluray_seekBack";
	public static final String COMMAND_BR_ARROW_TOP = "bluray_top";
	public static final String COMMAND_BR_ARROW_DOWN = "bluray_down";
	public static final String COMMAND_BR_ARROW_LEFT = "bluray_left";
	public static final String COMMAND_BR_ARROW_RIGHT = "bluray_right";
	public static final String COMMAND_BR_MENU = "bluray_menu";
	public static final String COMMAND_BR_POPUP_MENU = "bluray_popupmenu";
	public static final String COMMAND_BR_AUDIO = "bluray_audio";
	public static final String COMMAND_BR_DISPLAY = "bluray_display";

}
