import java.util.ArrayList;
import java.util.Locale;
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
                String checkPrice = null;
                boolean status = true;

                while (status) {
                    System.out.println("Введите стоимость товара");
                    checkPrice = scanner.next();
                    char[] charArray = checkPrice.toCharArray();
                    if (charArray[0] == ',' || charArray[0] == '.') {
                        System.out.println("Неверное значение стоимости товара, повторите ввод.");
                    } else {
                        for (int i = 1; i < charArray.length; i++) {
                            if(!Character.isDigit(charArray[i]) && charArray[i] != ',' && charArray[i] != '.') {
                                System.out.println("Неверное значение стоимости товара, повторите ввод.");
                            } else {
                                status = false;
                            }
                        }
                        for (int a = 0; a < charArray.length; a++) {
                            if (charArray[a] == ',') {
                                charArray[a] = '.';
                                checkPrice = new String(charArray);
                            }
                        }
                    }
                }

                double price = Double.parseDouble(checkPrice);
                Product product = new Product(name, price);
                calc.addProduct(product);
                System.out.println("Добавить еще один товар?");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Завершить")) {
                    calc.getProductList();
                    calc.getTax();
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
        System.out.println("Добавлены товары: ");
            for (Product product: products
                 ) {
                System.out.println( product.name);
            }
        }
        private void getTax() {
            double finalSum = 0;
            for (Product product : products) {
                finalSum = finalSum + product.price;
            }
            finalSum = finalSum / products.size();

            String messageTemplate = "Каждый должен заплатить по: %.2f %s";
            System.out.println(String.format(Locale.ROOT, messageTemplate, finalSum, getWord(finalSum)));
        }
         private String getWord(double pay) {
             double strNumber = Math.floor(pay);
            if (strNumber == 1) {
                return "рубль";
            } else if (strNumber > 1 && strNumber < 5) {
                return "рубля";
            } else if (strNumber > 4) {
                return "рублей";
            }
             return null;
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