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
import com.sb.dao.IRoom;
import com.sb.domain.Room;
import com.sb.domain.View;

@CrossOrigin
@RestController
@RequestMapping("/rooms")
public class RoomCtrlApi {

	@Autowired
	IRoom dao;
	
	@JsonView(View.Common.class)
	@GetMapping({"/",""})
	public ResponseEntity<List<Room>>getAll(){
		List<Room> classes = (List<Room>)dao.findAll();
		return new ResponseEntity<List<Room>>(classes, HttpStatus.OK );
	}
	
	@JsonView(View.Common.class)
	@PostMapping({"/",""})
	public ResponseEntity<Room> create(@RequestBody Room c){
		Room cdb = dao.save(c);
		return new ResponseEntity<Room>(cdb , HttpStatus.CREATED);
	}
	
	@JsonView(View.Common.class)
	@GetMapping({"/{id}"})
	public ResponseEntity<Room>getOne(@PathVariable("id") int id){
		Room cdb = dao.findById(id).orElse(null);
		if(cdb!=null) {
			return new ResponseEntity<Room>(cdb, HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(View.Common.class)
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Room cdb = dao.findById(id).orElse(null);
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
	public ResponseEntity<Room> edit( @PathVariable(value="id") int id, @RequestBody Room mc){
		mc.setId(id);
		dao.save(mc);
		return new ResponseEntity<Room>(mc, HttpStatus.OK);
	}
}
