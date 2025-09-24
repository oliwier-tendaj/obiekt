import java.util.ArrayList;
import java.util.List;

public class StationNetwork {
    public List<Station> arrayList = new ArrayList<>();

    //konstruktor
    public StationNetwork() {
        this.arrayList = arrayList;
    }

    //gettery
    public String getStationName(int ind) {
        return arrayList.get(ind).getStationName();
    }

    public String getStationByInd(int ind) {
        return arrayList.get(ind).toString();
    }

    //manipulacja na tabeli pociągów
    public void addStation(Station Station) {
        arrayList.add(Station);
    }

    public void removeStation(int ind) {
        arrayList.remove(ind-1);
    }

    public void printStations() {
        for (int i = 0; i < arrayList.size(); i++) {
            int counter = i+1;
            System.out.println(counter + ". " + getStationByInd(i));
        }
    }

    //size
    public int size() {
        return arrayList.size();
    }
}
