public class Car {
    private final int capacity;
    private final int load;

    public Car(int capacity) {
        this.capacity = capacity;
        this.load = 0;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getLoad() {
        this.load += load;
    }

    public void setLoad(Dobule w)
        this.w += w;
}
