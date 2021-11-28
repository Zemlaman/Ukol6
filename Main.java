import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        String load = sc.nextLine(); // x x x
        String[] loads = load.split(" "); // x, x, x
        ArrayList<Car> cars = new ArrayList<>();

        for (String car : loads) {
            int carCapacity = Integer.parseInt(car);
            cars.add(new Car(carCapacity));
        }

        String input1 = sc.nextLine(); //1, +30
        String[] splittedInput = input1.split("");
        int carID = Integer.parseInt(splittedInput[0]) - 1;



        //1 +30

    }

    public static void addLoad(HashSet<Integer> cars) {
        final Scanner sc = new Scanner(System.in);
        int cargo = 0;

        for (int i = 0; i < cars.size(); i++) {
            if(cargo < 0 && cargo > cars.get)
            cars.add(i ,cargo);
        }
        String maxLoad = sc.nextLine();
        do{
            int load = Integer.parseInt(maxLoad);
            cars[1] = new Car(author, name, length);
        } while(!maxLoad.equals("END"));
    }
}
