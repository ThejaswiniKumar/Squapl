package com.squapl.sa.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.domain.Roles;
import com.squapl.sa.domain.User;
import com.squapl.sa.service.RolesService;
import com.squapl.sa.service.UserService;

@RestController
public class RolesController 
{
	@Autowired
	private RolesService rolesService;
	
	@RequestMapping( value = "/roles/registration",
			 		 method = RequestMethod.GET,
			 		 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Roles>> getRoles()
	{
		System.out.println("get roles");
		Collection<Roles> roles= rolesService.findAll();
		System.out.println(" All Roles are working fine");
		return new ResponseEntity<Collection<Roles>>(roles, HttpStatus.OK);
	}
		
		@RequestMapping(
		   value = "/roles/registration/{id}",
		   method = RequestMethod.GET,
		   produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Roles> getRoles(@PathVariable("id") Long id)
		{
		Roles roles =  rolesService.findOne(id);
		if (roles== null) 
		{
			System.out.println("No roles");
		   return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}   
		   System.out.println("Role id is fine");
		   return new ResponseEntity<Roles>(roles, HttpStatus.OK);
		}

		@RequestMapping(
		   value = "/roles/registration",
		   method = RequestMethod.POST,
		   consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Roles> createRoles(@RequestBody Roles roles)
		{
		Roles createRoles =  rolesService.CreateRoles(roles);
		System.out.println("Roles created");
		return new ResponseEntity<Roles>(createRoles,HttpStatus.OK);
		}
		
		@RequestMapping(
		   value = "/roles/registration/{id}",
		   method = RequestMethod.PUT,
		   consumes = MediaType.APPLICATION_JSON_VALUE,
		   produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Roles> updateUser(@RequestBody Roles roles) {
		Roles updatedRoles = rolesService.UpdateRoles(roles);
		if (updatedRoles == null)
		{
		   System.out.println("Nothing to update");
		   return new ResponseEntity<Roles>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		   System.out.println("Roles update");
		   return new ResponseEntity<Roles>(updatedRoles, HttpStatus.OK);
		}

		@RequestMapping(
		   value = "/roles/registration/{id}",
		   method = RequestMethod.DELETE,
		   consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Roles> deleteRoles(@PathVariable ("id") Long id)
		{
			 rolesService.deleteRoles(id);
			 System.out.println("role deleted");
			 return new ResponseEntity<Roles>(HttpStatus.NO_CONTENT);
		}
}



