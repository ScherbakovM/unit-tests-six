package numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ListManager listManager = new ListManager();

        System.out.println("Введите числа для первого списка (через пробел):");
        List<Double> list1 = inputManager.getNumbersFromUser();

        System.out.println("Введите числа для второго списка (через пробел):");
        List<Double> list2 = inputManager.getNumbersFromUser();

        double avg1 = listManager.calculateAverage(list1);
        double avg2 = listManager.calculateAverage(list2);

        if (avg1 > avg2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (avg1 < avg2) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }
}