package com.ramso.restapi;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/users/")
final class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService service;
	
	@Autowired
	UserController(UserService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	UserDTO create(@RequestBody @Valid UserDTO newEntry){
		LOGGER.info("Creating a new user entry with information: {}", newEntry);
		
		UserDTO created = service.create(newEntry);
		
		LOGGER.info("Created a new user with information: {}", created);
		
		return newEntry;
		
	}
	
}
