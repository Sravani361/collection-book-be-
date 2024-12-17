package com.example.sample_project.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sample_project.entity.Users;
import com.example.sample_project.payload.UsersDto;
import com.example.sample_project.repository.Userrepo;
import com.example.sample_project.service.Userservice;

@Service
public class UsersserviceImple implements Userservice {
	
	@Autowired
	private Userrepo userrepo;
	
	@Override
	public UsersDto createUser(UsersDto usersDto) {
		Users user=usersDtoToEntity(usersDto);
		Users saveduser=userrepo.save(user);
		return entityToUsersDto(saveduser);
	}
	private Users usersDtoToEntity(UsersDto usersDto) {
		Users users=new Users();
		users.setFirstname(usersDto.getFirstname());
		users.setLastname(usersDto.getLastname());
		users.setPhonenumber(usersDto.getPhonenumber());
		users.setEmail(usersDto.getEmail());
		users.setPassword(usersDto.getPassword());
		users.setDOB(usersDto.getDob());
		return users;
	}
	
	private UsersDto entityToUsersDto(Users saveduser) {
		UsersDto usersDto=new UsersDto();
		usersDto.setId(saveduser.getID());
		usersDto.setFirstname(saveduser.getFirstname());
		usersDto.setLastname(saveduser.getLastname());
		usersDto.setPhonenumber(saveduser.getPhonenumber());
		usersDto.setEmail(saveduser.getEmail());
		usersDto.setPassword(saveduser.getPassword());
		usersDto.setDob(saveduser.getDob());
		return usersDto;
	}
	
	@Override
	public UsersDto loginUser(UsersDto usersDto) {
		Users user1=userrepo.findByEmail(usersDto.getEmail());
		if(user1!=null && user1.getPassword().equals(usersDto.getPassword())) {
			return entityToUsersDto(user1);
		}
		else {
			return null;
		}
	}
	
	@Override
	public UsersDto getData(UsersDto usersDto) {
		Optional<Users> user2=userrepo.findById(usersDto.getId());
		return user2.map(this::entityToUsersDto).orElse(null);
	}
	 
}
