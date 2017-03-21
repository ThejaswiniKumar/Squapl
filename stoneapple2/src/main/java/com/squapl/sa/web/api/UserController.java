package com.squapl.sa.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.squapl.sa.domain.User;
import com.squapl.sa.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value = "/user/registration",
					 method = RequestMethod.GET,
					 produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Iterable<User>> getUser()
	{	
		System.out.println("findall start");
		Iterable<User> user=userService.findAll();
		System.out.println("findall is working");
		return new ResponseEntity<Iterable<User>>(user, HttpStatus.OK);
	}
	
	@RequestMapping(
            value = "/user/registration/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> getUser(@PathVariable("id") Long id) 
	{
        User user = userService.findOne(id);
        if (user == null) 
        {	
        	System.out.println("no user");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }   
        	System.out.println("id is");
            return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/user/registration",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
    	 User createUser = userService.CreateUser(user);
    	 System.out.println("user created");
    	 return new ResponseEntity<User>(createUser,HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/user/registration/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
    	User updatedUser = userService.UpdateUser(user);
        if (updatedUser == null) 
        {
        	System.out.println("nothing to update");
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        	System.out.println("user updated");
        	return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/user/registration/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<User> deleteUser(@PathVariable ("id") Long id)
    {
    	 userService.DeleteUser(id);
    	 System.out.println("user deleted");
    	 return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
	
}
	


