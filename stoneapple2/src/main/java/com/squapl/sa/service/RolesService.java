package com.squapl.sa.service;

import java.util.Collection;

import com.squapl.sa.domain.Roles;
import com.squapl.sa.domain.User;

public interface RolesService {
	
	public Collection<Roles> findAll();
	
	public Roles findOne(Long id);
	
	public Roles findByName(String name);
	
	public Roles CreateRoles(Roles roles);
	
	public Roles UpdateRoles(Roles roles);
	
	public void deleteRoles(Long id);
	

}
