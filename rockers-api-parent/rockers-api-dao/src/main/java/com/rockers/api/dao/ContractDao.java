package com.rockers.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rockers.api.model.Contract;

@Component
public class ContractDao implements Crud<Contract> {

	@Override
	public Contract findOne(String id) {
		Contract cont = new Contract();
		cont.setId("23");
		cont.setName("Jordan");
		cont.setUser(null);
		return cont;
	}

	@Override
	public String save(Contract t) {
		t.setName("Damien");
		return t.getName();
	}

	@Override
	public List<Contract> listAll() {
		List<Contract> contlist = new ArrayList<Contract>();
		Contract cont = new Contract();
		cont.setName("Wally");
		cont.setUser(null);
		contlist.add(cont);
		
		Contract cont2 = new Contract();
		cont2.setName("Barry");
		cont2.setUser(null);
		contlist.add(cont2);
		
		return contlist;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}