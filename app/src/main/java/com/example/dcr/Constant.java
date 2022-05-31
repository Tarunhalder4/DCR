package com.example.dcr;

import android.provider.BaseColumns;

public class Constant implements BaseColumns {

    public Constant() {
    }

    public final static String TABLE_NAME = "coal";

    public final static String _ID = BaseColumns._ID;

    public final static String RACK1 = "rack1";
    public final static String RACK2 = "rack2";
    public final static String RACK3 = "rack3";
    public final static String RACK4 = "rack4";
    public final static String RACK5 = "rack5";
    public final static String RACK6 = "rack6";

    public final static String Date = "date";

    public final static String TOTAL_COAL_CONCEPTION_MT = "total_coal_conception";
    public final static String OPENING_STOCK_MT = "opening_stock";

    public final static String MONTHLY_CONCEPTION = "monthly_conception";
    public final static String YEARLY_CONCEPTION = "yearly_conception";

    public final static String MONTHLY_RECEIVED = "monthly_received";
    public final static String YEARLY_RECEIVED = "yearly_received";

    public final static String Total_COAL_RECEIVED = "total_coal_received";
    public final static String TOTAL_MT = "total_mt";
    public final static String CLOSING_STOCK = "closing_stock";
    public final static String STOCK_RECLAIMED = "stock_reclaimed";
    public final static String TOTAL_MONTHLY_CONCEPTION = "total_monthly_conception";
    public final static String TOTAL_YEARLY_CONCEPTION = "total_yearly_conception";
    public final static String TOTAL_MONTHLY_RECEIVED = "total_monthly_received";
    public final static String TOTAL_YEARLY_RECEIVED = "total_yearly_received";

}
