package org.example.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SightingTest {

    Date testTime  = new Date();

    Sighting testSighting = new Sighting(1, "Human",true,"Adult", "Sick", "NORTHEAST SECTION", "shezron", testTime, false);

    @Test
    void getId() { assertEquals(1, testSighting.getId()); }

    @Test
    void getAnimal() { assertEquals("Human", testSighting.getAnimal());}

    @Test
    void getEndangered() { assertEquals(true, testSighting.getEndangered());}

    @Test
    void getAge() { assertEquals("Adult", testSighting.getAge());}

    @Test
    void getHealth() { assertEquals("Sick", testSighting.getHealth());}

    @Test
    void getLocation() {assertEquals("NORTHEAST SECTION", testSighting.getLocation());}

    @Test
    void getRanger() { assertEquals("shezron", testSighting.getRanger()); }

    @Test
    void getTime() { assertEquals(testTime, testSighting.getTime());}

    @Test
    void getDeleted() { assertEquals(false, testSighting.getDeleted());}
}