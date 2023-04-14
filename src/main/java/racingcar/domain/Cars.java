package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> registerCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i)));
        }
        return cars;
    }

    public void raceLap(List<Boolean> isMovables) {
        for (int i = 0; i < isMovables.size(); i++) {
            raceCar(cars.get(i), isMovables.get(i));
        }
    }

    private void raceCar(Car car, boolean movable) {
        if (!movable) {
            return;
        }
        car.move();
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cloneList());
    }

    private List<Car> cloneList() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new Car(car.position(), car.name()));
        }
        return result;
    }

    public Cars clone() {
        List<Car> clone = new ArrayList<>();
        for (Car car : cars) {
            clone.add(car.clone());
        }
        return new Cars(clone);
    }

}