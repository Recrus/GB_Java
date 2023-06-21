package Lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Введите список целых чисел (через пробел): ");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное число.");
                return;
            }
        }

        int option;
        do {
            System.out.println();
            System.out.println("Выберите функцию:");
            System.out.println("1 - Найти максимальное значение");
            System.out.println("2 - Найти минимальное значение");
            System.out.println("3 - Найти среднее значение");
            System.out.println("4 - Удалить четные числа");
            System.out.println("0 - Завершить программу");
            System.out.print("Ваш выбор: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (numbers.isEmpty()) {
                        System.out.println("Список чисел пуст.");
                    } else {
                        int max = findMax(numbers);
                        System.out.println("Максимальное значение: " + max);
                    }
                    break;
                case 2:
                    if (numbers.isEmpty()) {
                        System.out.println("Список чисел пуст.");
                    } else {
                        int min = findMin(numbers);
                        System.out.println("Минимальное значение: " + min);
                    }
                    break;
                case 3:
                    if (numbers.isEmpty()) {
                        System.out.println("Список чисел пуст.");
                    } else {
                        double average = findAverage(numbers);
                        System.out.println("Среднее значение: " + average);
                    }
                    break;
                case 4:
                    if (numbers.isEmpty()) {
                        System.out.println("Список чисел пуст.");
                    } else {
                        List<Integer> oddNumbers = removeEvenNumbers(numbers);
                        System.out.println("Список без четных чисел: " + oddNumbers);
                    }
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Ошибка: выбрана некорректная функция.");
            }
        } while (option != 0);
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static int findMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    public static double findAverage(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public static List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }
}
