package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class CustomAdapter extends PagerAdapter {
    private int[] images = {R.drawable.kids2,R.drawable.winter};
    private Context ctx;
    private LayoutInflater inflater;

    public CustomAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);
       // TextView tv  = (TextView)v.findViewById(R.id.textView);
        img.setImageResource(images[position]);
       // tv.setText("Image :"+position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        container.refreshDrawableState();
    }
}
