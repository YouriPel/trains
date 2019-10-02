package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public abstract class Wagon {
    protected int wagonId;
    protected Wagon previousWagon;
    protected Wagon nextWagon;

    public Wagon getLastWagonAttached() {
        // find the last wagon of the row of wagons attached to this wagon
        // if no wagons are attached return this wagon
        Wagon currentWagon = this;

        while (currentWagon != null) {
            currentWagon = currentWagon.nextWagon;
        }

        return currentWagon;
    }

    public void setNextWagon(Wagon nextWagon) {
        // when setting the next wagon, set this wagon to be previous wagon of next wagon
        this.nextWagon = nextWagon;
        nextWagon.previousWagon = this;
    }

    public int getNumberOfWagonsAttached() {
        int totalAttached = 0;
        Wagon currentWagon = this.nextWagon;


        while (currentWagon != null){
            currentWagon = currentWagon.nextWagon;
            totalAttached++;
        }

        return totalAttached;
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
