package com.student.unidex.config;

import com.student.unidex.models.Pokemon;
import com.student.unidex.models.PokemonPhoto;
import com.student.unidex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PokemonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PokemonRepository repository) {
        return args -> {


            repository.saveAll(
                    List.of(
                            new Pokemon(

                                    "Bulbasaur",
                                    "Lives in the grass"
                            ),

                            new Pokemon(
                                "Venosaur",
                            "Lives in the lol grass",
                                    List.of(
                                            new PokemonPhoto(
                                                    "Venosaur.png"
                                            ),
                                            new PokemonPhoto(
                                                    "Venosaur2.png"
                                            )
                                    )
                            )
                    )
            );
        };
    }
}
