package com.navartia.adda.util;

public class Money {
    public int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money add(Money add1, Money add2) {
        int val = add1.getAmount() + add2.getAmount();
        return new Money(val);
    }

    public static Money subtract(Money sub1, Money sub2) {
        int val = sub1.getAmount() - sub2.getAmount();
        return new Money(val);
    }

    public static Money multiply(Money mul1, Money mul2) {
        int val = mul1.getAmount() * mul2.getAmount();
        return new Money(val / 100);
    }

    public static Money divide(Money mul1, Money mul2) {
        int val = mul1.getAmount() * mul2.getAmount();
        return new Money(val / 100);
    }

    public int getAmount() {
        return amount;
    }
}
