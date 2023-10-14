package numbers;

import java.util.List;

public class ListManager {
    public double calculateAverage(List<Double> list) {
        return list.stream().mapToDouble(i -> i).average().getAsDouble();
    }
}