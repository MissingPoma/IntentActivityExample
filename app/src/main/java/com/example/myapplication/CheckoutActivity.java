package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutActivity extends AppCompatActivity {
    private EditText nameEditText, phoneNumberEditText, addressEditText;
    private RadioGroup itemRadioGroup, paymentRadioGroup;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        nameEditText = findViewById(R.id.name);
        phoneNumberEditText = findViewById(R.id.phoneNumber);
        addressEditText = findViewById(R.id.address);
        itemRadioGroup = findViewById(R.id.radioGroup1);
        paymentRadioGroup = findViewById(R.id.radioGroup2);
        checkoutButton = findViewById(R.id.btnCheckout);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndCheckout();
            }
        });
    }

    private void validateAndCheckout() {
        // Validate Name
        String name = nameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            nameEditText.setError("Name is required");
            return;
        }

        // Validate Phone Number
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("Phone number is required");
            return;
        }

        // Validate Address
        String address = addressEditText.getText().toString().trim();
        if (TextUtils.isEmpty(address)) {
            addressEditText.setError("Address is required");
            return;
        }

        // Validate Item Selection
        int selectedItemId = itemRadioGroup.getCheckedRadioButtonId();
        if (selectedItemId == -1) {
            Toast.makeText(this, "Please select an item", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedItemRadioButton = findViewById(selectedItemId);
        String selectedItem = selectedItemRadioButton.getText().toString();

        // Validate Payment Method
        int selectedPaymentId = paymentRadioGroup.getCheckedRadioButtonId();
        if (selectedPaymentId == -1) {
            Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedPaymentRadioButton = findViewById(selectedPaymentId);
        String selectedPaymentMethod = selectedPaymentRadioButton.getText().toString();

        // Create Intent to send data to next activity
        Intent intent = new Intent(this, CheckoutDetailActivity.class);
        intent.putExtra("Name", name);
        intent.putExtra("PhoneNumber", phoneNumber);
        intent.putExtra("Address", address);
        intent.putExtra("SelectedItem", selectedItem);
        intent.putExtra("SelectedPaymentMethod", selectedPaymentMethod);
        startActivity(intent);
    }
}