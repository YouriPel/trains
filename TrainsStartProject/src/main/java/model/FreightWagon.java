package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class FreightWagon extends Wagon {

    private int maxWeight;

    public FreightWagon(int wagonId, int maxWeight) {
        super(wagonId);
        this.maxWeight = maxWeight;
    }
}