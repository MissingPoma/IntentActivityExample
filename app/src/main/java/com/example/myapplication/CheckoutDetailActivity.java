package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutDetailActivity extends AppCompatActivity {

    private TextView textViewName, textViewPhoneNumber, textViewAddress, textViewItem, textViewPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout_detail);
// Initialize TextViews
        textViewName = findViewById(R.id.textViewName);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewItem = findViewById(R.id.textViewItem);
        textViewPaymentMethod = findViewById(R.id.textViewPaymentMethod);

        // Get data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String phoneNumber = intent.getStringExtra("PhoneNumber");
        String address = intent.getStringExtra("Address");
        String selectedItem = intent.getStringExtra("SelectedItem");
        String selectedPaymentMethod = intent.getStringExtra("SelectedPaymentMethod");

        // Set data to TextViews
        textViewName.setText(name);
        textViewPhoneNumber.setText("Phone Number: " + phoneNumber);
        textViewAddress.setText("Address: " + address);
        textViewItem.setText("Selected Item: " + selectedItem);
        textViewPaymentMethod.setText("Payment Method: " + selectedPaymentMethod);
    }
}