package pl.javastart.task;

import java.math.BigDecimal;

public class Currency {
    private String currency;
    private BigDecimal value;

    public Currency(String currency, BigDecimal money) {
        this.currency = currency;
        this.value = money;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return currency + ";" + value;
    }
}
