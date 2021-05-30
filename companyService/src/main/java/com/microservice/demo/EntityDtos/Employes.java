package com.microservice.demo.EntityDtos;

import org.springframework.stereotype.Component;

public class Employes {
	
	private int id;
	private String name;
	
	public Employes(){}
	
	public Employes(int id, String ename){
		this.id = id;
		this.name = ename;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
