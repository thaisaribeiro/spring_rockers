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

import com.rockers.api.dao.TeamDao;
import com.rockers.api.model.Team;

@RestController
@RequestMapping(value="/team")
public class TeamController {

	@Autowired
	private TeamDao dao;
	
	@RequestMapping(method=RequestMethod.POST, value ="/save")
	public ResponseEntity<String> saveTeam(@RequestBody Team team){
		
	String name = dao.save(team);
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<String> updateTeam(@PathVariable ("id") String id) {
		Team team = dao.findOne(id);
		return new ResponseEntity<String>(team.getId(), HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/show")
	public ResponseEntity<List<Team>> showTeam(){
		List<Team> team = new ArrayList<Team>();
		team = dao.listAll();
		return new ResponseEntity<List<Team>>(team, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<String> deleteTeam(@PathVariable ("id") String id) {
		dao.delete(id);
		return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
	}
}
