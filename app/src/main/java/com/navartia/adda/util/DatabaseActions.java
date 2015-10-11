package com.navartia.adda.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseActions extends DatabaseHelper
{
    SQLiteDatabase db = this.getWritableDatabase();


    public DatabaseActions(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public boolean insertDataToTABLE_BUDGET (int account_id, int budget_item_id, int budget_item_amount, String balance_timestamp)
    {
        ContentValues cv = new ContentValues();

        cv.put(Columns_budget[1], account_id);
        cv.put(Columns_budget[2], budget_item_id);
        cv.put(Columns_budget[3], budget_item_amount);
        cv.put(Columns_budget[4], balance_timestamp);

        //'insert' method returns the latest incremented primary key if the insertion was successful; it returns -1 otherwise.
        long result = db.insert(TABLE_budget, null, cv);

        //For confirmation if the insertion was successful.
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDataToTABLE_ACCOUNTS (String account_name)
    {
        ContentValues cv = new ContentValues();

        cv.put(Columns_accounts[1], account_name);

        //'insert' method returns the latest incremented primary key if the insertion was successful; it returns -1 otherwise.
        long result = db.insert(TABLE_accounts, null, cv);

        //For confirmation if the insertion was successful.
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataToTABLE_BUDGETITEM (String budget_item_name)
    {
        ContentValues cv = new ContentValues();

        cv.put(Columns_budgetItem[1], budget_item_name);

        //'insert' method returns the latest incremented primary key if the insertion was successful; it returns -1 otherwise.
        long result = db.insert(TABLE_budgetItem, null, cv);

        //For confirmation if the insertion was successful.
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataToTABLE_BALANCESHEET (int account_id, int category_id, int amount, String balance_timestamp, String remarks)
    {
        ContentValues cv = new ContentValues();

        cv.put(Columns_balanceSheet[1], account_id);
        cv.put(Columns_balanceSheet[2], category_id);
        cv.put(Columns_balanceSheet[3], amount);
        cv.put(Columns_balanceSheet[4], balance_timestamp);
        cv.put(Columns_balanceSheet[5], remarks);

        //'insert' method returns the latest incremented primary key if the insertion was successful; it returns -1 otherwise.
        long result = db.insert(TABLE_balanceSheet, null, cv);

        //For confirmation if the insertion was successful.
        if(result == -1)
            return false;
        else
            return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
