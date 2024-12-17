package com.example.sample_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sample_project.payload.UsersDto;
import com.example.sample_project.service.Userservice;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private Userservice userservice;

	@PostMapping("/register")
	public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto) {
		return new ResponseEntity<>(userservice.createUser(usersDto),HttpStatus.CREATED);	
	}

}
