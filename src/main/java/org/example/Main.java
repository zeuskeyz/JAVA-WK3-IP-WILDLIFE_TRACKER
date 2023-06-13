package org.example;

import static spark.Spark.get;
import spark.ModelAndView;
import static spark.Spark.staticFileLocation;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        HandlebarsTemplateEngine views = new HandlebarsTemplateEngine();

        get("/", (request, response) -> new ModelAndView(new HashMap<>(), "landing-page.hbs"), views);

    }
}