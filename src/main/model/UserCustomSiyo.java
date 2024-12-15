package main.model;

import java.util.List;

public class UserCustomSiyo {
	private String koujiNum;
	private String spaceFinderId;
	private String shohinCode;
	private List<String> jutoCodes;
	private String bikou;
	
	public UserCustomSiyo(String koujiNum, String spaceFinderId, String shohinCode, List<String> jutoCodes,
			String bikou) {
		this.koujiNum = koujiNum;
		this.spaceFinderId = spaceFinderId;
		this.shohinCode = shohinCode;
		this.jutoCodes = jutoCodes;
		this.bikou = bikou;
	}
	
	public UserCustomSiyo() {
	}

	public String getKoujiNum() {
		return koujiNum;
	}

	public void setKoujiNum(String koujiNum) {
		this.koujiNum = koujiNum;
	}

	public String getSpaceFinderId() {
		return spaceFinderId;
	}

	public void setSpaceFinderId(String spaceFinderId) {
		this.spaceFinderId = spaceFinderId;
	}

	public String getShohinCode() {
		return shohinCode;
	}

	public void setShohinCode(String shohinCode) {
		this.shohinCode = shohinCode;
	}

	public List<String> getJutoCodes() {
		return jutoCodes;
	}

	public void setJutoCodes(List<String> jutoCodes) {
		this.jutoCodes = jutoCodes;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
	
	
}
