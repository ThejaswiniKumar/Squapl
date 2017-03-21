package com.squapl.sa.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Article;
import com.squapl.sa.domain.Roles;
import com.squapl.sa.domain.RolesRepository;
import com.squapl.sa.domain.User;
import com.squapl.sa.domain.UserRepository;;

@Service
public class UserServiceBean implements UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	public Iterable<User> findAll() {
	Iterable<User> user= userRepository.findAll();
	System.out.println("findAll is Running");
	return user;
	}
	
	@Override

	public User findOne(Long id){
	User user=userRepository.findOne(id);
	System.out.println("findOne is running"  + user.toString());
	return user;
	}
	

	@Cacheable(value="user", key="#id")
	public User findByUsername(String username){
	User user=userRepository.findByUsername(username);
	System.out.println("findByUserName is running"  + user.getUsername());
	return user;
	}
	
	
	@Override
	public User CreateUser(User user){
	User savedUser=userRepository.save(user); 
	if(user.getId()!=null)
	{
	System.out.println("Nothing to create");
	return null;
	}
	User createdUser=userRepository.save(user);
	System.out.println("user created");
	return createdUser;
	}
	
	@Override
	public User UpdateUser(User user){
	User persistedUser=findOne(user.getId());
	if(persistedUser==null)
	{
	System.out.println("nothing to update");
	return null;
	}
	User updatedUser=userRepository.save(user);
	System.out.println("user updated");
	return updatedUser;
	}
	
	@Override
	public void DeleteUser(Long id) {
	System.out.println("user deleted");
	userRepository.delete(id);
	}

	
}





