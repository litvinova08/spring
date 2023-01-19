package io.nology.polandspringfull.trainer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TrainerCreateDTO {

	@NotBlank
	private String name;
	
	@NotBlank
	private String location;
	
	@NotNull
	@Min(0)
	private Integer numOfPokemon;
	
	public TrainerCreateDTO (String name, String location, Integer numOfPokemon) {
		this.name = name;
		this.location = location;
		this.numOfPokemon = numOfPokemon;
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
