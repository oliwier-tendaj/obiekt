public class Tram extends Vehicle {
    double fuel;

    //konstruktor
    public Tram(double fuel) {
        this.fuel = fuel;
    }

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
}
