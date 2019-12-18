package com.wipro.holmes.uhg.model;

public class LogModel {
	private ErrorResponse errorResponse;
    private Integer record;
	
	public LogModel() {
	}

	public LogModel(ErrorResponse errorResponse, Integer record) {
		super();
		this.errorResponse = errorResponse;
		this.record = record;
	}

	
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "LogModel [errorResponse=" + errorResponse + ", record=" + record + "]";
	}

	

}
