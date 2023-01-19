package io.nology.polandspringfull.trainer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name; 
	
	@Column
	String location;
	
	@Column
	Integer numOfPokemon;
	
	public Trainer() {};

	public Trainer (String name, String location, Integer numOfPokemon) {
		this.name = name;
		this.location = location;
		this.numOfPokemon = numOfPokemon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getNumOfPokemon() {
		return numOfPokemon;
	}

	public void setNumOfPokemon(Integer numOfPokemon) {
		this.numOfPokemon = numOfPokemon;
	}
	
	
}
