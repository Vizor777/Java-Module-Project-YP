

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        boolean result = false;
        while (!result) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            int quantity = scanner.nextInt();
            if (quantity == 1 || quantity < 1) {
                result = false;
                System.out.println("Неверное количество человек");

            } else result = true;
        count = quantity;

        }
        if (count > 1) {
            Calc calc = new Calc();

            while (true) {
                System.out.println("Введите название товара");
                String name = scanner.next();
                System.out.println("Введите стоимость товара");
                double price = scanner.nextDouble();
                Product product = new Product(name, price);
                calc.addProduct(product);
                System.out.println("Добавить еще один товар?");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Завершить")) {
                    calc.getProductList();
                    break;
                } else if (!answer.equalsIgnoreCase("Завершить")) {

                }

            }
        }





    }

    static class Calc {
        double sum = 0;
        int visitors = 0;
        ArrayList<Product> products = new ArrayList<>();

        private void addVisitors(int a) {
            this.visitors = this.visitors + a;
        }
        private void addProduct(Product product) {
            products.add(product);
            this.sum = product.price;
            System.out.println("Товар успешно добавлен");
        }
        private void getProductList() {
            System.out.println(products);
        }

    }

    static class Product {
        String name;
        double price;
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
}