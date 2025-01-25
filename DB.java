import java.util.ArrayList;

public class DB {

    private ArrayList<Vehicle> DB;

    public DB()
    {
        DB = new ArrayList<>();
    }
    public void addVehicle(Vehicle v)
    {
        DB.add(v);
    }
    public ArrayList<Vehicle> getVehicles() {
        return DB;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🗂️ Database of Vehicles:\n");
        for (Vehicle vehicle : DB) {
            sb.append(vehicle.toString()).append("\n");
        }
        return sb.toString();
    }
}
