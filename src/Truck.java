public class Truck extends Vehicle{

    public Truck(String name) {
        super(name);
    }
    @Override
    int getFixTime() {
        return 10;
    }
    public static Vehicle create(String name) {
        return new Truck(name);
    }
    @Override
    public void fixed() {
        System.out.println(name + " is now fixed 🚚");
    }

    @Override
    public String toString() {
        return "🚚 Truck:";
    }

}
