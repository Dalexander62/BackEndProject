package com.bae.fighters.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.fighters.domain.Fighter;

@Repository
public interface FighterRepo extends JpaRepository<Fighter, Integer> {

	List<Fighter> findByNameIgnoreCase(String name);

	List<Fighter> findByDivisionIgnoreCase(String division);

	List<Fighter> findByCountryIgnoreCase(String country);
}
