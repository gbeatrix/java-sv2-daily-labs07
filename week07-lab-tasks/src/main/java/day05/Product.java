package day05;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate date;
    private int price;

    public Product(String name, LocalDate date, int price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }
}
