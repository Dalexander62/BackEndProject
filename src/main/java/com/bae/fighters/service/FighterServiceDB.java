package com.bae.fighters.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.fighters.domain.Fighter;
import com.bae.fighters.repo.FighterRepo;


@Service
public class FighterServiceDB implements FighterService {
	

		private FighterRepo repo;

		@Autowired
		public FighterServiceDB(FighterRepo repo) {
			super();
			this.repo = repo;
		}

		@Override
		public Fighter createFighter(Fighter fighter) {
			Fighter created = this.repo.save(fighter);
			return created;
		}

//		public String testMeTestMe() {
//			return "Yo";
//		}

		@Override
		public List<Fighter> getAllFighters() {
			// TODO Auto-generated method stub
			return this.repo.findAll();
		}

		@Override
		public Fighter getById(Integer id) {
			// TODO Auto-generated method stub
			Optional<Fighter> found = this.repo.findById(id);
			return found.get();

		}

		@Override
		public List<Fighter> getFighterByName(String name) {
			List<Fighter> found = this.repo.findByNameIgnoreCase(name);
			return found;
		}

		@Override
		public Fighter updateFighter(Integer id, Fighter newFighter) {
			Fighter found = this.repo.findById(id).get();

			found.setName(newFighter.getName());
			found.setDivision(newFighter.getDivision());
			found.setCountry(newFighter.getCountry());
//			found.setType(newDog.getType());

			Fighter updated = this.repo.save(found);
			return updated;
		}

		@Override
		public String deleteFighter(Integer id) {
			this.repo.deleteById(id);
			
			if(this.repo.existsById(id)) {
				return id + "Not deleted";
			}else {
				return "Fighter in index" + id + "has been deleted";
		}



	}


		@Override
		public List<Fighter> getFighterByDivision(String division) {
			return this.repo.findByDivisionIgnoreCase(division);
		}

		

		@Override
		public List<Fighter> getFighterByCountry(String country) {
			return this.repo.findByCountryIgnoreCase(country);
		}

}
