package com.student.unidex.repository;

import com.student.unidex.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository
        extends JpaRepository<Pokemon, Long > {


    @Query("Select s FROM Pokemons s WHERE s.pokemonName = ?1")
    Optional<Pokemon> findPokemonByName(String name);
}
