package io.nology.polandspringfull.trainer;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
@Transactional

public class TrainerService {

	private TrainerRepository repository;
	
	//get the list of all trainers
	public List<Trainer> getAll() {
		return this.repository.findAll();
	}
	
	//add a new trainer to DB
	public Trainer create(TrainerCreateDTO data) {
		Trainer newTrainer = new Trainer(data.getName(), data.getLocation(), data.getNumOfPokemon());
		this.repository.save(newTrainer);
		return newTrainer;
	}
	
	//get a trainer by Id
	public Optional<Trainer> getById(Long id) {
		return this.repository.findById(id);
	}
	
	//delete by id
	public boolean delete(Long id) {
		Optional<Trainer> maybeTrainer = this.getById(id);
		
		if(maybeTrainer.isEmpty()) {
			return false;
		}
		
		this.repository.delete(maybeTrainer.get());
		return true;
	}
	
	//add one pokemon to a trainer by id
	public boolean addPokemon(Long id) {
		Optional<Trainer> maybeTrainer = this.getById(id);
		
		if(maybeTrainer.isEmpty()) {
			return false;
		}
		Trainer foundTrainer = maybeTrainer.get();
		
		Integer currNumOfPokemons = foundTrainer.getNumOfPokemon();
		foundTrainer.setNumOfPokemon(currNumOfPokemons + 1);		
		this.repository.save(foundTrainer);
		
		return true;
	}
}
