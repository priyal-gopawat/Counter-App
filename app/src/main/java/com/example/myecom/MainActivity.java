package com.example.myecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
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

        //receiving data from saved instance
        if(savedInstanceState!=null) {
            qty = savedInstanceState.getInt(Constants.VALUE, 0);
        }
            else{
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                qty = prefs.getInt(Constants.VALUE,0);
            }
        b.qty.setText("" + qty);
    }

    // Saving data by saved instance
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constants.VALUE,qty);
    }

    // Saved data by shared preferences
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.edit()
                .putInt(Constants.VALUE,qty)
                .apply();
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