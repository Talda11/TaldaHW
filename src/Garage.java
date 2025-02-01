import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {
    private Protocol_Garage protocol;
    private Queue<Vehicle> vehicleQueue;
    private int curFixTime = 0;

    public Garage(Protocol_Garage protocol) {
        this.protocol = protocol;
        this.vehicleQueue = new LinkedList<>();
    }

    public void addToGarage(Vehicle vehicle) {
        vehicleQueue.add(vehicle);
    }

    public void startClock() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> {
            if (!vehicleQueue.isEmpty()) {
                Vehicle currentVehicle = vehicleQueue.peek();
                int fixTime = currentVehicle.getFixTime();

                if (curFixTime >= fixTime) {
                    currentVehicle.fixed();
                    protocol.fixed();
                    vehicleQueue.poll();
                    curFixTime = 0;
                } else {
                    curFixTime++;
                }
            } else {
                System.out.println("🔧 All vehicles have been repaired! TaldaGarage is closing.");
                executor.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
