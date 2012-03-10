package de.zinniplex;

public enum VolumeConverter {
		minus13db(69, "-13db", 14),
		minus14db(68, "-14db", 13),
		minus15db(67, "-15db", 12),
		minus16db(66, "-16db", 11),
		minus17db(65, "-17db", 10),
		minus18db(64, "-18db", 9),
		minus19db(63, "-19db", 8),
		minus20db(62, "-20db", 7),
		minus21db(61, "-21db", 6),
		minus22db(60, "-22db", 5),
		minus23db(59, "-23db", 4),
		minus24db(58, "-24db", 3),
		minus25db(57, "-25db", 2),
		minus30db(52, "-30db", 1),
		minus35db(47, "-35db", 0);

	private int vol;
	private String convertedVol;
	private int seekBarValue;

	VolumeConverter(int vol, String convertedVol, int seekBarValue) {
		this.vol = vol;
		this.convertedVol = convertedVol;
		this.seekBarValue = seekBarValue;

	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getConvertedVol() {
		return convertedVol;
	}

	public void setConvertedVol(String convertedVol) {
		this.convertedVol = convertedVol;
	}

	public int getSeekBarValue() {
		return seekBarValue;
	}

	public void setSeekBarValue(int seekBarValue) {
		this.seekBarValue = seekBarValue;
	}

}
