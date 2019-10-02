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
        Wagon lastWagon = this;

        while (lastWagon.nextWagon != null) {
            lastWagon = lastWagon.nextWagon;
        }

        return lastWagon;
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

    public Wagon getNextWagon() {
        return nextWagon;
    }

    public int getWagonId() {
        return wagonId;
    }

    @Override
    public String toString() {
        return String.format("[Wagon %d]", wagonId);
    }
}
