package com.howtodoinjava.example.mymovie.beans;

import java.util.Date;
import java.util.List;

public class Acteur {
    String nom;
    String prenom;
    String date_de_naiss;
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
