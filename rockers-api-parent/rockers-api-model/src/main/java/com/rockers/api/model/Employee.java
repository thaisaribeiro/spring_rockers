package com.rockers.api.model;

import lombok.Data;

@Data
public class Employee {
	
	private String name;
	private String WiproId;
	private int idCliente;
	private String email;
	private String projectType;
	private int managerId;
	private String login;
	private String password;
} 
