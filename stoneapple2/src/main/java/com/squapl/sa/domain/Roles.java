package com.squapl.sa.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.squapl.sa.model.Users;

@Entity
public class Roles
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + "]";
	}
	
}
