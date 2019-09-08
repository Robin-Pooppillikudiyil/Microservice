package com.microservice.app.ws.model.response;

public class UserResponseModel {

	public String firstName;
	public String lastName;
	public String email;
	public String userId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
