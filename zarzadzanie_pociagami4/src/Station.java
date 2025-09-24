import java.util.ArrayList;
import java.util.List;

public class Station extends StationNetwork {
    public List<Vehicle> arrayList = new ArrayList<>();
    String name;

    //konstruktor
    public Station(String name) {
        this.arrayList = arrayList;
        this.name = name;
    }

    //gettery
    String getStationName() { return this.name; }

    public String getTrainBrand(int ind) {
        return arrayList.get(ind).getTrainBrand();
    }

    public int getTrainYear(int ind) {
        return arrayList.get(ind).getTrainYear();
    }

    public double getTrainPrice(int ind) {
        return arrayList.get(ind).getTrainPrice();
    }

    public String getTrainByInd(int ind) {
        return arrayList.get(ind).toString();
    }

    //manipulacja na tabeli pociągów
    public void addTrain(Vehicle Vehicle) {
        arrayList.add(Vehicle);
    }

    public void removeTrain(int ind) {
        arrayList.remove(ind-1);
    }

    public void printTrains() {
        for (int i = 0; i < arrayList.size(); i++) {
            int counter = i+1;
            System.out.println(counter + ". " + getTrainByInd(i));
        }
    }

    //size
    public int size() {
        return arrayList.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
