package io.nology.polandspringfull.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

//this interface extends JPA repository that has all required methods
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
