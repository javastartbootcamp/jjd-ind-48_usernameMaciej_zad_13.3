package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {

    private static final String FILE_PATH_TO_PRODUCTS = "src/main/resources/products.csv";
    private static final String FILE_PATH_TO_CURRENCIES = "src/main/resources/currencies.csv";

    static List<Product> readProduct(String fileName) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_PRODUCTS));
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(";");
            products.add(new Product(split[0], new BigDecimal(split[1]), split[2]));
        }
        return products;
    }

    static List<Currency> readCurrency(String fileName) throws FileNotFoundException {
        List<Currency> currencies = new ArrayList<>();
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_CURRENCIES));
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(";");
            currencies.add(new Currency(split[0], new BigDecimal(split[1])));
        }
        return currencies;
    }
}
