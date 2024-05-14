import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityFinal = 0;
        boolean result = false;
        while (!result) {
            System.out.println("На скольких человек необходимо разделить счёт?\n");
            String quantity = scanner.nextLine();
            quantity = quantity.trim();
            boolean isInteger = quantity.matches("-?\\d+");
            if (isInteger) {
                quantityFinal = Integer.parseInt(quantity);
                if (quantityFinal == 1 || quantityFinal < 1) {
                    System.out.println("Неверное количество человек.\n");
                } else {
                    result = true;
                }
            } else System.out.println("Неверное количество человек, повторите ввод.\n");
        }

        Calc calc = new Calc();

        while (true) {
            String name = null;
            boolean chekName = false;
            while (!chekName) {
                System.out.println("Введите название товара.\n");
                name = scanner.nextLine();
                name = name.trim();
                if (name.trim().isEmpty() || name.isBlank()) {
                    System.out.println("Неверное наименование товара, повторите ввод.\n");
                } else chekName = true;
            }
            String checkPrice = null;
            boolean status = true;
            boolean onlyDigits = false;
            while (status) {
                System.out.println("Введите стоимость товара.\n");
                checkPrice = scanner.nextLine();
                checkPrice = checkPrice.trim();
                onlyDigits = checkPrice.matches("^[0-9]*[.,]?[0-9]+$");
                char[] charArray = checkPrice.toCharArray();
                if (!checkPrice.isEmpty()) {
                    if (charArray[0] == ',' || charArray[0] == '.') {
                        System.out.println("Неверное значение стоимости товара, повторите ввод.\n");
                    } else if (onlyDigits) {
                        for (int a = 0; a < charArray.length; a++) {
                            if (charArray[a] == ',') {
                                charArray[a] = '.';
                                checkPrice = new String(charArray);
                            }
                        }
                        status = false;
                    } else {
                        System.out.println("Неверное значение стоимости товара, повторите ввод.\n");
                    }
                } else {
                    System.out.println("Неверное значение стоимости товара, повторите ввод.\n");
                }

            }
            if (onlyDigits) {
                double price = Double.parseDouble(checkPrice);
                Product product = new Product(name, price);
                calc.addProduct(product);
                System.out.println("Добавить еще один товар?\n");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("Завершить")) {
                    calc.getProductList();
                    calc.getTax(quantityFinal);
                    break;
                } else if (!answer.equalsIgnoreCase("Завершить")) {

                }
            }
        }


    }


}