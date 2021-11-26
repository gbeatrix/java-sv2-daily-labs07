package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {
    public Courier createCourierByFile(Path path) {
        Courier courier = new Courier();
        List<String> contents;

        try {
            contents = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("File not found.", e);
        }

        for (String line : contents) {
            try {
                String[] parts = line.split(" ");
                int day = Integer.parseInt(parts[0]);
                int nth = Integer.parseInt(parts[1]);
                int km = Integer.parseInt(parts[2]);
                courier.addRide(new Ride(day, nth, km));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Illegal format.", e);
            }
        }

        return courier;
    }
}
