package com.howtodoinjava.example.mymovie.beans;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class Acteur {
    @ApiModelProperty(notes = "Lastname of the Acteur",name="nom",required=true,value="test name")
    String nom;
    @ApiModelProperty(notes = "Firstname of the Acteur",name="prenom",required=true,value="test prenom")
    String prenom;
    @ApiModelProperty(notes = "birthday of the Acteur",name="date_de_naiss",required=true,value="test date_de_naiss")
    String date_de_naiss;
    @ApiModelProperty(notes = "List of the movies of the Acteur",name="film",required=true,value="test film")
    List<Film> film;

    public Acteur(String nom, String prenom, String naissance, List<Film> film){
        this.nom = nom;
        this.prenom=prenom;
        this.date_de_naiss=naissance;
        this.film=film;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naiss() {
        return date_de_naiss;
    }

    public void setDate_de_naiss(String date_de_naiss) {
        this.date_de_naiss = date_de_naiss;
    }

    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }
}
