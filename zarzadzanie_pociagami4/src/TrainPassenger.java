public class TrainPassenger extends  Train {
    
    int seatNumber;
    
    public TrainPassenger(String brand, int year, double price, int seatNumber) {
        super(brand, year, price);
        this.seatNumber = seatNumber;
    }

    //gettery

    int getTrainSeatNumber() { return this.seatNumber; }

    //settery

    private void setSeatNumber(int newSeatNumber) { this.seatNumber = newSeatNumber; }

    @Override
    public String toString() {
        return brand + "-" + year + "-" + price + "zł-" + seatNumber + " miejsc";
    }
}
