package com.microservice.app.ws.exception;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String name;

	public ErrorMessage() {
	}

	public ErrorMessage(Date date, String localizedMessage) {

	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
