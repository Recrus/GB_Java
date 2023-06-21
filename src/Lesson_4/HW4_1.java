package Lesson_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW4_1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("print")) {
                printStrings(stringList);
            } else if (input.equalsIgnoreCase("revert")) {
                revertLastString(stringList);
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                stringList.add(input);
            }
        }
    }

    private static void printStrings(List<String> stringList) {
        System.out.print("< ");
        for (int i = stringList.size() - 1; i >= 0; i--) {
            System.out.print(stringList.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void revertLastString(List<String> stringList) {
        if (stringList.isEmpty()) {
            System.out.println("Ошибка: память пуста.");
        } else {
            stringList.remove(stringList.size() - 1);
        }
    }
}

