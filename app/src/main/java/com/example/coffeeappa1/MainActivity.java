package com.example.coffeeappa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int noOfCoffee = 0;
    int priceOfCoffee = 5;
    int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method that is called on using the ORDER button
    public void submitOrder(View view) {
//        display(noOfCoffee);
//        int price = noOfCoffee * priceOfCoffee;
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText("Total: $"+price+"\n"+"Thank you - visit us again");

        // 1. We need the name of the customer to be stored in a variable
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // 2. Store the boolean value for toppings (Whipped Cream or Chocolate)
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById((R.id.whipped_cream_checkbox));
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById((R.id.chocolate_checkbox));
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // 3. Calculate the total price
        totalPrice = calculateOrderSummary(hasWhippedCream,hasChocolate);

        // create a string which has the complete order details
        String message = createOrderSummary(name,hasWhippedCream,hasChocolate,noOfCoffee,totalPrice);

        // 4. An intent to send the information to the second screen
        //start an intent
        Intent intent = new Intent(this, DisplayOrderDetails.class);
        intent.putExtra("name",name);
        intent.putExtra("message",message);
        intent.putExtra("totalPrice",Integer.toString(totalPrice));
        startActivity(intent);
    }
    // a method to create an order as a message
    public String createOrderSummary(String n,boolean hWC,boolean hC,int nOC,int tP){
        String orderMessage = "Name: "+n+"\n"+
                              "Add Whipped Cream? "+hWC+"\n"+
                              "Add Chocolate? "+hC+"\n"+
                              "Quantity: "+nOC+"\n"+
                              "Total: $"+tP+"\n"+
                              "Thank you!"+"\n";
        return orderMessage;
    }
    //create the calculateOrderSummary
    public int calculateOrderSummary(boolean hwc,boolean hc){
        //if the user wants whipped cream we need to add $1 to the price of coffee
        if(hwc == true)
            priceOfCoffee = priceOfCoffee+1;
        //if the user wants chocolate we need to add $2 to the price of coffee
        if(hc == true)
            priceOfCoffee = priceOfCoffee+2;
        //return the price
        totalPrice = noOfCoffee * priceOfCoffee;
        return totalPrice;
    }
    //display method
    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    //method to increment the number of Coffee
    public void increment(View view){
        noOfCoffee = noOfCoffee +1;
        if (noOfCoffee >=10 ){
            noOfCoffee = 10;
        }
        display(noOfCoffee);
    }
    //method to decrement the number of Coffee
    public void decrement(View view){
        noOfCoffee = noOfCoffee -1;
        if (noOfCoffee <=0){
            noOfCoffee = 0;
        }
        display(noOfCoffee);
    }
}