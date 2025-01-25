public class MotorCycle extends Vehicle{

    @Override
    int getFixTime() {
        return 3;
    }

    @Override
    public void fixed() {
        System.out.println("the 🏍️ is now fixed");
    }

    public String toString() {
        return "🏍️ Motorcycle:";
    }
}
