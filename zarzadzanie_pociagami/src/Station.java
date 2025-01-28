import java.util.ArrayList;
import java.util.List;

public class Station {

    public List<Train> arrayList = new ArrayList<>();

    public Station() {
        this.arrayList = arrayList;
    }

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

    public void addTrain(Train Train) {
        arrayList.add(Train);
    }

    public void removeTrain(int ind) {
        arrayList.remove(ind-1);
    }

    public int length() {
        return arrayList.size();
    }

    public void printTrains() {
        for (int i = 0; i < arrayList.size(); i++) {
            int counter = i+1;
            System.out.println(counter + ". " + getTrainByInd(i));
        }
    }
}
