package com.student.unidex.services;

import com.student.unidex.models.Pokemon;
import com.student.unidex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private  final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemons(){
        return pokemonRepository.findAll();
    }

    public void addNewPokemon(Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = pokemonRepository
                .findPokemonByName(pokemon.getPokemonName());
        if(pokemonOptional.isPresent()){
            throw new IllegalStateException("Pokemon already exists");
        }
        pokemonRepository.save(pokemon);
    }

    public void deletePokemonWithId(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if(pokemon.isEmpty()){
            throw new IllegalStateException("Pokemon doesn't exist");
        }
        pokemonRepository.deleteById(id);
    }

    public Pokemon retrievePokemonById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if(pokemon.isEmpty())
        {
            throw  new IllegalStateException("Pokemon doesn't exist");
        }
        return pokemonRepository.getReferenceById(id);
    }
}
