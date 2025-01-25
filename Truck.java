public class Truck extends Vehicle{

    @Override
    int getFixTime() {
        return 10;
    }

    @Override
    public void fixed() {
        System.out.println("the 🚚 is now fixed");
    }

    @Override
    public String toString() {
        return "🚚 Truck:";
    }

}
