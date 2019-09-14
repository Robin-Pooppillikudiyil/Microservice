package com.microservice.photoapp.api.users.ui.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.photoapp.api.users.data.UserEntity;
import com.microservice.photoapp.api.users.data.UserRepository;
import com.microservice.photoapp.api.users.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.userRepository = userRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}

	@Override
	public UserDto createUser(UserDto userdto) {
		userdto.setUserId(UUID.randomUUID().toString());
		userdto.setEncryptedPassword(bCryptPasswordEncoder.encode(userdto.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userdto, UserEntity.class); // source,destination.
		
		userRepository.save(userEntity);
		
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

}
