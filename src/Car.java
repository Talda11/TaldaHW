public class Car extends Vehicle{

    public Car(String name) {
        super(name);
    }
    @Override
    int getFixTime() {
        return 5;
    }

    @Override
    public void fixed() {
        System.out.println(name + " 🚗 is now fixed");
    }
    public static Vehicle create(String model) {
        return new Car(model);
    }
    @Override
    public String toString() {
        return "🚗 Vehicle";
    }
}
