package com.student.unidex.models;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "Pokemons")
@Table
public class Pokemon {
    @Id
    @SequenceGenerator(
            name= "pokemon_sequence",
            sequenceName = "pokemon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pokemon_sequence"
    )
    private Long pokemonId;
    @Column(nullable = false)
    private String pokemonName;
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.EAGER)
    private List<PokemonPhoto> pokemonPhotos;
    public Pokemon() {
    }

    public Pokemon(Long pokemonId, String pokemonName, String description) {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
        this.description = description;
    }

    public Pokemon(String pokemonName, String description) {
        this.pokemonName = pokemonName;
        this.description = description;
    }
    public Pokemon(String pokemonName, String description, List<PokemonPhoto> photosLinks) {
        this.pokemonName = pokemonName;
        this.description = description;
        this.pokemonPhotos = photosLinks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }
}
