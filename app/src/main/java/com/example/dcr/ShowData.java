package com.example.dcr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dcr.databinding.ActivityShowDataBinding;

public class ShowData extends AppCompatActivity {

    ActivityShowDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String rack1 = getIntent().getStringExtra(Constant.RACK1);
        String rack2 = getIntent().getStringExtra(Constant.RACK2);
        String rack3 = getIntent().getStringExtra(Constant.RACK3);
        String rack4 = getIntent().getStringExtra(Constant.RACK4);
        String rack5 = getIntent().getStringExtra(Constant.RACK5);
        String rack6 = getIntent().getStringExtra(Constant.RACK6);

        String totalCoalReceived = getIntent().getStringExtra(Constant.Total_COAL_RECEIVED);
        String totalCoalConception = getIntent().getStringExtra(Constant.TOTAL_COAL_CONCEPTION_MT);
        String openingStock = getIntent().getStringExtra(Constant.OPENING_STOCK_MT);
        String totalMT = getIntent().getStringExtra(Constant.TOTAL_MT);
        String closingStock = getIntent().getStringExtra(Constant.CLOSING_STOCK);
        String stockReclaimed = getIntent().getStringExtra(Constant.STOCK_RECLAIMED);

        String monthlyConception = getIntent().getStringExtra(Constant.MONTHLY_CONCEPTION);
        String yearlyConception = getIntent().getStringExtra(Constant.YEARLY_CONCEPTION);
        String monthlyReceived = getIntent().getStringExtra(Constant.MONTHLY_RECEIVED);
        String yearlyReceived = getIntent().getStringExtra(Constant.YEARLY_RECEIVED);

        String totalMonthlyConception = getIntent().getStringExtra(Constant.TOTAL_MONTHLY_CONCEPTION);
        String totalYearlyConception = getIntent().getStringExtra(Constant.TOTAL_YEARLY_CONCEPTION);
        String totalMonthlyReceived = getIntent().getStringExtra(Constant.TOTAL_MONTHLY_RECEIVED);
        String totalYearlyReceived = getIntent().getStringExtra(Constant.TOTAL_YEARLY_RECEIVED);

        binding.rack1EditText.setText(rack1);
        binding.rack2EditText.setText(rack2);
        binding.rack3EditText.setText(rack3);
        binding.rack4EditText.setText(rack4);
        binding.rack5EditText.setText(rack5);
        binding.rack6EditText.setText(rack6);

        binding.totalCoalReceived.setText(totalCoalReceived);
        binding.totalCoalConceptionEditView.setText(totalCoalConception);
        binding.openingStockEditView.setText(openingStock);
        binding.totalMtEditView.setText(totalMT);
        binding.closingStockEditView.setText(closingStock);
        binding.stockReclaimedEditView.setText(stockReclaimed);


        binding.monthlyConceptionEditView.setText(monthlyConception);
        binding.yearlyConceptionEditView.setText(yearlyConception);
        binding.monthlyReceivedEditView.setText(monthlyReceived);
        binding.yearlyReceivedEditView.setText(yearlyReceived);

        binding.monthlyAddTotalConceptionTextView.setText(totalMonthlyConception);
        binding.yearlyAddTotalConceptionTextView.setText(totalYearlyConception);
        binding.monthlyAddTotalReceivedTextView.setText(totalMonthlyReceived);
        binding.yearlyAddTotalReceivedTextView.setText(totalYearlyReceived);

        binding.addTotalConceptionTextView.setText(totalCoalConception);
        binding.addTotalYearlyConceptionTextView.setText(totalCoalConception);
        binding.addTotalReceivedTextView.setText(totalCoalReceived);
        binding.addTotalYearlyReceivedTextView.setText(totalCoalReceived);


    }
}