package com.wipro.holmes.uhg.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	private List<ErrorMessage> errorMessages;

	public ErrorResponse() {
		errorMessages=new ArrayList<ErrorMessage>();
	}

	public ErrorResponse(List<ErrorMessage> errorMessages) {
		super();
		this.errorMessages = errorMessages;
	}

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorMessages=" + errorMessages + "]";
	}

}
