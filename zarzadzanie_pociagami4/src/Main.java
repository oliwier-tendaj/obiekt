import java.util.Scanner;

public class Main {
        //definiowanie materiałów przydatnych później w kodzie
        static Scanner scanner = new Scanner(System.in);
        static Station myStation = new Station();
    public static void main(String[] args) {
        //defaultowe obiekty
        Train myTrain = new Train ("Toyota", 2005, 30000.0);
        Train myTrain2 = new Train ("Toyota", 2009, 20000.0);
        Train myTrain3 = new Train ("Mercedes", 2006, 30000.0);
        Vehicle myTram = new Train ("Mercedes", 2006, 30000.0);

        //dodawanie obiektów do stacji
        myStation.addTrain(myTrain);
        myStation.addTrain(myTrain2);
        myStation.addTrain(myTrain3);
        myStation.addTrain(myTram);

        while (true) {
            //wypisywanie pojazdów na stacji
            System.out.println("wszystkie pociągi na stacji:");
            myStation.printTrains();

            //wybor operacji na pojeździe
            System.out.println("\nwybierz operacje na pojeździe:");
            System.out.println("1. szukanie");
            System.out.println("2. usunięcie");
            System.out.println("3. dodanie");
            System.out.println("4. pojedź do następnej stacji i wypisz stan paliwa");
            System.out.println("5. wyjdź z programu");

            int chooseOperation = scanner.nextInt();

            switch (chooseOperation) {
                case 1:
                    searchTrain();
                    break;
                case 2:
                    deleteTrain();
                    break;
                case 3:
                    myStation.addTrain(createTrain());
                    break;
                case 4:
                    myTram.nextStation();
                    myTram.checkFuel();
                    break;
                case 5:
                    System.out.println("wychodzenie z programu...");
                    break;
                default:
                    System.out.println("został wpisany zły numer operacji");
                    break;
            }
            if (chooseOperation == 6) {
                break;
            }
        }
    }

    //metoda do wyszukiwania pociągów po różnych parametrach
    public static void searchTrain() {

        //wybor parametrów szukania
        System.out.println("\nChcesz szukać pociągu po:");
        System.out.println("1. Marce");
        System.out.println("2. Roku");
        System.out.println("3. Cenie");

        int searchTrain = scanner.nextInt();

        int searchFailedCheck;

        //wybor po jakim parametrze szukamy
        switch (searchTrain) {
            //szukanie po marce pociągu
            case 1:
                System.out.println("wpisz marke pociagu");
                String searchBrand = scanner.next();
                searchFailedCheck = myStation.size();
                for (int i = 0; i < myStation.size(); i++) {
                    if (searchBrand.equalsIgnoreCase(myStation.getTrainBrand(i))) {
                        int counter = i+1;
                        System.out.println("Pociąg z tą marką to: " + counter + ". " + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.size()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tą marką");
                }
                break;
            //szukanie po roku produkcji pociągu
            case 2:
                System.out.println("wpisz rok produkcji pociagu");
                int searchYear = scanner.nextInt();
                searchFailedCheck = myStation.size();
                for (int i = 0; i < myStation.size(); i++) {
                    if (myStation.getTrainYear(i) == searchYear) {
                        int counter = i+1;
                        System.out.println("Pociąg z tym rokiem produkcji to: " + counter + ". "  + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.size()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tym rokiem produkcji");
                }
                break;
            //szukanie po cenie pociągu
            case 3:
                System.out.println("wpisz cenę");
                double searchPrice = scanner.nextDouble();
                searchFailedCheck = myStation.size();
                for (int i = 0; i < myStation.size(); i++) {
                    if (myStation.getTrainPrice(i) == searchPrice) {
                        int counter = i+1;
                        System.out.println("Pociąg z tą ceną to: " + counter + ". "  + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.size()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tą ceną");
                }
                break;
            default:
                System.out.println("Nieprawidłowy wybór");
                break;
        }
    }

    //metoda do usuwania pociągów
    public static void deleteTrain() {
        System.out.println("\nwpisz numer pociągu ktory chcesz usunąć:");

        int deleteTrain = scanner.nextInt();

        if (deleteTrain >= 1 && deleteTrain <= myStation.size()) {
            myStation.removeTrain(deleteTrain);
        } else {
            System.out.println("\nzły numer pociągu");
        }
    }

    //metoda do dodawania pociągów
    public static Train createTrain() {

        System.out.println("\nwpisz marke pociagu ktorego chcesz dodac:");
        String createTrainBrand = scanner.next();
        System.out.println("\nwpisz rok produkcji pociagu ktorego chcesz dodac:");
        int createTrainYear = scanner.nextInt();
        System.out.println("\nwpisz cene pociagu ktorego chcesz dodac:");
        double createTrainPrice = scanner.nextDouble();

        System.out.println("\nwpisz typ pociagu ktorego chcesz dodac:");
        System.out.println("1. towarowy 2. osobowy  ");
        int trainChoice = scanner.nextInt();

        switch (trainChoice)  {
            case 1:
                System.out.println("\nwpisz pojemność pociagu ktorego chcesz dodac:");
                int createTrainCapacity = scanner.nextInt();
                return new TrainFreight (createTrainBrand, createTrainYear, createTrainPrice, createTrainCapacity);
            case 2:
                System.out.println("\nwpisz ilosc miejsc siedzącch pociagu ktorego chcesz dodac:");
                int createTrainSeatNumber = scanner.nextInt();
                return new TrainPassenger (createTrainBrand, createTrainYear, createTrainPrice, createTrainSeatNumber);
            default:
                System.out.println("\nzostał wpisany zły typ pociągu");
                break;
        }

        return null;
    }
}