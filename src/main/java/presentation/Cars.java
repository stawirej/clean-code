package presentation;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<Car>();
    }

    public void addCar(final Car car) {
        cars.add(car);
    }

    public Cars getCarsByBrand(final String brand) {
        return null;
    }

    public Cars getCarsByType(final CarType carType) {
        return null;
    }
}
