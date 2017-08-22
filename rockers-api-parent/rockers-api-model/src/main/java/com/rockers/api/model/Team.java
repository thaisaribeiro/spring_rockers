package com.rockers.api.model;

import java.util.HashSet;
import lombok.Data;
import java.util.Set;

@Data
public class Team {

	private String id;
	private String name;
	private Set<Employee> Employees = new HashSet<Employee>();
	
	
	
} 