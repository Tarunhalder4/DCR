package com.example.dcr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="pet.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + Constant.TABLE_NAME + " ("
                + Constant._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                + Constant.RACK1 + " TEXT  , "
                + Constant.RACK2 + " TEXT , "
                + Constant.RACK3 + " TEXT , "
                + Constant.RACK4 + " TEXT , "
                + Constant.RACK5 + " TEXT , "
                + Constant.RACK6 + " TEXT , "

                + Constant.Total_COAL_RECEIVED + " TEXT,"
                + Constant.TOTAL_COAL_CONCEPTION_MT + " TEXT , "
                + Constant.OPENING_STOCK_MT + " TEXT , "
                + Constant.TOTAL_MT + " TEXT,"
                + Constant.CLOSING_STOCK + " TEXT,"
                + Constant.STOCK_RECLAIMED + " TEXT,"

                + Constant.MONTHLY_CONCEPTION + " TEXT , "
                + Constant.YEARLY_CONCEPTION + " TEXT , "
                + Constant.MONTHLY_RECEIVED + " TEXT , "
                + Constant.YEARLY_RECEIVED + " TEXT,"

                + Constant.TOTAL_MONTHLY_CONCEPTION + " TEXT,"
                + Constant.TOTAL_YEARLY_CONCEPTION + " TEXT,"
                + Constant.TOTAL_MONTHLY_RECEIVED + " TEXT,"
                + Constant.TOTAL_YEARLY_RECEIVED + " TEXT);";
        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
