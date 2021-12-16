package com.bae.fighters.controller;



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
import org.springframework.web.bind.annotation.RestController;

import com.bae.fighters.domain.Fighter;
import com.bae.fighters.service.FighterServiceDB;


@CrossOrigin
@RestController


public class FightersController {
	
	private FighterServiceDB service;

	@Autowired
	public FightersController(FighterServiceDB service) {
		super();
		this.service = service;
	}

	
	@PostMapping("/createFighter")
	
	public ResponseEntity<Fighter> createFighter(@RequestBody Fighter fighter) {
		Fighter created = this.service.createFighter(fighter);
		ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(created, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getAllFighters")
	public List<Fighter> getAllFighters() {
		return this.service.getAllFighters();
	}
	
	
	@GetMapping("/getFighterByID/{id}")
	public Fighter getFighterById(@PathVariable Integer id) {
		return this.service.getById(id);
		
	}
	
	@GetMapping("/getByName/{name}")
	public List<Fighter> getByName(@PathVariable String name) {
		return this.service.getFighterByName(name);
	}
	
	@GetMapping("/getByDivision/{division}")
	public List<Fighter> getByDivision(@PathVariable String division) {
		return this.service.getFighterByDivision(division);
	}
	
	@GetMapping("/getByCountry/{country}")
	public List<Fighter> getByCountry(@PathVariable String country) {
	return this.service.getFighterByCountry(country);
	
	}


	@PutMapping("/updateFighter/{id}")
	public ResponseEntity<Fighter> updateFighter(@PathVariable Integer id, @RequestBody Fighter newFighter) {
	Fighter body = this.service.updateFighter(id, newFighter);
	ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(body, HttpStatus.ACCEPTED);
	return response;
	
	

	}
	@DeleteMapping("deleteFighter/{id}")
	public ResponseEntity<String> deleteFighter(@PathVariable Integer id) {
		this.service.deleteFighter(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	}


