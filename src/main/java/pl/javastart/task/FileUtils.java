package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FileUtils {

    static BigDecimal sumProductsInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : products) {
            for (Currency currency : currencies) {
                if (product.getCurrency().equals(currency.getCurrency())) {
                    BigDecimal valueInEuro = product.getPrice().divide(currency.getValue(), RoundingMode.UP);
                    sum = sum.add(valueInEuro);
                }
            }
        }
        return sum;
    }

    static BigDecimal avgPriceForAllProducts(BigDecimal allProductPricesInEuro, List<Product> products) {
        BigDecimal numberOfProducts = new BigDecimal(products.size());
        return allProductPricesInEuro.divide(numberOfProducts, RoundingMode.CEILING);
    }

    static BigDecimal mostExpensiveProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal highestValueInEuro = BigDecimal.valueOf(0);
        for (Product product : products) {
            for (Currency currency : currencies) {
                BigDecimal priceOfProductInEuro = product.getPrice().divide(currency.getValue(), RoundingMode.CEILING);
                if (currency.getCurrency().equals(product.getCurrency()) && priceOfProductInEuro.compareTo(highestValueInEuro) > 0) {
                    highestValueInEuro = priceOfProductInEuro;
                }
            }
        }
        return highestValueInEuro;
    }

    static BigDecimal mostCheapestProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal lowestPriceInEuro = products.get(0).getPrice().divide(currencies.get(100).getValue(), RoundingMode.CEILING);
        for (Product product : products) {
            for (Currency currency : currencies) {
                BigDecimal priceOfProductInEuro = product.getPrice().divide(currency.getValue(), RoundingMode.CEILING);
                if (currency.getCurrency().equals(product.getCurrency()) && priceOfProductInEuro.compareTo(lowestPriceInEuro) < 0) {
                    lowestPriceInEuro = priceOfProductInEuro;
                }
            }
        }
        return lowestPriceInEuro;
    }
}
