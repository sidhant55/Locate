package com.example.sidhant.locate;

/**
 * Created by sidhant on 17/9/17.
 */

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sidhant on 8/8/17.
 */

public class stLocMan extends AppCompatActivity {

    int e1=0,e2=0,e3=0,e4=0,e5=0;

    Context context;
    LocationManager locationManager;
    LocationListener locationListener;
    String lat,lon;
    int counter=0,c3=0;
    int flag=0,left=0,collected=0,flag1=0,uploaded=0;
    String id,idtv,trip;


    Queue<String> q = new LinkedList<>();



    stLocMan(Context context,String id1, String id2, String id3)
    {
        this.context=context;
        id = id1;
        trip=id2;
        idtv=id3;
        TextView tv5 = (TextView) ((Activity)context).findViewById(R.id.textView2);
        tv5.setText("Your Id "+id);
    }

    @SuppressWarnings({"MissingPermission"})
    public void start ()
    {
        TextView tv5 = (TextView) ((Activity)context).findViewById(R.id.textView2);
        tv5.setText("Working");

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // Define a listener that responds to location updates
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                // Called when a new location is found by the network location provider.
                counter++;
                lat = Double.toString(location.getLatitude());
                lon = Double.toString(location.getLongitude());
                TextView tv5 = (TextView) ((Activity)context).findViewById(R.id.textView2);
                tv5.setText("Your Location: Lat " +lat.substring(0,6)+" Long "+lon.substring(0,6));

                if (idtv.equals("A") && flag==1) {
                    collected++;
                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView5);
                    tv2.setText("Collected : "+collected);
                }
                else if (idtv.equals("B") && flag==1) {
                    collected++;
                    TextView tv3 = (TextView) ((Activity) context).findViewById(R.id.textView6);
                    tv3.setText("Collected : "+collected);
                }
                else if (idtv.equals("C") && flag==1) {
                    collected++;
                    TextView tv4 = (TextView) ((Activity) context).findViewById(R.id.textView7);
                    tv4.setText("Collected : "+collected);
                }

                call(lat, lon);

            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }

        };
        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,60000,100, locationListener);
    }


    private void call(String lat, String lon) {
        if (flag == 1) {
            this.q.add(lat + "/" + lon);
            post();
        }
    }

    public void post() {
        String temp = q.peek();
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://locate123.herokuapp.com/currentlocation/" + id + "/"+trip+"/" + temp+"/";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        uploaded++;
                        if (q.peek() != null)
                            q.remove();
                        if (left > 0) {
                            //left--;
                            Iterator itr = q.iterator();
                            while (itr.hasNext() && left > 0 && q.peek() != null) {
                                left--;
                                uploaded++;
                                String temp1 = q.peek();
                                com.android.volley.RequestQueue q1 = Volley.newRequestQueue(context);
                                String url1 = "https://locate123.herokuapp.com/currentlocation/" + id + "/"+trip+"/" + temp1+"/";
                                q.remove();
                                StringRequest stringRequest1 = new StringRequest(com.android.volley.Request.Method.POST, url1,
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                e1++;
                                            }
                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        e2++;
                                    }
                                });
                                q1.add(stringRequest1);
                                try {
                                    e4++;
                                    Thread.sleep(250);
                                } catch (InterruptedException e) {
                                    e5++;
                                    e.printStackTrace();
                                }
                                if (idtv.equals("A")) {
                                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView11);
                                    tv2.setText("Left : "+left);
                                }
                                else if (idtv.equals("B")) {
                                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView12);
                                    tv2.setText("Left : "+left);
                                }
                                else if (idtv.equals("C")) {
                                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView13);
                                    tv2.setText("Left : "+left);
                                }
                            }
                        }

                        if (idtv.equals("A")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView8);
                            tv2.setText("Uploaded ; "+uploaded);
                        }
                        else if (idtv.equals("B")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView9);
                            tv2.setText("Uploaded ; "+uploaded);
                        }
                        else if (idtv.equals("C")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView10);
                            tv2.setText("Uploaded ; "+uploaded);
                        }

                        if (idtv.equals("A")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView11);
                            tv2.setText("Left : "+left);
                        }
                        else if (idtv.equals("B")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView12);
                            tv2.setText("Left : "+left);
                        }
                        else if (idtv.equals("C")) {
                            TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView13);
                            tv2.setText("Left : "+left);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                left++;
                if (idtv.equals("A")) {
                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView11);
                    tv2.setText("Left : "+left);
                }
                else if (idtv.equals("B")) {
                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView12);
                    tv2.setText("Left : "+left);
                }
                else if (idtv.equals("C")) {
                    TextView tv2 = (TextView) ((Activity) context).findViewById(R.id.textView13);
                    tv2.setText("Left : "+left);
                }

            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public int save()
    {
        if (left==0)
        {
            this.q=null;
            return 1;
        }
        else
        {
            return 0;
        }
    }
    public void saveit()
    {

    }

}