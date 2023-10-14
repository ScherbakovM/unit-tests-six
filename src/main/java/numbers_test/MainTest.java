package numbers_test;

import numbers.InputManager;
import numbers.ListManager;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class MainTest {
    private InputManager inputManager;
    private ListManager listManager;

    @Before
    public void setUp() {
        inputManager = new InputManager();
        listManager = new ListManager();
    }

    @Test
    public void testGetNumbersFromUser() {
        String input = "1 2 3 4 5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        inputManager.setScanner(scanner);

        List<Double> numbers = inputManager.getNumbersFromUser();
        assertEquals(5, numbers.size());
        assertEquals(1.0, numbers.get(0), 0.001);
        assertEquals(2.0, numbers.get(1), 0.001);
        assertEquals(3.0, numbers.get(2), 0.001);
        assertEquals(4.0, numbers.get(3), 0.001);
        assertEquals(5.0, numbers.get(4), 0.001);
    }

    @Test
    public void testCalculateAverage() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double average = listManager.calculateAverage(numbers);
        assertEquals(3.0, average, 0.001);
    }
    @Test
    public void testInvalidInput() {
        String input = "not a number";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        inputManager.setScanner(scanner);

        List<Double> numbers = inputManager.getNumbersFromUser();
        assertTrue(numbers.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyInput() {
        String input = "";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        inputManager.setScanner(scanner);

        List<Double> numbers = inputManager.getNumbersFromUser();
    }

    @Test
    public void testCalculateAverageEmptyList() {
        List<Double> numbers = new ArrayList<>();
        assertThrows(NoSuchElementException.class, () -> listManager.calculateAverage(numbers));
    }
}