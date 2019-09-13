package com.microservice.photoapp.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	
	//firstName,lastName,password,email
	
	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, message = "First name must not be less than two characters")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	@Size(min = 2, message = "First name must not be less than two characters")
	private String lastName;

	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, max = 16, message = "First name must not be less than two characters")
	private String password;

	@NotNull(message = "Email cannot be null")
	@Email
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
