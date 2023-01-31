package com.howtodoinjava.example.mymovie.beans;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Film {
    @ApiModelProperty(notes = "titre du film",name="titre",required=true,value="test name")
    String titre;
    @ApiModelProperty(notes = "realisateur du film",name="realisateur",required=true,value="test name")
    String realisateur;
    @ApiModelProperty(notes = "acteur principal pour un film",name="act_principal",required=true,value="test name")
    Acteur act_principal;
    @ApiModelProperty(notes = "Lastname of the Acteur",name="date_sortie",required=true,value="test name")
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
