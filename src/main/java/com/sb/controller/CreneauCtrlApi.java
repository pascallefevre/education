package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.sb.dao.ICreneau;
import com.sb.domain.Creneau;
import com.sb.domain.View;

@CrossOrigin
@RestController
@RequestMapping("/creneaux")
public class CreneauCtrlApi {

	@Autowired
	ICreneau dao;
	
	@JsonView(View.Common.class)
	@GetMapping({"/",""})
	public ResponseEntity<List<Creneau>>getAll(){
		List<Creneau> classes = (List<Creneau>)dao.findAll();
		return new ResponseEntity<List<Creneau>>(classes, HttpStatus.OK );
	}
	
	@JsonView(View.Common.class)
	@PostMapping({"/",""})
	public ResponseEntity<Creneau> create(@RequestBody Creneau c){
		Creneau cdb = dao.save(c);
		return new ResponseEntity<Creneau>(cdb , HttpStatus.CREATED);
	}
	
	@JsonView(View.Common.class)
	@GetMapping({"/{id}"})
	public ResponseEntity<Creneau>getOne(@PathVariable("id") int id){
		Creneau cdb = dao.findById(id).orElse(null);
		if(cdb!=null) {
			return new ResponseEntity<Creneau>(cdb, HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(View.Common.class)
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Creneau cdb = dao.findById(id).orElse(null);
		if(cdb!=null) 
		{
			dao.deleteById(id);
			return new ResponseEntity<>( HttpStatus.MOVED_PERMANENTLY);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	
	
	@JsonView(View.Common.class)
	@PutMapping({"/{id}"})
	public ResponseEntity<Creneau> edit( @PathVariable(value="id") int id, @RequestBody Creneau mc){
		mc.setId(id);
		dao.save(mc);
		return new ResponseEntity<Creneau>(mc, HttpStatus.OK);
	}
}
