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
import com.sb.dao.IProf;
import com.sb.domain.Prof;
import com.sb.domain.View;

@CrossOrigin
@RestController
@RequestMapping("/profs")
public class ProfCtrlApi {

	@Autowired
	IProf dao;
	
	@JsonView(View.Common.class)
	@GetMapping({"/",""})
	public ResponseEntity<List<Prof>>getAll(){
		List<Prof> classes = (List<Prof>)dao.findAll();
		return new ResponseEntity<List<Prof>>(classes, HttpStatus.OK );
	}
	
	@JsonView(View.Common.class)
	@PostMapping({"/",""})
	public ResponseEntity<Prof> create(@RequestBody Prof c){
		Prof cdb = dao.save(c);
		return new ResponseEntity<Prof>(cdb , HttpStatus.CREATED);
	}
	
	@JsonView(View.Common.class)
	@GetMapping({"/{id}"})
	public ResponseEntity<Prof>getOne(@PathVariable("id") int id){
		Prof cdb = dao.findById(id).orElse(null);
		if(cdb!=null) {
			return new ResponseEntity<Prof>(cdb, HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(View.Common.class)
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Prof cdb = dao.findById(id).orElse(null);
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
	public ResponseEntity<Prof> edit( @PathVariable(value="id") int id, @RequestBody Prof mc){
		mc.setId(id);
		dao.save(mc);
		return new ResponseEntity<Prof>(mc, HttpStatus.OK);
	}
}
