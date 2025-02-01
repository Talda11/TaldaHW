public class MotorCycle extends Vehicle{

    public MotorCycle(String name) {
        super(name);
    }
    @Override
    int getFixTime() {
        return 3;
    }
    public static Vehicle create(String name) {
        return new MotorCycle(name);
    }
    @Override
    public void fixed() {
        System.out.println(name + " is now fixed 🏍️");
    }

    public String toString() {
        return "🏍️ Motorcycle:";
    }
}
