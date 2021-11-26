package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {
    CourierFileManager cfm = new CourierFileManager();

    @Test
    void testCourierFileManager() {
        Path path = Paths.get("src/test/resources/rides.txt");
        Courier courier = cfm.createCourierByFile(path);

        assertEquals(6, courier.getRides().size());
    }

    @Test
    void testCourierFileManagerFileNotFound() {
        Path path = Paths.get("src/test/resources/rides.csv");
        IllegalStateException err = assertThrows(IllegalStateException.class,
                () -> cfm.createCourierByFile(path));
        assertEquals("File not found.", err.getMessage());
    }

    @Test
    void testCourierFileManagerIllegalFormat() {
        Path path = Paths.get("src/test/resources/ridesWrongFormat.txt");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> cfm.createCourierByFile(path));
        assertEquals("Illegal format.", err.getMessage());
    }
}