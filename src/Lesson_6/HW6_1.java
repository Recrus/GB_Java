package Lesson_6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW6_1 {
    public static class Notebook {
        private String brand;
        private String model;
        private int ramSize;
        private String color;
        private double price;

        public Notebook(String brand, String model, int ramSize, String color, double price) {
            this.brand = brand;
            this.model = model;
            this.ramSize = ramSize;
            this.color = color;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getRamSize() {
            return ramSize;
        }

        public void setRamSize(int ramSize) {
            this.ramSize = ramSize;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();

        notebooks.add(new Notebook("Lenovo", "ThinkPad", 16, "Black", 1999.99));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 8, "Space Gray", 2399.99));
        notebooks.add(new Notebook("Dell", "18268", 16, "Silver", 1799.99));
        notebooks.add(new Notebook("HP", "172921", 8, "Rose Gold", 1499.99));

        int minRamSize = getUserInputRamSize();
        String color = getUserInputColor();

        List<Notebook> filteredNotebooks = filterNotebooksByRamSizeAndColor(notebooks, minRamSize, color);
        for (Notebook notebook : filteredNotebooks) {
            System.out.println("Brand: " + notebook.getBrand());
            System.out.println("Model: " + notebook.getModel());
            System.out.println("RAM Size: " + notebook.getRamSize() + " GB");
            System.out.println("Color: " + notebook.getColor());
            System.out.println("Price: $" + notebook.getPrice());
            System.out.println();
        }

        scanner.close();
    }

    private static int getUserInputRamSize() {
        System.out.print("Введите минимальный размер оперативной памяти (в ГБ): ");
        int ramSize = scanner.nextInt();
        scanner.nextLine();

        return ramSize;
    }

    private static String getUserInputColor() {
        System.out.print("Введите цвет: ");

        return scanner.nextLine();
    }

    private static List<Notebook> filterNotebooksByRamSizeAndColor(List<Notebook> notebooks, int minRamSize, String color) {
        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            if (notebook.getRamSize() >= minRamSize && notebook.getColor().equalsIgnoreCase(color)) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
