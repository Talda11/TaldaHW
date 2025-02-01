public abstract class Vehicle implements Fixable{

    protected String name;
    abstract int getFixTime();

    public Vehicle(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "🚗" + name;
    }
}
