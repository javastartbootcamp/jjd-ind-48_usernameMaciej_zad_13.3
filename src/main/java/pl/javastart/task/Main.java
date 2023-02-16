package pl.javastart.task;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Product> products = DataReader.readProduct("products.csv");
            List<Currency> currencies = DataReader.readCurrency("currencies.csv");
            System.out.println(products);
            System.out.println(currencies);
            BigDecimal allProductPricesInEuro = FileUtils.sumProductsInEuro(products, currencies);
            System.out.println("sumy wszystkich produktów w EUR: " + allProductPricesInEuro);
            BigDecimal avgPriceForAllProducts = FileUtils.avgPriceForAllProducts(allProductPricesInEuro, products);
            System.out.println("średniej wartości produktu w EUR: " + avgPriceForAllProducts);
            BigDecimal mostExpensiveProduct = FileUtils.mostExpensiveProductInEuro(products, currencies);
            System.out.println("najdroższego produktu w przeliczeniu na EUR: " + mostExpensiveProduct);
            BigDecimal cheapestProduct = FileUtils.mostCheapestProductInEuro(products, currencies);
            System.out.println("najtańszego produktu w przeliczeniu na EUR: " + cheapestProduct);
        } catch (FileNotFoundException e) {
            System.err.println("Nie udalo sie wczytac pliku.");
        }
    }
}
