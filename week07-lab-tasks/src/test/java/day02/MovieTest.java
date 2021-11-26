package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void testCreateMovie() {
        Movie movie = new Movie("Star Wars", 1977, "George Lucas");
        assertEquals("Star Wars", movie.getTitle());
        assertEquals(1977, movie.getYear());
        assertEquals("George Lucas", movie.getDirector());
    }
}