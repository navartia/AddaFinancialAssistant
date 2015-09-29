package com.navartia.adda.util;

import java.util.Date;

public abstract class RecordItem extends Item {
    private Date timestamp;
    private Money amount;

    public RecordItem() {
        super();
        timestamp = null;
        amount = new Money(0);
    }

    public RecordItem(int id, String name, Money amount, Date timestamp) {
        super(id, name);
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
