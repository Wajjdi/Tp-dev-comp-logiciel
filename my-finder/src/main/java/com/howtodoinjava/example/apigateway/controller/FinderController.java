package com.howtodoinjava.example.apigateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FinderController {

    @Autowired
    RestTemplate restTemplate;
    // what hystrix annotation to expose fallback ?
    @RequestMapping(value = "/acteursDetails", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public String getActeurs()
    {
        String response = restTemplate.exchange("http://my-movie/getActeurs",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return  " [ Acteurs : " + response+" ]";
    }

    @RequestMapping(value = "/acteurDetails/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurNom(@PathVariable String nom)
    {
        System.out.println("Getting Employee details for " + nom);

        String response = restTemplate.exchange("http://my-movie/getActeurNom/{nom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, nom).getBody();

        System.out.println("Response Body " + response);

        return "acteur nom -  " + nom + " [ acteur Details " + response+" ]";
    }

    @RequestMapping(value = "/acteursDetailsFilm/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurFilm(@PathVariable String nom)
    {
        String response = restTemplate.exchange("http://my-movie/getActeurFilm/{titre}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, nom).getBody();

        System.out.println("Response Body " + response);

        return "acteurt par rapport au nom de film-  " + nom + " [ acteur Details " + response+" ]";
    }

    @RequestMapping(value = "/FilmsDetails", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public String getFilms()
    {
        String response = restTemplate.exchange("http://my-movie/getFilms/",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return " [ film " + response+" ]";
    }

    @RequestMapping(value = "/FilmsDetailsTitre/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilmsTitre(@PathVariable String nom)
    {
        String response = restTemplate.exchange("http://my-movie/getFilmTitre/{nom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},nom).getBody();

        System.out.println("Response Body " + response);

        return " titre du film "+ nom+" [ film " + response+" ]";
    }


    public String  fallbackMethod(String nom){

        return "Fallback response:: No acteur details available temporarily";
    }

    public String  fallbackMethod1(){

        return "Fallback response:: No acteur details available temporarily";
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
