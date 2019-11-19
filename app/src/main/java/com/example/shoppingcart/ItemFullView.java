package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


public class ItemFullView extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView author;
    private ImageButton cart_btn;
    private ImageButton home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_full_view);
        img = findViewById(R.id.imageView2);
        author = findViewById(R.id.textfullauthor);
        name = findViewById(R.id.textfullname);
        cart_btn=findViewById(R.id.btncart);
        home_btn=findViewById(R.id.btnhome);
        Intent i = getIntent();
        final Item item = (Item) i.getSerializableExtra("item");
        img.setImageResource(item.getImageResource());
        author.setText(item.getAuthor());
        name.setText(item.getName());

        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);

        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                v.startAnimation(buttonClick);
                Context context = getApplicationContext();
                CharSequence text = "Item Added To Cart";
                int duration = Toast.LENGTH_SHORT;
                SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                Gson gson = new Gson();
                String json = gson.toJson(item);
                editor.putString(name.getText().toString(),json);
                editor.commit();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent = new Intent(getApplicationContext(),Menu.class);
                //intent.putExtra("item", i);
                startActivity(intent);
            }
        });

    }


}
