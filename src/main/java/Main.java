import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int quantityFinal = 0;

        boolean result = false;
        while (!result) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            String quantity = scanner.nextLine();
//            char[] charArray = quantity.toCharArray();
            boolean isInteger = quantity.matches("-?\\d+");
            if (isInteger) {
                quantityFinal = Integer.parseInt(quantity);
                if (quantityFinal == 1 || quantityFinal < 1) {
                    System.out.println("Неверное количество человек");

                } else {
                    count = quantityFinal;
                    result = true;

                }

            } else System.out.println("Неверное количество человек");





        }
        if (count > 1) {
            Calc calc = new Calc();

            while (true) {
                System.out.println("Введите название товара");
                String name = scanner.next();
                String checkPrice = null;
                boolean status = true;
                boolean onlyDigits = false;

                while (status) {
                    System.out.println("Введите стоимость товара");
                    checkPrice = scanner.next();
                    onlyDigits = checkPrice.matches("^[0-9]*[.,]?[0-9]+$");
                    char[] charArray = checkPrice.toCharArray();
                    if (charArray[0] == ',' || charArray[0] == '.') {
                        System.out.println("Неверное значение стоимости товара, повторите ввод.");
                    } else if (onlyDigits) {
                        for (int a = 0; a < charArray.length; a++) {
                            if (charArray[a] == ',') {
                                charArray[a] = '.';
                                checkPrice = new String(charArray);
                            }
                        }
                        status = false;
                    } else {System.out.println("Неверное значение стоимости товара, повторите ввод.");}
//                    if (onlyDigits) {
//                        for (int a = 0; a < charArray.length; a++) {
//                            if (charArray[a] == ',') {
//                                charArray[a] = '.';
//                                checkPrice = new String(charArray);
//                            }
//                        }
//                        status = false;
//                    } else {System.out.println("Неверное значение стоимости товара, повторите ввод.");}
                }
//                while (status) {
////                    System.out.println("Введите стоимость товара");
////                    checkPrice = scanner.next();
////                    char[] charArray = checkPrice.toCharArray();
////                    if (charArray[0] == ',' || charArray[0] == '.') {
////                        System.out.println("Неверное значение стоимости товара, повторите ввод.");
////                    } else {
////                        for (int i = 1; i < charArray.length; i++) {
////                            if (!Character.isDigit(charArray[i]) && charArray[i] != ',' && charArray[i] != '.') {
////                                System.out.println("Неверное значение стоимости товара, повторите ввод.");
////                            } else {
////                                status = false;
////                            }
////                        }
////                        for (int a = 0; a < charArray.length; a++) {
////                            if (charArray[a] == ',') {
////                                charArray[a] = '.';
////                                checkPrice = new String(charArray);
////                            }
////                        }
////                    }
//
//                }
                if (onlyDigits) {
                    double price = Double.parseDouble(checkPrice);
                    Product product = new Product(name, price);
                    calc.addProduct(product);
                    System.out.println("Добавить еще один товар?");
                    String answer = scanner.next();
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






}