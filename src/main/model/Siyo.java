package main.model;

public class Siyo {
	private int siyoId;
	private String koujiNum;
	private String shohinCd;

	public Siyo(int siyoId, String koujiNum, String shohinCd) {
		this.siyoId = siyoId;
		this.koujiNum = koujiNum;
		this.shohinCd = shohinCd;
	}

	public int getSiyoId() {
		return siyoId;
	}

	public void setSiyoId(int siyoId) {
		this.siyoId = siyoId;
	}

	public String getKoujiNum() {
		return koujiNum;
	}

	public void setKoujiNum(String koujiNum) {
		this.koujiNum = koujiNum;
	}

	public String getShohinCd() {
		return shohinCd;
	}

	public void setShohinCd(String shohinCd) {
		this.shohinCd = shohinCd;
	}
}
