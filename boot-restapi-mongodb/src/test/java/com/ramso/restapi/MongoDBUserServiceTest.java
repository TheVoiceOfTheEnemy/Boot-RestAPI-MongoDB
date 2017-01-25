package com.ramso.restapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MongoDBUserServiceTest {

	private static final String ID = "id";
	private static final String NAME = "name";
	private static final int CREDITS = 0;
	
	@Mock
	private UserRepository repository;
	private MongoDBUserService service;
	
	@Before 
	public void setUp(){ //simulate DI 
		this.service = new MongoDBUserService(repository);
	}
	
	@Test
	public void create_ShouldHaveNewUser(){
		//todo
	}
	
}//>>MongoDBUserServiceTest
