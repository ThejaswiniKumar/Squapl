package com.squapl.sa.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
public class User{
@Id
@GeneratedValue
private Long id;
private String username;
private  String email;
private String password;
private String confirmpassword;
private int roles;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Transient
public String getconfirmpassword() {
	return confirmpassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmpassword = confirmPassword;
}

public int getRoles() {
	return roles;
}
public void setRoles(int roles) {
	this.roles = roles;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
			+ ", confirmpassword=" + confirmpassword + ", roles=" + roles + "]";
}



}

