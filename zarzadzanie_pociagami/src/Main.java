import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);
        static Station myStation = new Station();
    public static void main(String[] args) {
        //Default objects
        Train myTrain = new Train ("Toyota", 2005, 30000.0);
        Train myTrain2 = new Train ("Toyota", 2009, 20000.0);
        Train myTrain3 = new Train ("Mercedes", 2006, 30000.0);

        //adding default objects to station
        myStation.addTrain(myTrain);
        myStation.addTrain(myTrain2);
        myStation.addTrain(myTrain3);

        while (true) {
            System.out.println("wszystkie pociągi na stacji:");
            myStation.printTrains();

            System.out.println("\nwybierz operacje na pociągu:");
            System.out.println("1. szukanie");
            System.out.println("2. usunięcie");
            System.out.println("3. dodanie");
            System.out.println("4. wyjdź z programu");
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
                    break;
                default:
                    System.out.println("został wpisany zły numer operacji");
                    break;
            }
            if (chooseOperation == 4) {
                break;
            }
        }
    }

    public static void searchTrain() {

        System.out.println("\nChcesz szukać pociągu po:");
        System.out.println("1. Marce");
        System.out.println("2. Roku");
        System.out.println("3. Cenie");

        int searchTrain = scanner.nextInt();

        int searchFailedCheck;

        switch (searchTrain) {
            case 1:
                System.out.println("wpisz marke");
                String searchBrand = scanner.next();
                searchFailedCheck = myStation.length();
                for (int i = 0; i < myStation.length(); i++) {
                    if (searchBrand.equalsIgnoreCase(myStation.getTrainBrand(i))) {
                        System.out.println("Pociąg z tą marką to: " + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.length()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tą marką");
                }
                break;
            case 2:
                System.out.println("wpisz rok");
                int searchYear = scanner.nextInt();
                searchFailedCheck = myStation.length();
                for (int i = 0; i < myStation.length(); i++) {
                    if (myStation.getTrainYear(i) == searchYear) {
                        System.out.println("Pociąg z tym rokiem to: " + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.length()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tym rokiem");
                }
                break;
            case 3:
                System.out.println("wpisz cenę");
                double searchPrice = scanner.nextDouble();
                searchFailedCheck = myStation.length();
                for (int i = 0; i < myStation.length(); i++) {
                    if (myStation.getTrainPrice(i) == searchPrice) {
                        System.out.println("Pociąg z tą ceną to: " + myStation.getTrainByInd(i));
                        searchFailedCheck--;
                    }
                }
                if (searchFailedCheck == myStation.length()) {
                    System.out.println("Nie znaleziono żadnych pociągów z tą ceną");
                }
                break;
            default:
                System.out.println("Nieprawidłowy wybór");
                break;
        }
    }

    public static void deleteTrain() {
        System.out.println("\nwpisz numer pociągu ktory chcesz usunąć:");

        int deleteTrain = scanner.nextInt();

        if (deleteTrain >= 1 && deleteTrain <= myStation.length()) {
            myStation.removeTrain(deleteTrain);
        } else {
            System.out.println("\nzły numer pociągu");
        }
    }

    public static Train createTrain() {
        System.out.println("\nwpisz marke pociagu ktorego chcesz dodac:");
        String createTrainBrand = scanner.next();
        System.out.println("\nwpisz rok produkcji pociagu ktorego chcesz dodac:");
        int createTrainYear = scanner.nextInt();
        System.out.println("\nwpisz cene pociagu ktorego chcesz dodac:");
        double createTrainPrice = scanner.nextDouble();

        return new Train (createTrainBrand, createTrainYear, createTrainPrice);
    }
}