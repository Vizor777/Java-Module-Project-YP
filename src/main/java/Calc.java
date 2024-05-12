import java.util.ArrayList;
import java.util.Locale;

public class Calc {
    double sum = 0;
    int visitors = 0;
    ArrayList<Product> products = new ArrayList<>();

    private void addVisitors(int a) {
        this.visitors = this.visitors + a;
    }

    public void addProduct(Product product) {
        products.add(product);
        this.sum = product.price;
        System.out.println("Товар успешно добавлен");
    }

    public void getProductList() {
        System.out.println("Добавлены товары: ");
        for (Product product : products
        ) {
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

        String messageTemplate = "Каждый должен заплатить по: %.2f %s";
        System.out.println(String.format(Locale.ROOT, messageTemplate, finalSum, getWord(finalSum)));
    }

    private String getWord(double pay) {
        Double strNumber = Math.floor(pay);
        Integer integerNumber = strNumber.intValue();
        String checkNumber = String.valueOf(integerNumber);

        char [] arrChar = checkNumber.toCharArray();
        int num = Character.getNumericValue(arrChar[arrChar.length - 1]);
        if (num == 1) {
            return "рубль";
        } else if (num > 1 && num < 5) {
            return "рубля";
        } else if (num > 4 && num <= 0) {
            return "рублей";
        }
        return null;
    }
}