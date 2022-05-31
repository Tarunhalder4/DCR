package com.example.dcr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.dcr.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String TAG = "tag";
    Float rack1_weight=0.0f;
    Float rack2_weight=0.0f;
    Float rack3_weight=0.0f;
    Float rack4_weight=0.0f;
    Float rack5_weight=0.0f;
    Float rack6_weight=0.0f;
    Float totalCoalReceived=0.0f;
    Float totalCoalConception=0.0f;
    Float openingStock=0.0f;
    Float totalMT=0.0f;
    Float closingStock=0.0f;
    Float stock_reclaimed=0.0f;
    Float monthlyConception=0.0f;
    Float yearlyConception=0.0f;
    Float monthlyReceived=0.0f;
    Float yearlyReceived=0.0f;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        calendar = Calendar.getInstance();
        dbHelper = new DBHelper(MainActivity.this);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        binding.date.setText("Current Date: "+getCurrentDate());

        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.datePickerCardView.setVisibility(View.VISIBLE);
                binding.date.setText("Current Date: "+getCurrentDate());
                binding.datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        int month= monthOfYear+1;
                        binding.date.setText(dayOfMonth+"-"+month+"-"+year);
                        binding.datePickerCardView.setVisibility(View.GONE);
                    }
                });
            }
        });

        binding.rack1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack1EditText.getText().toString().trim().isEmpty()){
                    rack1_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.rack2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack2EditText.getText().toString().trim().isEmpty()){
                    rack2_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.rack3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack3EditText.getText().toString().trim().isEmpty()){
                    rack3_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.rack4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack4EditText.getText().toString().trim().isEmpty()){
                    rack4_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.rack5EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack5EditText.getText().toString().trim().isEmpty()){
                    rack5_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.rack6EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if (binding.rack6EditText.getText().toString().trim().isEmpty()){
                    rack6_weight=0.0f;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                totalCoalReceived = rack1_weight+rack2_weight+rack3_weight+rack4_weight+rack5_weight+rack6_weight;
                if(totalCoalReceived!=0){
                    binding.totalCoalReceived.setText(String.valueOf(totalCoalReceived));
                }else {
                    binding.totalCoalReceived.setText("");
                }
                checkRackEmpty();
            }
        });

        binding.totalCoalConceptionEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                binding.totalMtEditView.setText("0");
                totalMT = totalCoalConception+openingStock;

                if(totalMT!=0){
                    binding.totalMtEditView.setText(String.valueOf(totalMT));
                }else {
                    binding.totalMtEditView.setText("");
                }

                totalMT = totalCoalReceived+openingStock;
                closingStock=totalMT-totalCoalConception;
                stock_reclaimed=totalCoalReceived-totalCoalConception;

                binding.addTotalConceptionTextView.setText(String.valueOf(totalCoalConception));
                binding.addTotalYearlyConceptionTextView.setText(String.valueOf(totalCoalConception));
                binding.addTotalReceivedTextView.setText(String.valueOf(totalCoalReceived));
                binding.addTotalYearlyReceivedTextView.setText(String.valueOf(totalCoalReceived));

                if(totalMT!=0){
                    binding.totalMtEditView.setText(String.valueOf(totalMT));
                }else {
                    binding.totalMtEditView.setText("");
                }

                if(closingStock!=0.0){
                    binding.closingStockEditView.setText(String.valueOf(closingStock));
                }else {
                    binding.closingStockEditView.setText("");
                }

                if (stock_reclaimed!=0.0){
                    binding.stockReclaimedEditView.setText(String.valueOf(stock_reclaimed));
                }else {
                    binding.stockReclaimedEditView.setText("");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
            }
        });

        binding.openingStockEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.openingStockEditView.getText().toString().trim().isEmpty()){
                    openingStock=0.0f;
                }
                validation();
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
                binding.totalMtEditView.setText("0");
                totalMT = totalCoalConception+openingStock;
                if(totalMT!=0){
                    binding.totalMtEditView.setText(String.valueOf(totalMT));
                }else {
                    binding.totalMtEditView.setText("");
                }

                totalMT = totalCoalReceived+openingStock;
                closingStock=totalMT-totalCoalConception;
                stock_reclaimed=totalCoalReceived-totalCoalConception;

                binding.addTotalConceptionTextView.setText(String.valueOf(totalCoalConception));
                binding.addTotalYearlyConceptionTextView.setText(String.valueOf(totalCoalConception));
                binding.addTotalReceivedTextView.setText(String.valueOf(totalCoalReceived));
                binding.addTotalYearlyReceivedTextView.setText(String.valueOf(totalCoalReceived));

                if(totalMT!=0){
                    binding.totalMtEditView.setText(String.valueOf(totalMT));
                }else {
                    binding.totalMtEditView.setText("");
                }

                if(closingStock!=0.0){
                    binding.closingStockEditView.setText(String.valueOf(closingStock));
                }else {
                    binding.closingStockEditView.setText("");
                }

                if (stock_reclaimed!=0.0){
                    binding.stockReclaimedEditView.setText(String.valueOf(stock_reclaimed));
                }else {
                    binding.stockReclaimedEditView.setText("");
                }

            }
        });

        binding.monthlyConceptionEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if(!binding.monthlyConceptionEditView.getText().toString().trim().isEmpty()){
                    Log.d(TAG, "onTextChanged: "+binding.monthlyConceptionEditView.getText().toString().trim());
                    monthlyConception=Float.parseFloat(binding.monthlyConceptionEditView.getText().toString().trim());
                }else {
                    monthlyConception=0.0f;
                }
                binding.monthlyAddTotalConceptionTextView.setText(String.valueOf(monthlyConception+totalCoalConception));
            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
            }
        });

        binding.yearlyConceptionEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if(!binding.yearlyConceptionEditView.getText().toString().trim().isEmpty()){
                    yearlyConception=Float.parseFloat(binding.yearlyConceptionEditView.getText().toString().trim());
                }else {
                    yearlyConception =0.0f;
                }
                binding.yearlyAddTotalConceptionTextView.setText(String.valueOf(yearlyConception+totalCoalConception));

            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
            }
        });

        binding.monthlyReceivedEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if(!binding.monthlyReceivedEditView.getText().toString().trim().isEmpty()){
                    monthlyReceived=Float.parseFloat(binding.monthlyReceivedEditView.getText().toString().trim());
                }else{
                    monthlyReceived = 0.0f;
                }
                binding.monthlyAddTotalReceivedTextView.setText(String.valueOf(monthlyReceived+totalCoalReceived));

            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
            }
        });

        binding.yearlyReceivedEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validation();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validation();
                if(!binding.yearlyReceivedEditView.getText().toString().trim().isEmpty()){
                    yearlyReceived=Float.parseFloat(binding.yearlyReceivedEditView.getText().toString().trim());
                }else {
                    yearlyReceived =0.0f;
                }
                binding.yearlyAddTotalReceivedTextView.setText(String.valueOf(yearlyReceived+totalCoalReceived));

            }

            @Override
            public void afterTextChanged(Editable s) {
                validation();
            }
        });

    }

    private void checkRackEmpty(){
        if (binding.rack1EditText.getText().toString().trim().isEmpty()&&
                binding.rack2EditText.getText().toString().trim().isEmpty()&&
                binding.rack3EditText.getText().toString().trim().isEmpty()&&
                binding.rack4EditText.getText().toString().trim().isEmpty()&&
                binding.rack5EditText.getText().toString().trim().isEmpty()&&
                binding.rack6EditText.getText().toString().trim().isEmpty()){
            binding.totalCoalReceived.setText("00.0");
            totalCoalReceived=0.0f;
        }
    }

    void validation(){
       // Log.d(TAG, "validation: "+binding.rack1EditText.getText().toString().trim());
       if (!TextUtils.isEmpty(binding.rack1EditText.getText().toString().trim())) {
         //  Log.d(TAG, "validation: " + binding.rack1EditText.getText().toString().trim());
           rack1_weight = Float.parseFloat(binding.rack1EditText.getText().toString().trim());
       }else {
           rack1_weight = 0.0f;
       }

        if (!TextUtils.isEmpty(binding.rack2EditText.getText().toString().trim())) {
          //  Log.d(TAG, "validation: "+binding.rack2EditText.getText().toString().trim());
              rack2_weight = Float.parseFloat(binding.rack2EditText.getText().toString().trim());
        }else {
            rack2_weight = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.rack3EditText.getText().toString().trim())){
         //   Log.d(TAG, "validation: "+binding.rack3EditText.getText().toString().trim());
            rack3_weight = Float.parseFloat(binding.rack3EditText.getText().toString().trim());
        }else {
            rack3_weight = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.rack4EditText.getText().toString().trim())){
          //  Log.d(TAG, "validation: "+binding.rack4EditText.getText().toString().trim());
            rack4_weight = Float.parseFloat(binding.rack4EditText.getText().toString().trim());
        }else {
            rack4_weight = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.rack5EditText.getText().toString().trim())){
          //  Log.d(TAG, "validation: "+binding.rack5EditText.getText().toString().trim());
            rack5_weight = Float.parseFloat(binding.rack5EditText.getText().toString().trim());
        }else {
            rack5_weight = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.rack6EditText.getText().toString().trim())){
         //   Log.d(TAG, "validation: "+binding.rack6EditText.getText().toString().trim());
            rack6_weight = Float.parseFloat(binding.rack6EditText.getText().toString().trim());
        }else {
            rack6_weight = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.totalCoalConceptionEditView.getText().toString().trim())){
          //  Log.d(TAG, "validation: "+binding.totalCoalConceptionEditView.getText().toString().trim());
            totalCoalConception = Float.parseFloat(binding.totalCoalConceptionEditView.getText().toString().trim());
        }else {
            totalCoalConception = 0.0f;
        }

        if (!TextUtils.isEmpty(binding.openingStockEditView.getText().toString().trim())){
          //  Log.d(TAG, "validation: "+binding.openingStockEditView.getText().toString().trim());
            openingStock = Float.parseFloat(binding.openingStockEditView.getText().toString().trim());
        }else {
            openingStock = 0.0f;
        }

    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((binding.datePicker.getDayOfMonth())+"/");//month is 0 based
        builder.append(binding.datePicker.getMonth()+1+"/");
        builder.append(binding.datePicker.getYear());
        return builder.toString();
    }

    public void checkField(View view) {
        if (!binding.rack1EditText.getText().toString().trim().isEmpty()&&
                !binding.rack2EditText.getText().toString().trim().isEmpty()&&
                !binding.rack3EditText.getText().toString().trim().isEmpty()&&
                !binding.rack4EditText.getText().toString().trim().isEmpty()&&
                !binding.rack5EditText.getText().toString().trim().isEmpty()&&
                !binding.rack6EditText.getText().toString().trim().isEmpty()&&
                !binding.totalCoalConceptionEditView.getText().toString().trim().isEmpty()&&
                !binding.openingStockEditView.getText().toString().trim().isEmpty()&&
                !binding.monthlyConceptionEditView.getText().toString().trim().isEmpty()&&
                !binding.yearlyConceptionEditView.getText().toString().trim().isEmpty()&&
                !binding.monthlyReceivedEditView.getText().toString().trim().isEmpty()&&
                !binding.yearlyReceivedEditView.getText().toString().trim().isEmpty()){
            saveDataInDataBase();
        }else {
            Toast.makeText(MainActivity.this,"please entry all field",Toast.LENGTH_SHORT).show();
        }

    }

    void saveDataInDataBase(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constant.RACK1 , binding.rack1EditText.getText().toString().trim());
        values.put(Constant.RACK2 ,binding.rack2EditText.getText().toString().trim());
        values.put(Constant.RACK3 ,binding.rack3EditText.getText().toString().trim());
        values.put(Constant.RACK4, binding.rack4EditText.getText().toString().trim());
        values.put(Constant.RACK5, binding.rack5EditText.getText().toString().trim());
        values.put(Constant.RACK6, binding.rack6EditText.getText().toString().trim());

        values.put(Constant.TOTAL_COAL_CONCEPTION_MT, binding.totalCoalConceptionEditView.getText().toString().trim());
        values.put(Constant.OPENING_STOCK_MT, binding.openingStockEditView.getText().toString().trim());
        values.put(Constant.MONTHLY_CONCEPTION, binding.monthlyConceptionEditView.getText().toString().trim());
        values.put(Constant.YEARLY_CONCEPTION, binding.yearlyConceptionEditView.getText().toString().trim());
        values.put(Constant.MONTHLY_RECEIVED, binding.monthlyReceivedEditView.getText().toString().trim());
        values.put(Constant.YEARLY_RECEIVED, binding.yearlyReceivedEditView.getText().toString().trim());

        values.put(Constant.Total_COAL_RECEIVED, binding.totalCoalReceived.getText().toString().trim());
        values.put(Constant.TOTAL_MT, binding.totalMtEditView.getText().toString().trim());
        values.put(Constant.CLOSING_STOCK, binding.closingStockEditView.getText().toString().trim());
        values.put(Constant.STOCK_RECLAIMED, binding.stockReclaimedEditView.getText().toString().trim());

        values.put(Constant.TOTAL_MONTHLY_CONCEPTION, binding.monthlyAddTotalConceptionTextView.getText().toString().trim());
        values.put(Constant.TOTAL_YEARLY_CONCEPTION, binding.yearlyAddTotalConceptionTextView.getText().toString().trim());
        values.put(Constant.TOTAL_MONTHLY_RECEIVED, binding.monthlyAddTotalReceivedTextView.getText().toString().trim());
        values.put(Constant.TOTAL_YEARLY_RECEIVED, binding.yearlyAddTotalReceivedTextView.getText().toString().trim());

        long newRodId = db.insert(Constant.TABLE_NAME ,null , values);
        if (newRodId>=-1){
            Toast.makeText( MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
            binding.rack1EditText.setText("");
            binding.rack2EditText.setText("");
            binding.rack3EditText.setText("");
            binding.rack4EditText.setText("");
            binding.rack5EditText.setText("");
            binding.rack6EditText.setText("");
            binding.totalCoalConceptionEditView.setText("");
            binding.openingStockEditView.setText("");
            binding.monthlyConceptionEditView.setText("");
            binding.yearlyConceptionEditView.setText("");
            binding.monthlyReceivedEditView.setText("");
            binding.yearlyReceivedEditView.setText("");
        }
    }
}

