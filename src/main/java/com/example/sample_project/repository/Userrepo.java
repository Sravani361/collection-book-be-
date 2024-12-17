package com.example.sample_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sample_project.entity.Users;

public interface Userrepo extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
	public Optional<Users> findById(Long id);

}