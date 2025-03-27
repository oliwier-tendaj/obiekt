public class Train extends Vehicle {
    String brand;
    int year;
    double price;
    double fuel;

    //konstruktor
    public Train(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    //gettery

    String getTrainBrand() { return this.brand; }

    int getTrainYear() { return this.year; }

    double getTrainPrice() { return this.price; }

    //settery

    private void setTrainBrand(String newBrand) { this.brand = newBrand; }

    private void setTrainYear(int newYear) { this.year = newYear; }

    private void setTrainPrice(double newPrice) { this.price = newPrice; }

    //implementacja interfejsu

    //sprawdza ilość paliwa w pojeździe
    public void checkFuel() {
        System.out.println("stan paliwa: " + fuel + " litrów");
    }

    //dodaje paliwo do pojazdu
    public void addFuel(double newFuel) {
        fuel = fuel + newFuel;
    }

    //pojazd jedzie do następnej stacji
    public void nextStation() {
        fuel = fuel - 10.0;
    }

    @Override
    public String toString() {
        return brand + "-" + year + "-" + price + "zł";
    }
}