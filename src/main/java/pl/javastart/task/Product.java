package pl.javastart.task;

import java.math.BigDecimal;

public class Product {
    private String item;
    private BigDecimal price;
    private String currency;

    public Product(String item, BigDecimal price, String currency) {
        this.item = item;
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return item + ";" + price + ";" + currency;
    }
}
