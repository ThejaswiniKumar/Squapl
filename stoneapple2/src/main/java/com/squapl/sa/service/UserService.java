package com.squapl.sa.service;

import java.util.List;

import com.squapl.sa.domain.Roles;
import com.squapl.sa.domain.User;

public interface UserService {
	
	Iterable<User> findAll();
	
	public User findOne(Long id);
	
	public User findByUsername(String username);
	
	public User CreateUser(User user);
	
	public User UpdateUser(User user);
	
	public void DeleteUser(Long id);
	
}
