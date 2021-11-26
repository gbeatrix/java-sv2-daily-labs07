package day05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> soldProducts = new ArrayList<>();

    public void addProduct(Product p) {
        if (LocalDate.now().compareTo(p.getDate()) < 0) {
            throw new IllegalArgumentException("Invalid date.");
        }
        soldProducts.add(p);
    }

    public Path writeSoldProducts(Month month, Path toFolder) {
        List<String> data = formatDataFilteredByMonth(month);
        Path path = toFolder.resolve(month.toString().toLowerCase() + ".csv");
        try {
            Files.write(path, data);
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong.", e);
        }
        return path;
    }

    private List<String> formatDataFilteredByMonth(Month month) {
        List<String> result = new ArrayList<>();
        for (Product product : soldProducts) {
            if (product.getDate().getMonth() == month) {
                result.add(product.getName() + ";" + product.getDate().toString() + ";" + product.getPrice());
            }
        }
        return result;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }
}
