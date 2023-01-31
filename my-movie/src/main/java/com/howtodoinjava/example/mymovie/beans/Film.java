package com.howtodoinjava.example.mymovie.beans;

import java.util.Date;

public class Film {
String titre;
String realisateur;
Acteur act_principal;
String date_sortie;

public Film(String titre, String realisateur,Acteur act_principal, String date_sortie){
    this.titre=titre;
    this.realisateur=realisateur;
    this.act_principal=act_principal;
    this.date_sortie=date_sortie;
}

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getAct_principal() {
        return act_principal;
    }

    public void setAct_principal(Acteur act_principal) {
        this.act_principal = act_principal;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }
}
