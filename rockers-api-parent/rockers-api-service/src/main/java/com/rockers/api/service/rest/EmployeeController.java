package com.rockers.api.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.dao.EmployeeDao;
import com.rockers.api.model.Employee;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping(method=RequestMethod.POST, value = "/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
		
		String WiproId = dao.save(emp);
		return new ResponseEntity<String>(WiproId, HttpStatus.OK);
		
	}

	@RequestMapping(method=RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable ("WiproId") String WiproId){
		Employee emp = dao.findOne(WiproId);
		return new ResponseEntity<String>(emp.getName(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/show")
	public ResponseEntity<List<Employee>> showEmployee(){
		List<Employee> emplist = new ArrayList<Employee>();
		emplist = dao.listAll();
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("WiproId") String WiproId){
		dao.delete(WiproId);
		return new ResponseEntity<String>("Funcionario deletado com sucesso", HttpStatus.OK);
	}
}
