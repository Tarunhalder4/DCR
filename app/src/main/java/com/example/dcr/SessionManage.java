package com.example.dcr;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManage {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSessionPref";
    public static final String TOTAL_RACK_WEIGHT = "total_rack_weight";


    private static SessionManage ourInstance = null;

    public static SessionManage getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new SessionManage(context);
        }
        return ourInstance;
    }

    // Constructor
    private SessionManage(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveTotalRackWeight(Float total_rack_Weight){

    }



}
