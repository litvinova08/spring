package io.nology.polandspringfull.trainer;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")

public class TrainerController {

	@Autowired
	private TrainerService service;
	
	//add a new trainer to DB
	@PostMapping
	public ResponseEntity<Trainer> create(@Valid @RequestBody TrainerCreateDTO data) {
		Trainer newTrainer = this.service.create(data);
		return new ResponseEntity<>(newTrainer, HttpStatus.CREATED);
	}
	
	//get all trainers from DB
	@GetMapping
	public ResponseEntity<List<Trainer>> getAll() {
		List<Trainer> allTrainers = this.service.getAll();
		return new ResponseEntity<>(allTrainers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Trainer> getById(@PathVariable Long id) {
		Optional<Trainer> maybeTrainer = this.service.getById(id);

		if (maybeTrainer.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(maybeTrainer.get(), HttpStatus.FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Trainer> delete(@PathVariable Long id){
		boolean isDeleted = this.service.delete(id);
		
		if(isDeleted) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/{id}/add-pokemon")
	public ResponseEntity<Trainer> addPokemon(@PathVariable Long id){
		boolean isAdded = this.service.addPokemon(id);
		
		if(isAdded) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
}
