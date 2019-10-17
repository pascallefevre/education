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
import com.sb.dao.IClasse;
import com.sb.domain.Classe;
import com.sb.domain.View;

@CrossOrigin
@RestController
@RequestMapping("/classes")
public class ClasseCtrlApi {

	@Autowired
	IClasse dao;
	
	@JsonView(View.Common.class)
	@GetMapping({"/",""})
	public ResponseEntity<List<Classe>>getAll(){
		List<Classe> classes = (List<Classe>)dao.findAll();
		return new ResponseEntity<List<Classe>>(classes, HttpStatus.OK );
	}
	
	@JsonView(View.Common.class)
	@PostMapping({"/",""})
	public ResponseEntity<Classe> create(@RequestBody Classe c){
		Classe cdb = dao.save(c);
		return new ResponseEntity<Classe>(cdb , HttpStatus.CREATED);
	}
	
	@JsonView(View.Common.class)
	@GetMapping({"/{id}"})
	public ResponseEntity<Classe>getOne(@PathVariable("id") int id){
		Classe cdb = dao.findById(id).orElse(null);
		if(cdb!=null) {
			return new ResponseEntity<Classe>(cdb, HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(View.Common.class)
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Classe cdb = dao.findById(id).orElse(null);
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
	public ResponseEntity<Classe> edit( @PathVariable(value="id") int id, @RequestBody Classe mc){
		mc.setId(id);
		dao.save(mc);
		return new ResponseEntity<Classe>(mc, HttpStatus.OK);
	}
	
}



































