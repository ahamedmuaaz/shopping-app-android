package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MySimpleArrayAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private List<Item> items;

    public MySimpleArrayAdapter(Context context, List<Item> items) {
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.cartview, parent, false);
        TextView textViewTitle = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textView = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textViewTitle.setText(items.get(position).getName());
        textView.setText(items.get(position).getAuthor());
        // change the icon for Windows and iPhone

        imageView.setImageResource(items.get(position).getImageResource());


        return rowView;
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}