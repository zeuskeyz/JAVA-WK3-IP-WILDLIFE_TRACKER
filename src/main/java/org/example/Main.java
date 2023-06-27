package org.example;

import org.example.dao.Animals_DAO;
import org.example.dao.Sighting_DAO;
import org.example.models.Animals;
import org.example.models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        staticFileLocation("/public");
        HandlebarsTemplateEngine views = new HandlebarsTemplateEngine();


        //LANDING PAGE
        get("/", (request, response) -> {
            Animals_DAO.createTable(); Sighting_DAO.createTable();
            return new ModelAndView(new HashMap<>(), "landing-page.hbs");
        }, views);
        //GETS THE ADDING ANIMALS PAGE
        get("/add-animal", (request, response) -> new ModelAndView(new HashMap<>(), "add-animal.hbs"), views);

        //ADD TO ANIMAL TABLE
        post("/add-animal", (request, response) -> {
            Integer id = null;
            String animal = request.queryParams("animal");
            Boolean endangered = Boolean.parseBoolean( request.queryParams("endangered"));
            Boolean deleted = false;
            Animals newAnimal = new Animals(id,animal,endangered,deleted);
            Animals_DAO.addAnimals(newAnimal);
            response.redirect("/home");
            return null;
        });

        //GETS THE ANIMAL REPORTS PAGE
        get("/animals",(request, response) -> {
            Map<String, Object> animalsMap = new HashMap<>();
            animalsMap.put("animal" , Animals_DAO.allAnimals());
            return new ModelAndView(animalsMap, "animals-table.hbs");
        },views);

        //DELETING AN ANIMAL FROM THE PAGE
        get("/delete/:animal", (req,res)-> {
            String animal = req.params(":animal");
            Animals_DAO.deleteAnimal(animal);
            res.redirect("/home");
            return null;
        },views);

        //GETS THE HOME PAGE
        get("/home", (request, response) -> {
            Map<String, Object> animalsMap = new HashMap<>();
            animalsMap.put("animal" , Animals_DAO.allAnimals());
            return new ModelAndView(animalsMap, "home-page.hbs");

        }, views);

        post("/home", (request, response) -> {
            System.out.println(request.queryParams());
            return new ModelAndView(new HashMap<>(), "search-page.hbs");
        },views);

        get("/sightings",(request, response) -> {
            Map<String, Object> allSightings = new HashMap<>();
            allSightings.put("sighting",Sighting_DAO.allSightings());
            return new ModelAndView(allSightings, "sightings-table.hbs");
        }, views);

        //GETS THE PAGE FOR ADDING SIGHTED ANIMALS
        get("/sighting/:animal", (request, response) -> {
            Map<String, Object> animalObject = new HashMap<>();
            String animal = request.params("animal");
            animalObject.put("animal",Animals_DAO.oneAnimal(animal));
            animalObject.put("similarSighting",Sighting_DAO.distinctSightings(animal));
            return new ModelAndView(animalObject, "add-sighting.hbs");
        }, views);

        //ADD ANIMAL TO SIGHTINGS TABLE
        post("/sighting/:animal", (request, response) -> {
            Integer id = null;
            String animal = request.queryParams("animal");
            Boolean endangered = Boolean.parseBoolean( request.queryParams("endangered"));
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");
            Date time = new Date();
            Boolean deleted = false;

            Sighting newSighting = new Sighting(id,animal,endangered,age,health,location,ranger, time, deleted);
            Sighting_DAO.addSighting(newSighting);
            response.redirect("/home");
            return null;
        });

        //GETS THE SIGHTINGS REPORTS PAGE
        get("/animals",(request, response) -> {
            Map<String, Object> sightingsMap = new HashMap<>();
            sightingsMap.put("sighting" , Sighting_DAO.allSightings());
            return new ModelAndView(sightingsMap, "animals-table.hbs");
        },views);



    }
}