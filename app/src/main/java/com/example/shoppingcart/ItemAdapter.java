package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    private final Context mContext;
    private final Item[] items;

    // 1
    public ItemAdapter(Context context, Item[] items) {
        this.mContext = context;
        this.items = items;
    }

    // 2
    @Override
    public int getCount() {
        return items.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return items[position];
    }

    public Context getmContext() {
        return mContext;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Item item = items[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_item, null);
        }

        // 3
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView) convertView.findViewById(R.id.textview_book_name);
        final TextView authorTextView = (TextView) convertView.findViewById(R.id.textview_book_author);
        //final ImageView imageViewFavorite = (ImageView) convertView.findViewById(R.id.imageview_favorite);

        // 4
        imageView.setImageResource(item.getImageResource());
        nameTextView.setText(mContext.getString(item.getName()));
        authorTextView.setText(mContext.getString(item.getAuthor()));

        return convertView;
    }

}
