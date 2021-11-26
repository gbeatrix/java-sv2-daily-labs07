package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store();

    @TempDir
    File tempFolder;

    @BeforeEach
    void init() {
        Product[] products = new Product[6];
        products[0] = new Product("Kenyér", LocalDate.of(2021, 11, 26), 300);
        products[1] = new Product("Tej", LocalDate.of(2021, 8, 26), 200);
        products[2] = new Product("Sampon", LocalDate.of(2021, 11, 26), 800);
        products[3] = new Product("Banán", LocalDate.of(2021, 7, 26), 400);
        products[4] = new Product("Ceruzaelem", LocalDate.of(2021, 9, 26), 600);
        products[5] = new Product("Bonbon", LocalDate.of(2021, 11, 26), 800);
        for (int i = 0; i < 6; i++) {
            store.addProduct(products[i]);
        }
    }

    @Test
    void testAddValidProducts() {
        assertEquals(6, store.getSoldProducts().size());
        assertEquals(300, store.getSoldProducts().get(0).getPrice());
        assertEquals("Tej", store.getSoldProducts().get(1).getName());
    }

    @Test
    void testAddInvalidProduct() {
        Product milk = new Product("Tej", LocalDate.of(2121, 11, 26), 200);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> store.addProduct(milk));
        assertEquals("Invalid date.", err.getMessage());
    }

    @Test
    void writeSoldProducts() throws IOException {
        Path path = store.writeSoldProducts(Month.NOVEMBER, tempFolder.toPath());
        assertEquals(tempFolder.toString() + "/november.csv", path.toString());

        List<String> actual = Files.readAllLines(path);
        List<String> expected = Arrays.asList(
                "Kenyér;2021-11-26;300",
                "Sampon;2021-11-26;800",
                "Bonbon;2021-11-26;800"
        );
        assertEquals(expected, actual);
    }
}