package com.delta.deltajsonreader;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

public class MainActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = getJSONFile();
        String myDataArray[] = {};


        //setup my listView

        mListView = (ListView) findViewById(R.id.mylistview);

        ArrayAdapter<String> stringAdapter =
                new ArrayAdapter<String>(getApplicationContext(), R.layout.list_row, myDataArray);

        if (mListView != null) {
            mListView.setAdapter(stringAdapter);
        }


    }


    public String getJSONFile(){

        String json = null;
        try {

            InputStream is = getResources().openRawResource(R.raw.samplejson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}