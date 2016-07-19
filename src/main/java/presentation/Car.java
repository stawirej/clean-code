package presentation;

public class Car {

    private final String brand;
    private final CarType type;

    public Car(final String brand, final CarType type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public CarType getType() {
        return type;
    }
}
