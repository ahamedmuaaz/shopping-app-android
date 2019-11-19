package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart extends AppCompatActivity {
  private Button clear;
    private MySimpleArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        clear=findViewById(R.id.btnClear);

        final SharedPreferences sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
        Map<String, ?> prefsMap = sharedPref.getAll();
        List<Item> items = new ArrayList<>();
        int l=0;
        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            Log.v("SharedPreferences", entry.getKey() + ":" +
                    entry.getValue().toString());
            //System.out.println(entry.getKey());
            Gson gson = new Gson();
            Item myitem= gson.fromJson(entry.getValue().toString(), Item.class);
            items.add(myitem);
        }
        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final Cart context = this;
        adapter = new MySimpleArrayAdapter(context,items);
        listview.setAdapter(adapter);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.commit();
                adapter.setItems(new ArrayList<Item>());
                adapter.notifyDataSetChanged();

            }
        });


    }
}
