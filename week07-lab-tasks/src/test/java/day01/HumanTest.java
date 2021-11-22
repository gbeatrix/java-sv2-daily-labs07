package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;

    @Test
    void testCreateHuman() {
        human = new Human("Gipsz Jakab", 1980);
        assertEquals("Gipsz Jakab", human.getName());
        assertEquals(1980, human.getYearOfBirth());
        assertTrue(human.getAge() >= 41);
    }

    @Test
    void testCreateHumanInvalidAge() {
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> human = new Human("Gipsz Jakab", 80));
        assertEquals("Nem lehet 120 évesnél öregebb!", err.getMessage());
    }

    @Test
    void testCreateHumanInvalidName() {
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> human = new Human("Gipsz", 1980));
        assertEquals("Vezeték vagy keresztnév hiányzik!", err.getMessage());
    }
}