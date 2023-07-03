package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangersTest {

    Rangers testRanger = new Rangers(1, "USER NAME", "username","M","0123456789","user@email.com", false);

    @Test
    void getId() { assertEquals(1, testRanger.getId()); }
    @Test
    void getRanger() {  assertEquals("USER NAME", testRanger.getRanger()); }
    @Test
    void getUsername() { assertEquals("username", testRanger.getUsername()); }
    @Test
    void getGender() { assertEquals("M", testRanger.getGender()); }
    @Test
    void getContacts() { assertEquals("0123456789", testRanger.getContacts()); }
    @Test
    void getEmail() { assertEquals("user@email.com", testRanger.getEmail()); }
    @Test
    void getDeleted() { assertEquals(false, testRanger.getDeleted()); }
}