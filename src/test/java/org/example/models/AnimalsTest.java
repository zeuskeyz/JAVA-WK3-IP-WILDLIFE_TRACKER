package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsTest {
    Animals testAnimals = new Animals(1,"HIPPO",true,false);
    @Test
    void getId() { assertEquals(1, testAnimals.getId()); }

    @Test
    void getAnimal() { assertEquals("HIPPO", testAnimals.getAnimal()); }

    @Test
    void getEndangered() { assertEquals(true, testAnimals.getEndangered()); }

    @Test
    void getDeleted() { assertEquals(false, testAnimals.getDeleted()); }
}