package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;
import java.util.Map;

public class numberAuth extends AppCompatActivity {


    String url ="http://akkdev.in/street/api/register";
String  str_number;
    EditText edit_text;
    Button savePhoneNumber;
private TextView getPhoneNumber;

private CountryCodePicker ccp;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_number_auth);

        edit_text = findViewById(R.id.edit_text);
        savePhoneNumber = findViewById(R.id.savePhoneNumber);


        init();
    }
    private void init(){
        ccp =findViewById(R.id.ccp);
        edit_text = findViewById(R.id.edit_text);

        savePhoneNumber = findViewById(R.id.savePhoneNumber);
       // getPhoneNumber =findViewById(R.id.getPhoneNumber);


    }


    public void DisplayMessage(View view)
   {
        final ProgressDialog progressDialog  = new ProgressDialog(this);
        progressDialog.setTitle("please wait");


        if (edit_text.getText().toString().equals("")){

            Toast.makeText(this,"कृपया फ़ोन नंबर  दर्ज करें",Toast.LENGTH_LONG).show();
        }
        else {
            progressDialog.show();
            str_number = edit_text.getText().toString().trim();

// creating new request
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // on response toast message
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(),dropdown_List.class) );
                    Toast.makeText(numberAuth.this, response ,Toast.LENGTH_LONG).show();

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();


                            startActivity(new Intent(getApplicationContext(),dropdown_List.class) );
                            Toast.makeText(numberAuth.this,error.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
            )
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("mobile",str_number);
                    return  params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(numberAuth.this);
            // add request
            requestQueue.add(request);



        }
    }





}