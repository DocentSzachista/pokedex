package com.student.unidex.repository;

import com.student.unidex.models.Pokemon;
import com.student.unidex.models.PokemonPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonPhotoRepository extends JpaRepository<PokemonPhoto, Long > {

        List<PokemonPhoto> findByPokemon(Pokemon pokemon);
}
