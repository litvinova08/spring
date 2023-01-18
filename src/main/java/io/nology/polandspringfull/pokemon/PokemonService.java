package io.nology.polandspringfull.pokemon;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // to inform that this is a Service layer
@Transactional // every time when i do smth with DB, i create a transaction. it smth goes
				// wrong, @Transactional will reverse all changes

public class PokemonService {

	// to save data into repo, we do DEPENDANCY INJECTION
	@Autowired // Spring container will create an instance of repo object that will contain all
				// methods to interact with DB
	private PokemonRepository repository;

	public Pokemon create(PokemonCreateDTO data) {
		// business logic sits here:
		// convert the name to lower case
		String cleanedName = data.getName().toLowerCase();

		// Pokemon entity is ready to be saved in DB
		Pokemon newPokemon = new Pokemon(cleanedName, data.getElement(), data.getHp(), data.getAttackPower());
		// to save it into repo, i need to call its methods
		this.repository.save(newPokemon);
		return newPokemon;
	}
	
	//get the list of all pokemons
	public List<Pokemon> getAll() {
		return this.repository.findAll();
	}
	
	//method to return a pokemon by Id
	public Optional<Pokemon> getById(Long id) {
		return this.repository.findById(id);
	}
}
