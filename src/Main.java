import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DB VehicleMap = new DB();
        int num = 0;
        while (num != -1) {

            System.out.print("Enter a number: 1 for Motorcycle, 2 for Car, 3 for Truck, -1 to stop -> ");
            num = scanner.nextInt();
            scanner.nextLine();

            if (num == -1) break;

            System.out.print("Enter the vehicle name: ");
            String name = scanner.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("❌ Invalid name. Enter again: ");
                name = scanner.nextLine().trim();
            }

            VehicleMap.build(num, name);
        }
        scanner.close();

        System.out.println("✅ Thank you for entering the vehicles! The garage is starting...");

        Protocol_Garage garageProtocol = new Protocol_Garage() {
            @Override
            public void fixed() {
                System.out.println("✅ Another vehicle has been repaired!\n");
            }
        };

        Garage garage = new Garage(garageProtocol);

        for (Queue<Vehicle> queue : VehicleMap.getVehicleMap().values()) {
            for (Vehicle v : queue) {
                garage.addToGarage(v);
            }
        }

        garage.startClock();
        System.out.println("🚗 'TaldaGarage' is now open!");
    }

}
