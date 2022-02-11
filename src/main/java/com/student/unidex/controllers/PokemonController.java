package com.student.unidex.controllers;

import com.student.unidex.models.Pokemon;
import com.student.unidex.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemons(){
        return pokemonService.getPokemons();
    }

    @PostMapping
    public void registerNewPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addNewPokemon(pokemon);
    }
    @DeleteMapping(path = "/{id}")
    public void deletePokemon(@PathVariable Long id){
        pokemonService.deletePokemonWithId(id);
    }
    @GetMapping(path = "/{id}")
    public Pokemon getPokemonWithId(@PathVariable Long id){
        return  pokemonService.retrievePokemonById(id);
    }

}
