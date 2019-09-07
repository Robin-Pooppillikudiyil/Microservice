package com.microservice.app.ws.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.app.ws.model.UserRest;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "2") int page,
			@RequestParam(value = "limit", defaultValue = "30") int limit) {
		return "Get users was called with page : " + page + " and limit " + limit;
	}

	@GetMapping(path="/{userId}",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					})
	
	public UserRest getUser(@PathVariable int userId) {
		
		UserRest userRest = new UserRest();
		userRest.setFirstName("Robin");
		userRest.setLastName("Thomas");
		userRest.setEmail("robin@gmail.com");
		userRest.setUserId(userId);

		return userRest;
	}

	@PostMapping
	public String createUser() {
		return "Create user was called";
	}

	@PutMapping
	public String updateUser() {
		return "Update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user was called";
	}
}
