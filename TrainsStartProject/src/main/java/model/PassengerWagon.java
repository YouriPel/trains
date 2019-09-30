package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class PassengerWagon extends Wagon {

    private int numberOfSeats;

    public PassengerWagon(int wagonId, int numberOfSeats) {
        super(wagonId);
        this.numberOfSeats = numberOfSeats;
    }
}
