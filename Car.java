public class Car extends Vehicle{


    @Override
    int getFixTime() {
        return 5;
    }

    @Override
    public void fixed() {
        System.out.println("the 🚗 is now fixed");
    }

    @Override
    public String toString() {
        return "🚗 Vehicle";
    }
}
