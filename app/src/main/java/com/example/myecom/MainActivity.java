package com.example.myecom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myecom.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int qty = 0;
     private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(b.getRoot());

    }

    /**
     * Decrements  counter by 1
     * @param view
     */
    public void decQty(View view) {
        b.qty.setText(""+ --qty);
    }

    /**
     * Increments counter by 1
     * @param view
     */
    public void incQty(View view) {
        b.qty.setText(""+ ++qty);
    }
}