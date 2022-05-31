package com.example.dcr;

public class CoalModel {

    private int id;

    private String rack1;
    private String rack2;
    private String rack3;
    private String rack4;
    private String rack5;
    private String rack6;

    private String closing_stock;
    private String stock_reclaimed;
    private String total_monthly_conception;
    private String total_yearly_conception;
    private String total_monthly_received;
    private String total_yearly_received;

    private String total_coal_conception;
    private String opening_stock;
    private String monthly_conception;
    private String yearly_conception;
    private String monthly_received;
    private String yearly_received;
    private String total_coal_received;
    private String totalMT;


    public CoalModel(int id ,
                     String rack1,
                     String rack2,
                     String rack3,
                     String rack4,
                     String rack5,
                     String rack6,

                     String total_coal_received,
                     String total_coal_conception,
                     String opening_stock,
                     String totalMT,
                     String closing_stock,
                     String stock_reclaimed,

                     String monthly_conception,
                     String yearly_conception,
                     String monthly_received,
                     String yearly_received,

                     String total_monthly_conception,
                     String total_yearly_conception,
                     String total_monthly_received,
                     String total_yearly_received
                     ) {

        this.rack1 = rack1;
        this.rack2 = rack2;
        this.rack3 = rack3;
        this.rack4 = rack4;
        this.rack5 = rack5;
        this.rack6 = rack6;

        this.closing_stock = closing_stock;
        this.stock_reclaimed = stock_reclaimed;
        this.total_monthly_conception = total_monthly_conception;
        this.total_yearly_conception = total_yearly_conception;
        this.total_monthly_received = total_monthly_received;
        this.total_yearly_received = total_yearly_received;
        this.total_coal_conception = total_coal_conception;
        this.opening_stock = opening_stock;
        this.monthly_conception = monthly_conception;
        this.yearly_conception = yearly_conception;
        this.monthly_received = monthly_received;
        this.yearly_received = yearly_received;
        this.total_coal_received = total_coal_received;
        this.totalMT = totalMT;
        this.id = id;
    }

    public void setTotal_coal_received(String total_coal_received) {
        this.total_coal_received = total_coal_received;
    }

    public String getTotal_coal_received() {
        return total_coal_received;
    }

    public String getTotalMT() {
        return totalMT;
    }

    public void setTotalMT(String totalMT) {
        this.totalMT = totalMT;
    }

    public String getClosing_stock() {
        return closing_stock;
    }

    public void setClosing_stock(String closing_stock) {
        this.closing_stock = closing_stock;
    }

    public String getStock_reclaimed() {
        return stock_reclaimed;
    }

    public void setStock_reclaimed(String stock_reclaimed) {
        this.stock_reclaimed = stock_reclaimed;
    }

    public String getTotal_monthly_conception() {
        return total_monthly_conception;
    }

    public void setTotal_monthly_conception(String total_monthly_conception) {
        this.total_monthly_conception = total_monthly_conception;
    }

    public String getTotal_yearly_conception() {
        return total_yearly_conception;
    }

    public void setTotal_yearly_conception(String total_yearly_conception) {
        this.total_yearly_conception = total_yearly_conception;
    }

    public String getTotal_monthly_received() {
        return total_monthly_received;
    }

    public void setTotal_monthly_received(String total_monthly_received) {
        this.total_monthly_received = total_monthly_received;
    }

    public String getTotal_yearly_received() {
        return total_yearly_received;
    }

    public void setTotal_yearly_received(String total_yearly_received) {
        this.total_yearly_received = total_yearly_received;
    }





    public CoalModel(int id, String rack1, String rack2, String rack3,
                     String rack4, String rack5, String rack6,
                     String total_coal_conception, String opening_stock, String monthly_conception,
                     String yearly_conception, String monthly_received, String yearly_received) {
        this.id =id;
        this.rack1 = rack1;
        this.rack2 = rack2;
        this.rack3 = rack3;
        this.rack4 = rack4;
        this.rack5 = rack5;
        this.rack6 = rack6;
        this.total_coal_conception = total_coal_conception;
        this.opening_stock = opening_stock;
        this.monthly_conception = monthly_conception;
        this.yearly_conception = yearly_conception;
        this.monthly_received = monthly_received;
        this.yearly_received = yearly_received;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRack1() {
        return rack1;
    }

    public void setRack1(String rack1) {
        this.rack1 = rack1;
    }

    public String getRack2() {
        return rack2;
    }

    public void setRack2(String rack2) {
        this.rack2 = rack2;
    }

    public String getRack3() {
        return rack3;
    }

    public void setRack3(String rack3) {
        this.rack3 = rack3;
    }

    public String getRack4() {
        return rack4;
    }

    public void setRack4(String rack4) {
        this.rack4 = rack4;
    }

    public String getRack5() {
        return rack5;
    }

    public void setRack5(String rack5) {
        this.rack5 = rack5;
    }

    public String getRack6() {
        return rack6;
    }

    public void setRack6(String rack6) {
        this.rack6 = rack6;
    }

    public String getTotal_coal_conception() {
        return total_coal_conception;
    }

    public void setTotal_coal_conception(String total_coal_conception) {
        this.total_coal_conception = total_coal_conception;
    }

    public String getOpening_stock() {
        return opening_stock;
    }

    public void setOpening_stock(String opening_stock) {
        this.opening_stock = opening_stock;
    }

    public String getMonthly_conception() {
        return monthly_conception;
    }

    public void setMonthly_conception(String monthly_conception) {
        this.monthly_conception = monthly_conception;
    }

    public String getYearly_conception() {
        return yearly_conception;
    }

    public void setYearly_conception(String yearly_conception) {
        this.yearly_conception = yearly_conception;
    }

    public String getMonthly_received() {
        return monthly_received;
    }

    public void setMonthly_received(String monthly_received) {
        this.monthly_received = monthly_received;
    }

    public String getYearly_received() {
        return yearly_received;
    }

    public void setYearly_received(String yearly_received) {
        this.yearly_received = yearly_received;
    }

}
