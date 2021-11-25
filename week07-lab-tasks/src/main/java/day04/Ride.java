package day04;

public class Ride {
    private int day;
    private int nth;
    private int km;

    public int getDay() {
        return day;
    }

    public int getNth() {
        return nth;
    }

    public int getKm() {
        return km;
    }

    public Ride(int day, int nth, int km) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Day must be between 1 and 7.");
        }
        if (km <= 0) {
            throw new IllegalArgumentException("Km must be positive.");
        }

        this.day = day;
        this.nth = nth;
        this.km = km;
    }
}
