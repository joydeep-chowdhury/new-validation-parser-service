package com.wipro.holmes.uhg.model;

import java.util.List;

public class GenericResponseModel 
{
     private List responseObject;
     
     public GenericResponseModel() {}

	public GenericResponseModel(List responseObject) {
		super();
		this.responseObject = responseObject;
	}

	public List getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(List responseObject) {
		this.responseObject = responseObject;
	}

	@Override
	public String toString() {
		return "GenericResponseModel [responseObject=" + responseObject + "]";
	}
     
}
