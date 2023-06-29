package org.example.dao;

import org.example.database.Database;
import org.example.models.Animals;
import org.example.models.Sighting;
import org.sql2o.Connection;

import java.util.List;

public class Sighting_DAO {
    //CREATES A SIGHTINGS TABLE ON THE DATABASE
    public static void createTable (){
        try(Connection db = Database.getConnection().open()){
            String tableSpell = "CREATE TABLE IF NOT EXISTS sightings (id serial, animal varchar, endangered boolean default false, health varchar, age varchar, location varchar, ranger varchar, time timestamptz, deleted boolean default false);";
            db.createQuery(tableSpell).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }
     //ADDS A NEW ANIMAL SIGHTING TO THE SIGHTINGS TABLE
    public static void addSighting (Sighting newSighting) {
        try (Connection db = Database.getConnection().open()) {
            String addingSpell = "INSERT INTO sightings (animal, endangered, age, health, location, ranger, time) VALUES (UPPER(:animal), :endangered, :age, :health, :location, UPPER(:ranger), :time);";
            db.createQuery(addingSpell).bind(newSighting).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

    //SELECTS A PARTICULAR ANIMAL FROM THE SIGHTINGS TABLE
    public static List<Sighting> distinctSightings (String animal){
        List<Sighting> specialSighting = null;
        try (Connection db = Database.getConnection().open()){
            String distinctSpell = "SELECT * FROM sightings WHERE animal = (:animal) AND NOT deleted;";
            specialSighting = db.createQuery(distinctSpell).addParameter("animal", animal).executeAndFetch(Sighting.class);
        } catch (Exception error){System.out.println(error.getMessage());}
        return specialSighting;
    }

    //RETURNS ALL SIGHTED ANIMALS
    public static List<Sighting> allSightings() {
        List<Sighting> everySighting = null;
        try (Connection db = Database.getConnection().open()){
            String sightingsSpell = "SELECT * FROM sightings WHERE NOT deleted;";
            everySighting = db.createQuery(sightingsSpell).executeAndFetch(Sighting.class);
        } catch (Exception error){System.out.println(error.getMessage());}
        return everySighting;
    }

    public static void deleteSighting(String animal){
        try(Connection db = Database.getConnection().open()){
            String deletionSpell = " UPDATE sightings SET deleted = true WHERE animal = (:animal);";
            db.createQuery(deletionSpell).addParameter("animal", animal).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }



}
