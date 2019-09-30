package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class Wagon {
    private int wagonId;
    private Wagon previousWagon;
    private Wagon nextWagon;

    public Wagon (int wagonId) {
        this.wagonId = wagonId;
    }

    public Wagon getLastWagonAttached() {
        // find the last wagon of the row of wagons attached to this wagon
        // if no wagons are attached return this wagon
        Wagon currentWagon = null;
        while (previousWagon != null){
            currentWagon = previousWagon;
            previousWagon = currentWagon.previousWagon;
        }

        return currentWagon;
    }

    public void setNextWagon(Wagon nextWagon) {
        // when setting the next wagon, set this wagon to be previous wagon of next wagon
        nextWagon = nextWagon.previousWagon;

    }

    public Wagon getPreviousWagon() {
        return previousWagon;
    }

    public void setPreviousWagon(Wagon previousWagon) {
        this.previousWagon = previousWagon;
    }

    public Wagon getNextWagon() {
        return nextWagon;
    }

    public int getWagonId() {
        return wagonId;
    }
//Get total of Wagons Attached
    public int getNumberOfWagonsAttached() {

        int totalAttached = 0;
        Wagon currentWagon = null;
        while (previousWagon != null){
            totalAttached++;
            currentWagon = previousWagon;
            previousWagon = currentWagon.previousWagon;
        }

        return totalAttached;
    }

    public boolean hasNextWagon() {
        return !(nextWagon == null);
    }

    public boolean hasPreviousWagon() {
        return !(previousWagon == null);
    }

    @Override
    public String toString() {
        return String.format("[Wagon %d]", wagonId);
    }
}
