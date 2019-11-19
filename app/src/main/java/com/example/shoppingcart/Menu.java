package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    GridView gridView;
    Button cart_view;
    ViewPager viewPager;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomAdapter(this);
        viewPager.setAdapter(adapter);
        cart_view=findViewById(R.id.btnviewcart);
        Item[] Items = {
                new Item(R.string.abc_an_amazing_alphabet_book, R.string.dr_seuss, R.drawable.abc,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/abc.jpg"),
                new Item(R.string.are_you_my_mother, R.string.dr_seuss, R.drawable.areyoumymother,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/areyoumymother.jpg"),
                new Item(R.string.where_is_babys_belly_button, R.string.karen_katz, R.drawable.whereisbabysbellybutton,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/whereisbabysbellybutton.jpg"),
                new Item(R.string.on_the_night_you_were_born, R.string.nancy_tillman, R.drawable.onthenightyouwereborn,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/onthenightyouwereborn.jpg"),
                new Item(R.string.hand_hand_fingers_thumb, R.string.dr_seuss, R.drawable.handhandfingersthumb,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/handhandfingersthumb.jpg"),
                new Item(R.string.the_very_hungry_caterpillar, R.string.eric_carle, R.drawable.theveryhungrycaterpillar,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/theveryhungrycaterpillar.jpg"),
                new Item(R.string.the_going_to_bed_book, R.string.sandra_boynton, R.drawable.thegoingtobedbook,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/thegoingtobedItem.jpg"),
                new Item(R.string.oh_baby_go_baby, R.string.dr_seuss, R.drawable.ohbabygobaby,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/ohbabygobaby.jpg"),
                new Item(R.string.the_tooth_book, R.string.dr_seuss, R.drawable.thetoothbook,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/thetoothItem.jpg"),
                new Item(R.string.one_fish_two_fish_red_fish_blue_fish, R.string.dr_seuss, R.drawable.onefish,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/onefish.jpg"),
                new Item(R.string.one_fish_two_fish_red_fish_blue_fish, R.string.dr_seuss, R.drawable.onefish,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/onefish.jpg"),
                new Item(R.string.one_fish_two_fish_red_fish_blue_fish, R.string.dr_seuss, R.drawable.onefish,
                        "http://www.raywenderlich.com/wp-content/uploads/2016/03/onefish.jpg"),
        };

        gridView = (GridView) findViewById(R.id.gridview);
        final ItemAdapter itemsAdapter = new ItemAdapter(this, Items);
        gridView.setAdapter(itemsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Item i = (Item) itemsAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), ItemFullView.class);
                intent.putExtra("item", i);
                startActivity(intent);
            }
        });
        cart_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });

    }
}
