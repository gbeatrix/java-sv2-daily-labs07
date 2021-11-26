package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {
    Courier courier = new Courier();

    @Test
    void testEmptyCourier() {
        assertNotNull(courier.getRides());
        assertEquals(0, courier.getRides().size());
    }

    @Test
    void testAddValidRides() {
        courier.addRide(new Ride(5, 1, 7));
        courier.addRide(new Ride(5, 2, 6));
        courier.addRide(new Ride(5, 3, 21));
        courier.addRide(new Ride(7, 1, 9));
        assertEquals(4, courier.getRides().size());
        assertEquals(3, courier.getRides().get(2).getNth());
        assertEquals(6, courier.getRides().get(1).getKm());
        assertEquals(7, courier.getRides().get(3).getDay());
    }

    @Test
    void testAddInvalidFirstRide() {
        Ride wrongRide = new Ride(5, 6, 7);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Illegal nth for new day.", err.getMessage());
    }

    @Test
    void testAddInvalidDayRide() {
        courier.addRide(new Ride(7, 1, 9));
        Ride wrongRide = new Ride(5, 1, 7);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Illegal day.", err.getMessage());
    }

    @Test
    void testAddInvalidNewDayRide() {
        courier.addRide(new Ride(5, 1, 9));
        Ride wrongRide = new Ride(7, 2, 7);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Illegal nth for new day.", err.getMessage());
    }

    @Test
    void testAddInvalidNthRide() {
        courier.addRide(new Ride(5, 1, 9));
        Ride wrongRide = new Ride(5, 3, 7);
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Illegal nth.", err.getMessage());
    }
}
