package com.example.dcr;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoalAdepter extends RecyclerView.Adapter<CoalAdepter.CoalViewHolder> {

    private Context context;
    private List<CoalModel> coalModels;
    String TAG = "tag";
    DBHelper dbHelper;
    ShowAllDataActivity showAllDataActivity;

    public CoalAdepter(Context context, List<CoalModel> coalModels,ShowAllDataActivity showAllDataActivity) {
        this.context = context;
        this.coalModels = coalModels;
        this.showAllDataActivity = showAllDataActivity;
    }

    @NonNull
    @Override
    public CoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.each_row, parent, false);
        return new CoalViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CoalViewHolder holder, int position) {
        holder.totalCoalReceived.setText(coalModels.get(position).getTotal_coal_received());
        holder.totalCoalConception.setText(coalModels.get(position).getTotal_coal_conception());
        holder.openingStock.setText(coalModels.get(position).getOpening_stock());
        holder.totalMT.setText(coalModels.get(position).getTotalMT());
        holder.closingStock.setText(coalModels.get(position).getClosing_stock());
        holder.stockReclaimed.setText(coalModels.get(position).getStock_reclaimed());

        Log.d(TAG, "onBindViewHolder: "+coalModels.get(position).getTotal_coal_received()+
                        coalModels.get(position).getTotal_coal_conception()+
                        coalModels.get(position).getOpening_stock()+
                        coalModels.get(position).getTotalMT()+
                        coalModels.get(position).getClosing_stock()+
                        coalModels.get(position).getStock_reclaimed()
                );

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShowData.class);
                intent.putExtra(Constant.RACK1,coalModels.get(position).getRack1());
                intent.putExtra(Constant.RACK2,coalModels.get(position).getRack2());
                intent.putExtra(Constant.RACK3,coalModels.get(position).getRack3());
                intent.putExtra(Constant.RACK4,coalModels.get(position).getRack4());
                intent.putExtra(Constant.RACK5,coalModels.get(position).getRack5());
                intent.putExtra(Constant.RACK6,coalModels.get(position).getRack6());

                intent.putExtra(Constant.Total_COAL_RECEIVED,coalModels.get(position).getTotal_coal_received());
                intent.putExtra(Constant.TOTAL_COAL_CONCEPTION_MT,coalModels.get(position).getTotal_coal_conception());
                intent.putExtra(Constant.OPENING_STOCK_MT,coalModels.get(position).getOpening_stock());
                intent.putExtra(Constant.TOTAL_MT,coalModels.get(position).getTotalMT());
                intent.putExtra(Constant.CLOSING_STOCK,coalModels.get(position).getClosing_stock());
                intent.putExtra(Constant.STOCK_RECLAIMED,coalModels.get(position).getStock_reclaimed());
                intent.putExtra(Constant.MONTHLY_CONCEPTION,coalModels.get(position).getMonthly_conception());
                intent.putExtra(Constant.YEARLY_CONCEPTION,coalModels.get(position).getYearly_conception());
                intent.putExtra(Constant.MONTHLY_RECEIVED,coalModels.get(position).getMonthly_received());
                intent.putExtra(Constant.YEARLY_RECEIVED,coalModels.get(position).getYearly_received());
                intent.putExtra(Constant.TOTAL_MONTHLY_CONCEPTION,coalModels.get(position).getTotal_monthly_conception());
                intent.putExtra(Constant.TOTAL_YEARLY_CONCEPTION,coalModels.get(position).getTotal_yearly_conception());
                intent.putExtra(Constant.TOTAL_MONTHLY_RECEIVED,coalModels.get(position).getTotal_monthly_received());
                intent.putExtra(Constant.TOTAL_YEARLY_RECEIVED,coalModels.get(position).getTotal_yearly_received());
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showAlertDialogBox(context,String.valueOf(coalModels.get(position).getId()));
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return coalModels.size();
    }

    static class CoalViewHolder extends RecyclerView.ViewHolder{
        TextView totalCoalReceived,totalCoalConception,openingStock,totalMT,closingStock,stockReclaimed;
        CardView cardView;
        public CoalViewHolder(@NonNull View itemView) {
            super(itemView);
            totalCoalReceived = itemView.findViewById(R.id.er_total_coal_received);
            totalCoalConception= itemView.findViewById(R.id.er_total_coal_conception);
            openingStock = itemView.findViewById(R.id.er_opening_stock);
            totalMT = itemView.findViewById(R.id.er_total_mt);
            closingStock = itemView.findViewById(R.id.er_closing_stock);
            stockReclaimed = itemView.findViewById(R.id.er_stock_reclaimed);
            cardView = itemView.findViewById(R.id.card_er);
        }
    }


    void showAlertDialogBox(Context context, String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to Delete ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                deletePet(id);
                showAllDataActivity.recycleViewSetUp(context);
                Toast.makeText(context,"delete Item",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    public void deletePet(String id){
        dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int item = db.delete(Constant.TABLE_NAME, "_id=?", new String[]{id});
        if (item>0){
            Toast.makeText(context,"item Delete successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"item not Delete",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

}
