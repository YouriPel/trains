package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class PassengerWagon extends Wagon {

    private int numberOfSeats;

    public PassengerWagon(int wagonId, int numberOfSeats) {
        this.wagonId = wagonId;
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
