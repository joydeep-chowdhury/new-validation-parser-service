package com.wipro.holmes.uhg.model;

public class ErrorMessage {
	private String field;
	private String message;
	private String code;

	public ErrorMessage() {
	}

	public ErrorMessage(String field, String message, String code) {
		super();
		this.field = field;
		this.message = message;
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ErrorMessage [field=" + field + ", message=" + message + ", code=" + code + "]";
	}

}
