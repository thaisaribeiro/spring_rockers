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

import com.rockers.api.dao.ContractDao;
import com.rockers.api.model.Contract;

@RestController
@RequestMapping(value="/contract")
public class ContractController {

	@Autowired
	private ContractDao dao;
	
	@RequestMapping(method=RequestMethod.POST, value ="/save")
	public ResponseEntity<String> saveContract(@RequestBody Contract cont){
		
	String name = dao.save(cont);
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<String> updateContract(@PathVariable ("id") String id) {
		Contract cont = dao.findOne(id);
		return new ResponseEntity<String>(cont.getId(), HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/show")
	public ResponseEntity<List<Contract>> showContract(){
		List<Contract> cont = new ArrayList<Contract>();
		cont = dao.listAll();
		return new ResponseEntity<List<Contract>>(cont, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<String> deleteContract(@PathVariable ("id") String id) {
		dao.delete(id);
		return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
	}
}


