package model;

/**
 * @author Youri Pellicaan & Koen van der Tuin
 */

public class Train {
    private Locomotive engine;
    private Wagon firstWagon;
    private String destination;
    private String origin;
    private int numberOfWagons;

    public Train(Locomotive engine, String origin, String destination) {
        this.engine = engine;
        this.destination = destination;
        this.origin = origin;
    }

    public Wagon getFirstWagon() {
        return firstWagon;
    }

    public void setFirstWagon(Wagon firstWagon) {
        this.firstWagon = firstWagon;
    }

    public void resetNumberOfWagons() {
       /*  when wagons are hooked to or detached from a train,
         the number of wagons of the train should be reset
         this method does the calculation */

        numberOfWagons = firstWagon.getNumberOfWagonsAttached() + 1;

    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }


    /* three helper methods that are usefull in other methods */

    public boolean hasNoWagons() {
        return (firstWagon == null);
    }

    public boolean isPassengerTrain() {
        return firstWagon instanceof PassengerWagon;
    }

    public boolean isFreightTrain() {
        return firstWagon instanceof FreightWagon;
    }

    public int getPositionOfWagon(int wagonId) {
        // find a wagon on a train by id, return the position (first wagon had position 1)
        // if not found, than return -1

        int currentIndex = 1;
        Wagon currentWagon = firstWagon;

        while (currentWagon != null) {
            if (wagonId == currentWagon.wagonId) {
                return currentIndex;
            }

            currentWagon = currentWagon.nextWagon;
            currentIndex++;
        }

        return -1;
    }


    public Wagon getWagonOnPosition(int position) throws IndexOutOfBoundsException {
        /* find the wagon on a given position on the train
         position of wagons start at 1 (firstWagon of train)
         use exceptions to handle a position that does not exist */

        if (position > getNumberOfWagons() || position < 1) {
            throw new IndexOutOfBoundsException();
        }

        int currentPosition = 1;
        Wagon currentWagon = firstWagon;

        while (currentPosition != position) {
            currentWagon = currentWagon.nextWagon;
            currentPosition++;
        }

        return currentWagon;
    }

    public int getNumberOfSeats() {
        /* give the total number of seats on a passenger train
         for freight trains the result should be 0 */
        int totalSeats = 0;

        if (isFreightTrain()) {
            return totalSeats;
        }

        PassengerWagon currentWagon = (PassengerWagon) this.firstWagon;

        while (currentWagon != null) {
            totalSeats += currentWagon.getNumberOfSeats();
            currentWagon = ((PassengerWagon) currentWagon.nextWagon);
        }

        return totalSeats;
    }

    public int getTotalMaxWeight() {
        /* give the total maximum weight of a freight train
         for passenger trains the result should be 0 */

        Wagon currentWagon = this.firstWagon;
        int totalMaxWeight = 0;

        if (isFreightTrain()) {
            while (currentWagon != null) {
                FreightWagon f = (FreightWagon) currentWagon;
                totalMaxWeight += f.getMaxWeight();
                currentWagon = currentWagon.nextWagon;
            }
        }
        return totalMaxWeight;
    }

    public Locomotive getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(engine.toString());
        Wagon next = this.getFirstWagon();
        while (next != null) {
            result.append(next.toString());
            next = next.getNextWagon();
        }
        result.append(String.format(" with %d wagons and %d seats from %s to %s", numberOfWagons, getNumberOfSeats(), origin, destination));
        return result.toString();
    }
}
