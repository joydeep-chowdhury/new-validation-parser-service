package com.wipro.holmes.uhg.model;

public class GSFOptionalModel {
	private String formerEEID;
	private String personnelId;

	public GSFOptionalModel() {
	}

	public GSFOptionalModel(String formerEEID, String personnelId) {
		super();
		this.formerEEID = formerEEID;
		this.personnelId = personnelId;
	}

	public String getFormerEEID() {
		return formerEEID;
	}

	public void setFormerEEID(String formerEEID) {
		this.formerEEID = formerEEID;
	}

	public String getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	@Override
	public String toString() {
		return "GSFOptionalModel [formerEEID=" + formerEEID + ", personnelId=" + personnelId + "]";
	}

}
