package com.wipro.holmes.uhg.model;

import java.util.List;

public class ResponseModel {
    private List<AggregateGSFModel> responseObject;
    
    public ResponseModel() {}

	public ResponseModel(List<AggregateGSFModel> responseObject) {
		super();
		this.responseObject = responseObject;
	}

	public List<AggregateGSFModel> getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(List<AggregateGSFModel> responseObject) {
		this.responseObject = responseObject;
	}

	@Override
	public String toString() {
		return "ResponseModel [responseObject=" + responseObject + "]";
	}
    
}
