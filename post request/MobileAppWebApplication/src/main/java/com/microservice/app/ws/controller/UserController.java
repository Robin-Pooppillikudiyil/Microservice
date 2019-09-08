package com.microservice.app.ws.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.app.ws.model.request.UserRequestModel;
import com.microservice.app.ws.model.response.UserResponseModel;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	Map<String, UserResponseModel> users;

	
	/**	GetMapping	*/
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "2") int page,
			@RequestParam(value = "limit", defaultValue = "30") int limit) {
		return "Get users was called with page : " + page + " and limit " + limit;
	}

	@GetMapping(path = "/{userId}", 
			produces = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					})

	public ResponseEntity<UserResponseModel> getUser(@PathVariable int userId) {

		if(users.containsKey(userId)){
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}
	
	
	
	
	
	/**	GetMapping	*/

	@PostMapping(
			produces = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					},consumes={ 
							MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE 
							})
			
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequest) {
		
		
		UserResponseModel userResponse = new UserResponseModel();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setEmail(userRequest.getEmail());

		String userId=UUID.randomUUID().toString(); //random userId.
		userResponse.setUserId(userId);
		if(users==null) 
			users=new HashMap<>();
		users.put(userId,userResponse);
		
		return new ResponseEntity<UserResponseModel>(userResponse,HttpStatus.OK);
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
