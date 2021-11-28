import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej maximalni vahy aut ");
        String weight = sc.nextLine(); // x x x
        String[] splitString = weight.split(" "); // [x, x, x]

        ArrayList<Car> cars = new ArrayList<>();

        for (String s : splitString) {
            int carCapacity = Integer.parseInt(s);
            cars.add(new Car(carCapacity));
        }

        while (true) {
            System.out.println("Zadejte postupne cislo auta, zmenu nakladu a pro ukonceni zadavani END ");
            String response = sc.nextLine();
            if (response.toUpperCase(Locale.ROOT).equals("END"))
                break;
            String[] input = response.split(" ");
            int carId = Integer.parseInt(input[0]) - 1;
            if (!doesCarExist(carId, cars)) {
                System.out.println("Auto nebylo nalezeno ");
            } else {
                Car tempCar = cars.get(carId);
                tempCar.setWeight(Double.parseDouble(input[1]));
            }
        }

        double avg = cars.stream().mapToDouble(Car::getWeight).average().orElse(0.0);
        System.out.println("Prumerna vaha vasich aut je: " + avg);
    }

    public static Car getCar(int id, ArrayList<Car> cars) {
        if (cars.size() <= id || id < 0) {
            System.out.println("Auto nebylo nalezeno ");
            return null;
        }
        return cars.get(id);
    }

    public static boolean doesCarExist(int id, ArrayList<Car> cars) {
        return getCar(id, cars) != null;
    }

    public static boolean isWeightNeg(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getWeight() < 0)
                System.out.println("Vaha je v minusu ");
            return false;
        }
        return true;
    }

    public static boolean isWeightToBig(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getWeight() > car.getCapacity())
                System.out.println("Vaha je prilis vysoka pro vase auto ");
            return false;
        }
        return true;
    }
}
