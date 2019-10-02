package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class FreightWagon extends Wagon {

    private int maxWeight;

    public FreightWagon(int wagonId, int maxWeight) {
        this.wagonId = wagonId;
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
