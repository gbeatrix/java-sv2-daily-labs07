package day02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    Path path;

    @Test
    void testCreateMovieService() {
        path = Paths.get("src/main/resources/movies.csv");
        MovieService movieService = new MovieService(path);
        assertEquals(5, movieService.getMovies().size());
        assertEquals("George Lucas", movieService.getMovies().get(2).getDirector());
        assertEquals(2002, movieService.getMovies().get(3).getYear());
        assertEquals("Titanic", movieService.getMovies().get(1).getTitle());
    }

    @Test
    void testMovieServiceFileNotFound() {
        path = Paths.get("src/main/resources/movies.txt");
        IllegalStateException err = assertThrows(IllegalStateException.class,
                () -> new MovieService(path));
        assertEquals("File not found.", err.getMessage());
    }

    @Test
    void testMovieServiceInvalidYear() {
        path = Paths.get("src/test/resources/moviesInvalidYear.csv");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> new MovieService(path));
        assertEquals("Year must be integer.", err.getMessage());
    }

    @Test
    void testMovieServiceInvalidFormat() {
        path = Paths.get("src/test/resources/moviesInvalidFormat.csv");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> new MovieService(path));
        assertEquals("Invalid file.", err.getMessage());
    }
}