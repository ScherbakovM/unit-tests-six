package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Double> getNumbersFromUser() {
        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Ввод не может быть пустым. Пожалуйста, введите хотя бы одно число.");
        }

        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Ввод не может быть пустым. Пожалуйста, введите хотя бы одно число.");
        }

        String[] numbersAsString = input.split(" ");
        List<Double> numbers = new ArrayList<>();
        for (String numberAsString : numbersAsString) {
            try {
                numbers.add(Double.parseDouble(numberAsString));
            } catch (NumberFormatException e) {
                System.out.println(numberAsString + " не является допустимым числом. Пожалуйста, введите только числа.");
            }
        }
        return numbers;
    }
}
