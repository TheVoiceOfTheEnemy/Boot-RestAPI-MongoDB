package com.ramso.restapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






/*
 * Implementation of UserService interface for saving objects in the MongoDB
 * 
 * Use of slf4j for method logging
 * 
 */


@Service
final class MongoDBUserService implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBUserService.class);
	
	private final UserRepository repository;
	
	@Autowired
	MongoDBUserService(UserRepository repository){
		this.repository = repository;
	}
	
	
	@Override
	public UserDTO create(UserDTO user) {
		LOGGER.info("Creating a new user entry with data: {}", user);
		
		User persisted = User.getBuilder()
				.name(user.getName())
				.credits(user.getCredits())
				//.isAdmin(user.getIsAdmin())
				.build();
		LOGGER.info("After build: {}", persisted);
		persisted = repository.save(persisted);
        LOGGER.info("Created a new user entry with data: {}", persisted);
		
		return convertToDTO(persisted);
	}

	@Override
	public UserDTO delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	 private UserDTO convertToDTO(User model) {
		 	UserDTO dto = new UserDTO();

	        dto.setId(model.getId());
	        dto.setName(model.getName());
	        dto.setCredits(model.getCredits());
	       // dto.setIsAdmin(model.getIsAdmin());

	        return dto;
	    }
	
}
