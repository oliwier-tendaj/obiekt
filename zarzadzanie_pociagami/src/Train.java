public class Train {
    String TrainBrand;
    int year;
    double price;

    public Train(String TrainBrand, int year, double price) {
        this.TrainBrand = TrainBrand;
        this.year = year;
        this.price = price;
    }

    String getTrainBrand() { return this.TrainBrand; }

    int getTrainYear() { return this.year; }

    double getTrainPrice() { return this.price; }

    @Override
    public String toString() {
        return TrainBrand + "-" + year + "-" + price;
    }
}