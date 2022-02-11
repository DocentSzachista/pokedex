package com.student.unidex.models;

import jakarta.persistence.*;

@Entity(name = "PokemonPhotos")
@Table
public class PokemonPhoto {
    @Id
    @SequenceGenerator(
            name= "pokemon_photo_sequence",
            sequenceName = "photo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "pokemon_photo_sequence")
    private  Long  photoId;
    @Column(nullable = false)
    private String photoLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    public PokemonPhoto(String photoLink) {
        this.photoLink = photoLink;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public PokemonPhoto() {
    }

    public PokemonPhoto(Long photoId, String photoLink) {
        this.photoId = photoId;
        this.photoLink = photoLink;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

}
