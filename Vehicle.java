public abstract class Vehicle implements Fixable{

    abstract int getFixTime();

    @Override
    public String toString() {
        return "🚗 Vehicle: ";
    }
}
