package com.bae.fighters.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fighter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	private String division;
	
	private String country;
	
	

	public Fighter() {
		super();
	}

	


	public Fighter(String name, String division, String country) {
		super();
		this.name = name;
		this.division = division;
		this.country = country;
	}




	public Fighter(Integer id, String name, String division, String country) {
		super();
		this.id = id;
		this.name = name;
		this.division = division;
		this.country = country;
	}
	
	

//	@Override
//	public int hashCode() {
//		return Objects.hash(country, division, id, name);
//	}
//
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Fighter other = (Fighter) obj;
//		return Objects.equals(country, other.country) && Objects.equals(division, other.division)
//				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
//	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", division=" + division + ", country=" + country + "]";
	}
	
	

}


