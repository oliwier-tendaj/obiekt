public class TrainFreight extends Train {

    int capacity;

    public TrainFreight(String TrainBrand, int year, double price, int capacity) {
        super(TrainBrand, year, price);
        this.capacity = capacity;
    }

    //gettery

    int getTrainCapacity() { return this.capacity; }

    //settery

    private void setCapacity(int newCapacity) { this.capacity = newCapacity; }

    @Override
    public String toString() {
        return brand + "-" + year + "-" + price + "zł-" + capacity + "l";
    }
}
