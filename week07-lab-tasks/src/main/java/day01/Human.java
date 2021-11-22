package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        int thisYear = LocalDate.now().getYear();
        if (thisYear - yearOfBirth > 120) {
            throw new IllegalArgumentException("Nem lehet 120 évesnél öregebb!");
        }
        if (name == null || name.trim().split(" ").length <= 1) {
            throw new IllegalArgumentException("Vezeték vagy keresztnév hiányzik!");
        }
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getAge() {
        int thisYear = LocalDate.now().getYear();
        return thisYear - yearOfBirth;
    }
}
