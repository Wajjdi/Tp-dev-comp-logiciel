package com.howtodoinjava.example.mymovie.controller;

import com.howtodoinjava.example.mymovie.beans.Acteur;
import com.howtodoinjava.example.mymovie.beans.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
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
    @ApiOperation(value = "Get list of Acteur in the System ", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping(value = "/getActeurs",method = RequestMethod.GET)
    public List<Acteur> getActeurs() {
        return acteurs;
    }
    @ApiOperation(value = "Get specific Acteur in the System ", response = Acteur.class, tags = "getActeurNom")
    @RequestMapping(value = "/getActeurNom/{name}",method = RequestMethod.GET)
    public Acteur getActeurNom(@PathVariable(value = "name") String name) {
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }
    @ApiOperation(value = "Get specific Acteur in the System ", response = Acteur.class, tags = "getActeurFilm")
    @RequestMapping(value = "/getActeurFilm/{titre}",method = RequestMethod.GET)
    public List<Acteur> getActeurFilm(@PathVariable(value = "titre") String titre) {
       List<Acteur> acteurList = new ArrayList<Acteur>();
        for (Film film:films) {
            if (film.getTitre().equals(titre)){
                acteurList.add(film.getAct_principal());
            }
        }
        return acteurList;
    }

    @ApiOperation(value = "Get list of Films in the System ", response = Iterable.class, tags = "getFilmss")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping(value = "/getFilms",method = RequestMethod.GET)
    public List<Film> getFilms() {
        return films;
    }
    @ApiOperation(value = "Get specific Film in the System ", response = Acteur.class, tags = "getFilmTitre")
    @RequestMapping(value = "/getFilmTitre/{titre}",method = RequestMethod.GET)
    public Film getFilmTitre(@PathVariable(value = "titre") String titre) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }
    @ApiOperation(value = "Get specific Film in the System ", response = Acteur.class, tags = "getFilmDate")
    @RequestMapping(value = "/getFilmDate/{date}",method = RequestMethod.GET)
    public Film getFilmDate(@PathVariable(value = "date") String date) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(date)).collect(Collectors.toList()).get(0);
    }

}
