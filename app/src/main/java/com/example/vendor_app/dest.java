package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class dest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);
    }

    public void messageD(View view) {
        Intent intent = new Intent(this,garbageC.class);
        startActivity(intent);
    }

    public void messageT(View view) {
        Toast toast = Toast.makeText(this,"जब आप अपने कार्य इस्थान पर पहुंच जाएंगे तब इस सवाल का जवाब जरूर  दीजियेगा।\n" +
                "धन्यवाद",Toast.LENGTH_LONG);
        toast.show();
    }
}