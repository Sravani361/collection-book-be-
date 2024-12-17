package com.example.sample_project.service;

import com.example.sample_project.payload.UsersDto;

public interface Userservice {
	
	public UsersDto createUser(UsersDto usersDto);
	public UsersDto loginUser(UsersDto usersDto);
	public UsersDto getData(UsersDto usersDto);
}
