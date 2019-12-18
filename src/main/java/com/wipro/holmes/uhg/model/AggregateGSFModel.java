package com.wipro.holmes.uhg.model;

public class AggregateGSFModel {
	private GSFModel gsfModel;
	private GSFOptionalModel gsfOptionalModel;

	public AggregateGSFModel() {
	}

	public AggregateGSFModel(GSFModel gsfModel, GSFOptionalModel gsfOptionalModel) {
		super();
		this.gsfModel = gsfModel;
		this.gsfOptionalModel = gsfOptionalModel;
	}

	public GSFModel getGsfModel() {
		return gsfModel;
	}

	public void setGsfModel(GSFModel gsfModel) {
		this.gsfModel = gsfModel;
	}

	public GSFOptionalModel getGsfOptionalModel() {
		return gsfOptionalModel;
	}

	public void setGsfOptionalModel(GSFOptionalModel gsfOptionalModel) {
		this.gsfOptionalModel = gsfOptionalModel;
	}

	@Override
	public String toString() {
		return "AggregateGSFModel [gsfModel=" + gsfModel + ", gsfOptionalModel=" + gsfOptionalModel + "]";
	}

}
