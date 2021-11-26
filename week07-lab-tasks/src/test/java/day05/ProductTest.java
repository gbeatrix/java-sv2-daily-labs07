package day05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testCreateProduct() {
        Product product = new Product("Kenyér", LocalDate.of(2021, 11, 26), 300);
        assertEquals("Kenyér", product.getName());
        assertEquals("2021-11-26", product.getDate().toString());
        assertEquals(300, product.getPrice());
    }
}