package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnBuy = (Button)  findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenBuyActivity = new Intent(getApplicationContext(), CheckoutActivity.class);
                startActivity(OpenBuyActivity);
            }
        });
    }
}