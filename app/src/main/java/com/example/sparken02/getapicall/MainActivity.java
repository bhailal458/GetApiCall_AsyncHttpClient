package com.example.sparken02.getapicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView ls;
    Response responseobj;
    CustomAdapter adapter;
    String url = "http://api.androidhive.info/contacts/";
    Gson gson;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls = (ListView) findViewById(R.id.ls);

        client = new AsyncHttpClient();
        client.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseobj = gson.fromJson(responsestr,Response.class);
                adapter = new CustomAdapter(MainActivity.this,responseobj.getContacts());
                ls.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
