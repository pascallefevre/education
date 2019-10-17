package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.sb.dao.IMatiere;
import com.sb.domain.Matiere;
import com.sb.domain.View;

public class MatiereCtrlApi {

	@Autowired
	IMatiere dao;
	
	@JsonView(View.Common.class)
	@GetMapping({"/",""})
	public ResponseEntity<List<Matiere>>getAll(){
		List<Matiere> classes = (List<Matiere>)dao.findAll();
		return new ResponseEntity<List<Matiere>>(classes, HttpStatus.OK );
	}
	
	@JsonView(View.Common.class)
	@PostMapping({"/",""})
	public ResponseEntity<Matiere> create(@RequestBody Matiere c){
		Matiere cdb = dao.save(c);
		return new ResponseEntity<Matiere>(cdb , HttpStatus.CREATED);
	}
	
	@JsonView(View.Common.class)
	@GetMapping({"/{id}"})
	public ResponseEntity<Matiere>getOne(@PathVariable("id") int id){
		Matiere cdb = dao.findById(id).orElse(null);
		if(cdb!=null) {
			return new ResponseEntity<Matiere>(cdb, HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(View.Common.class)
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Matiere cdb = dao.findById(id).orElse(null);
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
	public ResponseEntity<Matiere> edit( @PathVariable(value="id") int id, @RequestBody Matiere mc){
		mc.setId(id);
		dao.save(mc);
		return new ResponseEntity<Matiere>(mc, HttpStatus.OK);
	}
}
