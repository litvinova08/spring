package io.nology.polandspringfull.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	//Dependancy injection patter
	@Autowired
	private PokemonService service;
	

	@GetMapping
	public ResponseEntity<List<Pokemon>> getAll() {
		List<Pokemon> allPokemons = this.service.getAll();
		return new ResponseEntity<>(allPokemons, HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //dynamic route here
	public ResponseEntity<Pokemon> getById(@PathVariable Long id) {
		Optional<Pokemon> maybePokemon = this.service.getById(id);

		if(maybePokemon.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(maybePokemon.get(), HttpStatus.FOUND);
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<Pokemon> create(@RequestBody PokemonCreateDTO data) {
		Pokemon createdPokemon = this.service.create(data);
		return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
	}
}
