package com.example.coffeeappa1;

public class Order {
    //attributes of every order
    private int _id;
    private String _custName;
    private int _saleAmount;

    //default Constructor
    public Order(){
        _id = 0;
        _custName = null;
        _saleAmount = 0;
    }
    //2nd constructor
    public Order(String custName,int saleAmount){
        _custName = custName;
        _saleAmount = saleAmount;
    }//get method
    public int get_id() { return _id; }
    public String get_custName() { return _custName; }
    public double get_saleAmount() { return _saleAmount; }
    //set methods

    public void set_id(int _id) { this._id = _id; }
    public void set_custName(String _custName) { this._custName = _custName; }
    public void set_saleAmount(int _saleAmount) { this._saleAmount = _saleAmount; }
}//end of app
