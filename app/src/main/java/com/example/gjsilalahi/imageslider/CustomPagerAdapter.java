package com.example.gjsilalahi.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by GJSILALAHI on 17/04/2018.
 */

class CustomPagerAdapter extends PagerAdapter {


    //MERUPAKAN KELAS ADAPTER YANG MENAMPUNG ARRAY
    // DARI GAMBAR UNTUK DITAMPILKAN PADA VIEW PAGER

    Context mContext;
    LayoutInflater mLayoutInflater;
    int mImages[];
    ImageView imageView;

    public CustomPagerAdapter(Context context, int images[]) {
        this.mContext = context;
        this.mImages = images;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = mLayoutInflater.inflate(R.layout.imagelayout, null);

        imageView =  view.findViewById(R.id.imageView);
        imageView.setImageResource(mImages[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
