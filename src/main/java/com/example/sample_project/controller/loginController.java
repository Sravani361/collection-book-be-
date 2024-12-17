package com.example.sample_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sample_project.payload.UsersDto;
import com.example.sample_project.service.Userservice;

@RestController
@RequestMapping("/api/auth")
public class loginController {
	
	@Autowired
	private Userservice userservice;
	
	@PostMapping("/login")
	public ResponseEntity<UsersDto> loginUser(@RequestBody UsersDto usersDto) {
		return new ResponseEntity<>(userservice.loginUser(usersDto),HttpStatus.OK);
		
	}
	
	@GetMapping("/get-data")
	public ResponseEntity<UsersDto> getData(@RequestBody UsersDto usersDto) {
		return new ResponseEntity<>(userservice.getData(usersDto),HttpStatus.OK);
	}


}
