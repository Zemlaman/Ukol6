import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej maximalni vahy");
        String weight = sc.nextLine(); // x x x
        String[] splitString = weight.split(" "); // [x, x, x]

        ArrayList<Car> cars = new ArrayList<>();

        for (String s : splitString) {
            int carCapacity = Integer.parseInt(s);
            cars.add(new Car(carCapacity));
        }

        while (true) {
            System.out.println("Zadavejte {číslo auta} a {změnu nákladu}, pro konec END");
            String response = sc.nextLine();// input
            if (response.toUpperCase(Locale.ROOT).equals("END"))
                break;
            String[] input = response.split(" ");
            int carId = Integer.parseInt(input[0]) - 1;
            if (!doesCarExist(carId, cars)) {
                System.out.println("Toto auto neexistuje");
            } else {
                Car tempCar = cars.get(carId);
                tempCar.setWeight(Double.parseDouble(input[1])); // upravuje hodnotu
            }
        }

        double avg = cars.stream().mapToDouble(Car::getWeight).average().orElse(0.0);
        System.out.println("Avarage vaha vasich aut je: " + avg);
    }

    public static boolean doesCarExist(int id, ArrayList<Car> cars) {
        return getCar(id, cars) != null;
    }

    public static Car getCar(int id, ArrayList<Car> cars) {
        if (cars.size() <= id || id < 0) {
            System.out.println("Auto neexistuje " + id);
            return null;
        }
        return cars.get(id);
    }

    public static boolean isCarWeightInMinus(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getWeight() < 0)
                System.out.println("Vaha je v minusu, vahu neukladam, zadejte znovu");
            return false;
        }
        return true;
    }

    public static boolean isCarOverWeighted(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getWeight() > car.getCapacity())
                System.out.println("Vaha auta je prilis vysoka, vahu neukladam, zadejte znovu");
            return false;
        }
        return true;
    }
}
