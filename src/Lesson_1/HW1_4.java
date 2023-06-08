package Lesson_1;

import java.util.Scanner;

public class HW1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int length = scanner.nextInt();

        int[] arr = new int[length];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < length; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        scanner.close();

        n = n % arr.length;
        if (n < 0) {
            n = arr.length + n;
        }

        for (int i = 0; i < n; i++) {
            int last = arr[arr.length - 1];

            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[0] = last;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
