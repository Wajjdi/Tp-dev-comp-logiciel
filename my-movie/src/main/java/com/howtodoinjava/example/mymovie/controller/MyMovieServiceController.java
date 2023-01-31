package com.howtodoinjava.example.mymovie.controller;

import com.howtodoinjava.example.mymovie.beans.Acteur;
import com.howtodoinjava.example.mymovie.beans.Employee;
import com.howtodoinjava.example.mymovie.beans.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyMovieServiceController {
;protected static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd/MM/yyyy");
    Long millis = System.currentTimeMillis();
    Date date = new Date(millis);
    

    Acteur acteur1=new Acteur("toto","titi",dateFormat.format(date),null);

    List<Film> lf2= new ArrayList<Film>();
    {
        lf2.add(new Film("Avatar", "Thomas",acteur1,"2012"));
    }
    
    Acteur acteur2=new Acteur("titi","tata",dateFormat.format(date),lf2);
    List<Film> lf3= new ArrayList<Film>();

    {
        lf3.add(new Film("Batman", "Ayoub", acteur2,"2012"));

    }
    Acteur acteur3=new Acteur("Gaiech","Wajdi",dateFormat.format(date),lf3);

    List<Film> lf4= new ArrayList<Film>();

    {
        lf4.add(new Film("James bond", "Marwan", acteur3, "2012"));

    }
    Acteur acteur4=new Acteur("Benallal","Ayoub",dateFormat.format(date),lf4);


    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(acteur1);
        acteurs.add(acteur2);
        acteurs.add(acteur3);
        acteurs.add(acteur4);
    }
    List<Film> films = new ArrayList<Film>();

    {
        films.add(new Film("Avatar", "Thomas",acteur1,"2012"));
        films.add(new Film("Batman", "Ayoub", acteur2,"2012"));
        films.add(new Film("James bond", "Marwan", acteur3, "2012"));
        films.add(new Film("Avengers", "Wajdi", acteur4, "2012"));

    }
   

    @RequestMapping(value = "/getActeur",method = RequestMethod.GET)
    public List<Acteur> getActeur() {
        return acteurs;
    }

    @RequestMapping(value = "/getActeurNom/{name}",method = RequestMethod.GET)
    public Acteur getActeurNom(@PathVariable(value = "name") String name) {
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/getActeurFilm/{film}",method = RequestMethod.GET)
    public List<Acteur> getActeurFilm(@PathVariable(value = "film") String film) {
       List<Acteur> acteurList = new ArrayList<Acteur>();
        for (Acteur acteur : acteurs) {
           for (Film filma:acteur.getFilm()){
               if(filma.getTitre().equals(film)){
                   acteurList.add(acteur);
               }
           }
        }
        System.out.println("Getting acteur details for " + acteurList);
        return acteurList;
    }

}
