package com.example.vikalp.hackathon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by abhishek on 1/10/16.
 */
public class HomeEventsAdapter extends RecyclerView.Adapter<HomeEventsAdapter.ItemViewHolder> {
    private Context context;
    private  int size;
    private LayoutInflater inflater;
    public HomeEventsAdapter(Context context,int size){
        this.context = context;
        this.size =size;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.upcoming_events, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
