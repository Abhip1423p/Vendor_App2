package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {
    EditText ed_PersonName;
String str_name;
String url ="http://akkdev.in/street/api/register";
Button loginButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed_PersonName = findViewById(R.id.ed_PersonName);
        loginButton  = findViewById(R.id.loginButton);


    }

   // public void NumberAuth(View view) {
    //   Toast myTost =   Toast.makeText(this ,"button was clicked ",Toast.LENGTH_LONG);
      //  myTost.show();
        // we use here Intent constructor ,this constructor is used  open new activity

     //   Intent intent = new Intent(this,numberAuth.class);
     // startActivity(intent);
   // }

    public  void loginButton(View view){
      final ProgressDialog progressDialog  = new ProgressDialog(this);
      progressDialog.setTitle("please wait");


        if (ed_PersonName.getText().toString().equals("")){

            Toast.makeText(this,"कृपया नाम दर्ज करें",Toast.LENGTH_LONG).show();
        }
    else {
          progressDialog.show();
             str_name = ed_PersonName.getText().toString().trim();

//// creating new request
          StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
             @Override
              public void onResponse(String response) {                  // on response toast message
                 progressDialog.dismiss();
                 startActivity(new Intent(getApplicationContext(),numberAuth.class) );
                 Toast.makeText(MainActivity.this, response ,Toast.LENGTH_LONG).show();

             }
          },
                 new Response.ErrorListener() {
                @Override
              public void onErrorResponse(VolleyError error) {
                 progressDialog.dismiss();


                     //startActivity(new Intent(getApplicationContext(),numberAuth.class) );
                 Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();

              }
          }
          )
          {
              @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new  HashMap<String,String>();params.put("name",str_name);
                 return  params;
             }
         };
         RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
           // add request
           requestQueue.add(request);
 startActivity(new Intent(getApplicationContext(),numberAuth.class) );
        }
    }


}