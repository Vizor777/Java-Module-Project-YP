import java.util.ArrayList;
import java.util.Locale;

public class Calc {
    double sum = 0;
    int visitors = 0;
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        this.sum = product.price;
        System.out.println("Товар успешно добавлен.\n");
    }

    public void getProductList() {
        System.out.println("Добавлены товары: ");
        for (Product product : products) {
            System.out.println(product.name);
        }
    }

    public void getTax(int quantityFinal) {
        double count = 0;
        double finalSum = 0;
        for (Product product : products) {
            count = count + product.price;
        }
        finalSum = count / quantityFinal;
        String messageTemplate = "Сумма для каждого: %.2f %s";
        System.out.printf(Locale.ROOT, (messageTemplate) + "%n", finalSum, getWord(finalSum));
    }

    private String getWord(double money) {
        Double strNumber = Math.floor(money);
        Integer integerNumber = strNumber.intValue();
        int x = integerNumber % 10;
        if (integerNumber % 100 >= 11 && integerNumber % 100 <= 14) {
            return "рублей";
        } else {
            switch (x) {
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
        }
    }
}