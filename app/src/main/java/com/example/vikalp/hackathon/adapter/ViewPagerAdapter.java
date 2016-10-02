package com.example.vikalp.hackathon.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.vikalp.hackathon.HomeEventsAdapter;
import com.example.vikalp.hackathon.PicassoCircleTransform;
import com.example.vikalp.hackathon.PlayerAdapter;
import com.example.vikalp.hackathon.R;
import com.example.vikalp.hackathon.RecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abhishek on 1/10/16.
 */
public class ViewPagerAdapter extends PagerAdapter {


    private Context context;

    private ImageView imageView;
    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = null;

        if(position==0){
            layout = (ViewGroup) inflater.inflate(R.layout.home_profile,container,false);


            RecyclerView upcoming = (RecyclerView) layout.findViewById(R.id.upcoming_recycler);

            HomeEventsAdapter upcAdapter =  new HomeEventsAdapter(context,4);

          //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

            upcoming.setHasFixedSize(true);
            upcoming.setAdapter(upcAdapter);
            upcoming.setLayoutManager(linearLayoutManager1);

        }else if(position==1){
            layout = (ViewGroup) inflater.inflate(R.layout.notification_profile,container,false);
            RecyclerView view = (RecyclerView) layout.findViewById(R.id.notification_recycler);
            RecyclerAdapter adapter = new RecyclerAdapter(context,2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            view.setHasFixedSize(true);
            view.setAdapter(adapter);
            view.setLayoutManager(linearLayoutManager);

        }else if(position==2){
            layout = (ViewGroup) inflater.inflate(R.layout.account_profile,container,false);

        }

        container.addView(layout);

        return layout;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }





}
