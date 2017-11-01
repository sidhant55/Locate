package com.example.sidhant.locate;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.LinkedList;
import java.util.Queue;

public class Main2Activity extends AppCompatActivity {

    Button bn1, bn2, bn3;
    Button save1, save2, save3;
    ToggleButton toggle,toggle2,toggle1;
    String lat, lon, id;
    LocationManager locationManager;
    Context context = this;

    int counter=0;
    stLocMan obj1=null,obj2=null,obj3=null;
    Queue<String> q = new LinkedList<>();

    String url = "https://locate123.herokuapp.com/getId/"+id+"/",resp;
    int e=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bn1 = (Button) findViewById(R.id.button);
        bn2=(Button) findViewById(R.id.button2);
        bn3=(Button) findViewById(R.id.button3);

        String s=getIntent().getStringExtra("name");
        TextView tv6 = (TextView) ((Activity)context).findViewById(R.id.textView14);
        tv6.setText("Welcome "+s);
        id=getIntent().getStringExtra("email");

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj1==null) {

                    RequestQueue queue = Volley.newRequestQueue(context);
                    String url ="https://locate123.herokuapp.com/getId/"+id+"/";

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    resp=response.toString();
                                    resp=resp.substring(1,resp.length()-1);
                                    TextView tv6 = (TextView) ((Activity)context).findViewById(R.id.textView);
                                    tv6.setText("Trip "+resp);
                                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Response: " + resp, Snackbar.LENGTH_LONG);
                                    snackbar.show();

                                    obj1 = new stLocMan(context, id, resp, "A");
                                    obj1.start();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Internet Error", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);


                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Trip 1 Started "+e, Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Save Trip 1", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj2==null) {

                    RequestQueue queue = Volley.newRequestQueue(context);
                    String url ="https://locate123.herokuapp.com/getId/"+id+"/";

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    resp=response.toString();
                                    resp=resp.substring(1,resp.length()-1);
                                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Response: " + resp, Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    TextView tv6 = (TextView) ((Activity)context).findViewById(R.id.textView3);
                                    tv6.setText("Trip "+resp);
                                    obj2 = new stLocMan(context, id, resp,"B");
                                    obj2.start();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Internet Error", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);

                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Trip 2 Started", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Save Trip 1", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (obj3==null) {

                    RequestQueue queue = Volley.newRequestQueue(context);
                    String url ="https://locate123.herokuapp.com/getId/"+id+"/";

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    resp=response.toString();
                                    resp=resp.substring(1,resp.length()-1);
                                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Response: " + resp, Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    TextView tv6 = (TextView) ((Activity)context).findViewById(R.id.textView4);
                                    tv6.setText("Trip "+resp);
                                    obj3 = new stLocMan(context, id, resp,"C");
                                    obj3.start();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Internet Error", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);

                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Trip 3 Started", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Save Trip 1", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked)
                {
                    if (obj1==null)
                    {
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Start Trip 1", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        toggle.setChecked(false);
                    }
                    else {
                        obj1.flag = 1;
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Started recording location for Trip 1", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
                else
                {
                    if (obj1!=null) {
                        obj1.flag = 0;
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Recording for Trip 1 Paused", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            }

        });

        toggle1 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    if (obj2==null)
                    {
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Start Trip 2", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        toggle1.setChecked(false);
                    }
                    else {
                        obj2.flag = 1;
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Started recording location for Trip 2", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
                else
                {
                    if (obj2!=null) {
                        obj2.flag = 0;
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Recording for Trip 2 Paused", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            }

        });

        toggle2 = (ToggleButton) findViewById(R.id.toggleButton3);
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    if (obj3==null)
                    {
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Please Start Trip 3", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        toggle2.setChecked(false);
                    }
                    else {
                        obj3.flag = 1;
                        Snackbar snackbar =Snackbar.make(findViewById(android.R.id.content), "Started recording location for Trip 3", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
                else
                {
                    if (obj3!=null) {
                        obj3.flag = 0;
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Recording for Trip 3 Paused", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            }

        });

        save1 = (Button) findViewById(R.id.button4);
        save2=(Button) findViewById(R.id.button5);
        save3=(Button) findViewById(R.id.button6);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj1==null)
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "First Start Trip 1", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else {
                    int temp = obj1.save();
                    if (temp == 1) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 1 Saved", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        obj1=null;
                        toggle.setChecked(false);
                    } else {
                        obj1.post();
                        if (obj1.q==null)
                        {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 1 Saved", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            obj1.flag1=1;
                            obj1=null;
                        }
                        else {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Wait for internet connection", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                }
            }
        });

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj2==null)
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "First Start Trip 2", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else {
                    int temp = obj2.save();
                    if (temp == 1) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 2 Saved", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        obj2=null;
                        toggle1.setChecked(false);
                    } else {
                        obj2.post();
                        if (obj2.q==null)
                        {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 2 Saved", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            obj2.flag1=1;
                            obj2=null;
                        }
                        else {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Wait for internet connection", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                }
            }
        });

        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj3==null)
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "First Start Trip 3", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else {
                    int temp = obj3.save();
                    if (temp == 1) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 3 Saved", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        obj3=null;
                        toggle2.setChecked(false);
                    } else {
                        obj3.post();
                        if (obj3.q==null)
                        {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Trip 3 Saved", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            obj3.flag1=1;
                            obj3=null;
                        }
                        else {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Wait for internet connection", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                }
            }
        });

    }
}
