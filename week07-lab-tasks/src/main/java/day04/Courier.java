package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        if (isNewDay(ride)) {
            if (ride.getNth() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Illegal nth for new day.");
            }
        } else if (ride.getNth() == rides.get(rides.size() - 1).getNth() + 1) { // same day
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Illegal nth.");
        }
    }

    private boolean isNewDay(Ride ride) {
        if (rides.isEmpty() || rides.get(rides.size() - 1).getDay() < ride.getDay()) {
            return true;
        } else if (rides.get(rides.size() - 1).getDay() == ride.getDay()) {
            return false;
        } else {
            throw new IllegalArgumentException("Illegal day.");
        }
    }
}
