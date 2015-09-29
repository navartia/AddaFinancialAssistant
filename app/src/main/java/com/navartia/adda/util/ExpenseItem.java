package com.navartia.adda.util;

import java.util.Date;

public class ExpenseItem extends RecordItem {
    public ExpenseItem(int id, String name, Money amount, Date timestamp) {
        super(id, name, amount, timestamp);
    }
}
