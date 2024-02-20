package com.cleaningServices.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role")

public class Role {

	@Id
	int role_id;
	@Column
	String role_name;
	
	
	public Role() {
		super();
	}


	public int getRole_id() {
		
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
		
	}


	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	
	

	
	
	
}
