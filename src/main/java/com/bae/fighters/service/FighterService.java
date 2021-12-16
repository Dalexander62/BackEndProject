package com.bae.fighters.service;

import java.util.List;

import com.bae.fighters.domain.Fighter;

public interface FighterService {

	public List<Fighter> getAllFighters();


	Fighter createFighter(Fighter fighter);


	String deleteFighter(Integer id);

	List<Fighter> getFighterByDivision(String division);

	List<Fighter> getFighterByCountry(String country);

	Fighter updateFighter(Integer id, Fighter newFighter);

	List<Fighter> getFighterByName(String name);


	Fighter getById(Integer id);


	

	

}
