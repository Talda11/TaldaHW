import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("press num: 1 for MotorCycle ,2 for Car, 3 for Truck, -1 to stop->");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Vehicle> vecList = new ArrayList<Vehicle>();
        while (num != -1)
        {
            switch (num) {
                case 1:
                    Vehicle MotorCyc = new MotorCycle();
                    vecList.add(MotorCyc);
                    break;
                case 2:
                    Vehicle Car = new Car();
                    vecList.add(Car);
                    break;
                case 3:
                    Vehicle Truck = new Truck();
                    vecList.add(Truck);
                    break;
                default:
                    System.out.println("pressed invalid num");
                    break;
            }
            System.out.println("press num: 1 for MotorCycle ,2 for Car, 3 for Truck, -1 to stop->1");
            scanner = new Scanner(System.in);
            num = scanner.nextInt();
        }
        scanner.close();
        System.out.println("thank you for entering vehicles :), plz wait");
        Protocol_Garage garageProtocol = new Protocol_Garage() {
            @Override
            public void fixed() {
                System.out.println("the garage fixed another vehicle :)\n");
            }
        };
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        Garage garage = new Garage(garageProtocol,vehicleQueue);


        for (Vehicle v : vecList) {
            garage.addToGarage(v);
        }

        garage.startClock();
        System.out.println("TaldaGarage is now open!\n");
    }
}