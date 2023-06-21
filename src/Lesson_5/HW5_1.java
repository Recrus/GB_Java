package Lesson_5;

import java.util.*;

public class HW5_1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneDirectory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            if (command.length == 0) {
                continue;
            }

            switch (command[0]) {
                case "ADD":
                    if (command.length >= 3) {
                        String lastName = command[1];
                        String phoneNumber = input.substring(input.indexOf(' ', input.indexOf(' ') + 1) + 1);
                        addPhoneNumber(phoneDirectory, lastName, phoneNumber);
                    } else {
                        System.out.println("Ошибка: некорректное количество аргументов для команды ADD.");
                    }
                    break;
                case "GET":
                    if (command.length == 2) {
                        getPhoneNumbers(phoneDirectory, command[1]);
                    } else {
                        System.out.println("Ошибка: некорректное количество аргументов для команды GET.");
                    }
                    break;
                case "REMOVE":
                    if (command.length == 2) {
                        removePhoneNumbers(phoneDirectory, command[1]);
                    } else {
                        System.out.println("Ошибка: некорректное количество аргументов для команды REMOVE.");
                    }
                    break;
                case "LIST":
                    listPhoneDirectory(phoneDirectory);
                    break;
                case "EXIT":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Ошибка: неизвестная команда.");
            }
        }
    }

    private static void addPhoneNumber(Map<String, List<String>> phoneDirectory, String lastName, String phoneNumber) {
        List<String> numbers = phoneDirectory.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneDirectory.put(lastName, numbers);
    }

    private static void getPhoneNumbers(Map<String, List<String>> phoneDirectory, String lastName) {
        List<String> numbers = phoneDirectory.get(lastName);
        if (numbers != null) {
            System.out.println(numbers);
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    private static void removePhoneNumbers(Map<String, List<String>> phoneDirectory, String lastName) {
        List<String> numbers = phoneDirectory.remove(lastName);
        if (numbers != null) {
            System.out.println("Удалены все номера по фамилии \"" + lastName + "\"");
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    private static void listPhoneDirectory(Map<String, List<String>> phoneDirectory) {
        for (Map.Entry<String, List<String>> entry : phoneDirectory.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

