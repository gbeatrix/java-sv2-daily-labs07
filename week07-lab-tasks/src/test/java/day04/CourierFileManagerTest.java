package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {
    CourierFileManager cfm = new CourierFileManager();
    Courier courier;

    @Test
    void testCourierFileManager(){
        Path path = Paths.get("src/main/resources/rides.csv");
        courier = cfm.createCourierByFile(path);

        assertEquals(6, courier.getRides().size());
    }

    @Test
    void testCourierFileManagerFileNotFound(){
        Path path = Paths.get("src/main/resources/rides.txt");
        IllegalStateException err = assertThrows(IllegalStateException.class,
                () -> courier = cfm.createCourierByFile(path));
        assertEquals("File not found.", err.getMessage());
    }

    @Test
    void testCourierFileManagerIllegalDay(){
        Path path = Paths.get("src/main/resources/ridesWrongDay.csv");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier = cfm.createCourierByFile(path));
        assertEquals("Illegal day.", err.getMessage());
    }

    @Test
    void testCourierFileManagerIllegalNth(){
        Path path = Paths.get("src/main/resources/ridesWrongNth.csv");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier = cfm.createCourierByFile(path));
        assertEquals("Illegal nth.", err.getMessage());
    }

    @Test
    void testCourierFileManagerIllegal1stDay(){
        Path path = Paths.get("src/main/resources/ridesWrong1stDay.csv");
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier = cfm.createCourierByFile(path));
        assertEquals("Illegal nth for new day.", err.getMessage());
    }
}