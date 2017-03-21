package com.squapl.sa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Roles;
import com.squapl.sa.domain.RolesRepository;
import com.squapl.sa.domain.User;

@Service
public class RolesServiceBean implements RolesService{

    @Autowired
    private RolesRepository rolesRepository;
    
    
    @Override
	public Collection <Roles> findAll() 
    {
		System.out.println("Start findAll");
		Collection <Roles> roles= rolesRepository.findAll();
		System.out.println("findAll is Running");
		return roles;
	}

	@Override
	public Roles findOne(Long id) 
	{
		Roles roles=rolesRepository.findOne(id);
		System.out.println("findOne is running"  + roles.toString());
		return roles;
	}

	@Override
	public Roles findByName(String name) 
	{
		Roles roles=rolesRepository.findByName(name);
		System.out.println("findByName is running"  + roles.getName());
		return roles;
	}
	
	@Override
	public Roles CreateRoles(Roles roles) 
	{
		Roles rolesCreation =rolesRepository.save(roles); 
		if(roles.getId()!=null)
		{
		System.out.println("no data");
		return null;
		}
		Roles createdRoles=rolesRepository.save(roles);
		System.out.println("roles created");
		return createdRoles;
	}

	@Override
	public Roles UpdateRoles(Roles roles)
	{
		Roles persistedRoles=findOne(roles.getId());
		if(persistedRoles==null)
		{
		System.out.println("Nothing to update");
		return null;
		}
		Roles rolesUpdated=rolesRepository.save(roles);
		System.out.println("Roles updated");
		return rolesUpdated;
	}

	@Override
	public void deleteRoles(Long id)
	{
	rolesRepository.delete(id);
	System.out.println("specific role deleted"); 
	}

	
	
}
