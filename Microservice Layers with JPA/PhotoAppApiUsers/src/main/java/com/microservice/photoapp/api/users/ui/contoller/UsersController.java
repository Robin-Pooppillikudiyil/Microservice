package com.microservice.photoapp.api.users.ui.contoller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.photoapp.api.model.CreateUserRequestModel;
import com.microservice.photoapp.api.users.shared.UserDto;
import com.microservice.photoapp.api.users.ui.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment evn;

	@Autowired
	private UserService userService;

	@GetMapping("/status/check") /// users/status/check
	public String status() {
		return "Working on port" + evn.getProperty("local.server.port");
	}

	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userdto = modelMapper.map(createUserRequestModel, UserDto.class);
		userService.createUser(userdto);
		return "user createed with createUserModel";

	}

}
