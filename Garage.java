import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {

    private Protocol_Garage protocol;
    private Queue<Vehicle> vehicleQueue;
    private int curFixTime = 0;

    public Garage(Protocol_Garage protocol, Queue<Vehicle> vehicleQueue) {
        this.protocol = protocol;
        this.vehicleQueue = vehicleQueue;
    }

    public void addToGarage(Vehicle vehicle) {
        vehicleQueue.add(vehicle);
    }

    public void startClock() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> {
            if (!vehicleQueue.isEmpty()) {
                Vehicle currentVehicle = vehicleQueue.peek(); // לא מסירים עדיין
                int fixTime = currentVehicle.getFixTime();

                if (curFixTime >= fixTime) {
                    currentVehicle.fixed();
                    protocol.fixed();
                    System.out.println("protocol activated");
                    vehicleQueue.remove(); // מסירים אחרי תיקון
                    curFixTime = 0;
                } else {
                    curFixTime++;
                }
            } else {
                System.out.println("The garage has fixed all the vehicles. Thank you for choosing TaldaGarage :)");
                executor.shutdown(); // מפסיקים את השעון
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

}