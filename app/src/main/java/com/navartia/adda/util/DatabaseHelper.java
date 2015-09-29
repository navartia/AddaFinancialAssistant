package com.navartia.adda.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "adda";
    // Table Name
    private static final String TABLE_budget = "Budget";
    private static final String TABLE_accounts = "Accounts";      //???
    private static final String TABLE_budgetItem = "Budget Item";
    private static final String TABLE_balanceSheet = "Balance Sheet";

    //Columns
    private static String [] Columns_budget = new String[5];
    private static String [] Columns_accounts = new String[2];
    private static String [] Columns_budgetItem = new String[2];
    private static String [] Columns_balanceSheet = new String[5];

    //Adding columns' connection string.
    private String connString = "";

    public DatabaseHelper(Context context, String dbType)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Creating tables.
        db.execSQL("CREATE TABLE " + TABLE_budget + TB_BudgetConnectionString);        //Budget table.
        db.execSQL("CREATE TABLE " + TABLE_accounts + connString);      //Accounts table.
        db.execSQL("CREATE TABLE " + TABLE_budgetItem + connString);    //Budget Item table.
        db.execSQL("CREATE TABLE " + TABLE_balanceSheet + connString);  //Balance Sheet table.

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Something traditional.
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    //The name says it all.
    private String TB_BudgetConnectionString ()
    {
        String conString;
        //Assigning values to columns.

        Columns_budget[0] = "budget_id";
        Columns_budget[1] = "account_id";
        Columns_budget[2] = "budget_item_id";
        Columns_budget[3] = "budget_item_amount";
        Columns_budget[4] = "balance_timestamp";

        //Assigning an appropriate type for a particular table and uniting all these to construct the connection string.
        conString = "(" + Columns_budget[0] + " INTEGER PRIMARY KEY AUTOINCREMENT," + Columns_budget[1] + "INTEGER," + Columns_budget[2] + "INTEGER," + Columns_budget[3] + "INTEGER," + Columns_budget[4] + "TEXT)";

        return conString;
    }
}
