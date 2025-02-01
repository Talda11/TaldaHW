import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DB {

    private HashMap<Integer, Queue<Vehicle>> VehicleMap;

    public DB() {
        VehicleMap = new HashMap<>();

        VehicleMap.put(1, new LinkedList<>()); // אופנועים
        VehicleMap.put(2, new LinkedList<>()); // מכוניות
        VehicleMap.put(3, new LinkedList<>()); // משאיות
    }
    public void build(int type, String model) {
        switch (type) {
            case 1:
                VehicleMap.get(1).add(MotorCycle.create(model));
                break;
            case 2:
                VehicleMap.get(2).add(Car.create(model));
                break;
            case 3:
                VehicleMap.get(3).add(Truck.create(model));
                break;
            default:
                System.out.println("❌ Invalid number. Try again.");
                break;
        }
    }


    // פונקציה להחזרת המפה
    public HashMap<Integer, Queue<Vehicle>> getVehicleMap() {
        return VehicleMap;
    }
}
