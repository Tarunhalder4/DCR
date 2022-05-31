package com.example.dcr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dcr.databinding.ActivityShowAllDataBinding;

import java.util.ArrayList;

public class ShowAllDataActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;
    ActivityShowAllDataBinding binding;
    ArrayList<CoalModel>coalModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowAllDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DBHelper(this);
        coalModels = new ArrayList<>();
        recycleViewSetUp(ShowAllDataActivity.this);


        binding.floatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowAllDataActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        recycleViewSetUp(ShowAllDataActivity.this);
    }

    void recycleViewSetUp(Context context){
        coalModels=getAllData();
        CoalAdepter coalAdepter = new CoalAdepter(context,coalModels,ShowAllDataActivity.this);
        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.setAdapter(coalAdepter);
    }

    public ArrayList<CoalModel> getAllData() {

        db = dbHelper.getReadableDatabase();

        Cursor dataCursor = db.rawQuery("SELECT * FROM " + Constant.TABLE_NAME, null);

        ArrayList<CoalModel> coalModels = new ArrayList<>();

        if (dataCursor.moveToFirst()) {
            do {
                coalModels.add(new CoalModel(
                        dataCursor.getInt(0),
                        dataCursor.getString(1),
                        dataCursor.getString(2),
                        dataCursor.getString(3),
                        dataCursor.getString(4),
                        dataCursor.getString(5),
                        dataCursor.getString(6),
                        dataCursor.getString(7),
                        dataCursor.getString(8),
                        dataCursor.getString(9),
                        dataCursor.getString(10),
                        dataCursor.getString(11),
                        dataCursor.getString(12),
                        dataCursor.getString(13),
                        dataCursor.getString(14),
                        dataCursor.getString(15),
                        dataCursor.getString(16),
                        dataCursor.getString(17),
                        dataCursor.getString(18),
                        dataCursor.getString(19),
                        dataCursor.getString(20)));
            } while (dataCursor.moveToNext());

        }
        dataCursor.close();
        return coalModels;
    }
}