package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        try {
            List<String> contents = Files.readAllLines(path);
            addMovies(contents);
        } catch (IOException err) {
            throw new IllegalStateException("File not found.", err);
        }
    }

    private void addMovies(List<String> contents) {
        for (String line : contents) {
            try {
                String[] parts = line.split(";");
                movies.add(new Movie(parts[0], Integer.parseInt(parts[1]), parts[2]));
            } catch (NumberFormatException err) {
                throw new IllegalArgumentException("Year must be integer.", err);
            } catch (ArrayIndexOutOfBoundsException err) {
                throw new IllegalArgumentException("Invalid file.", err);
            }
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
