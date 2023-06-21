package Lesson_2;

import java.io.FileWriter;
import java.io.IOException;

public class HW2_2 {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9};
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        try {
            FileWriter logFileWriter = new FileWriter("bubble_sort.log");
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
                writeArrayToLog(logFileWriter, array);
            }
            logFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayToLog(FileWriter logFileWriter, int[] array) throws IOException {
        StringBuilder logEntry = new StringBuilder();
        for (int num : array) {
            logEntry.append(num).append(" ");
        }
        logFileWriter.write(logEntry.toString().trim() + "\n");
    }
}
