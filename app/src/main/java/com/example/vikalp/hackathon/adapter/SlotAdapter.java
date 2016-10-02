package com.example.vikalp.hackathon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vikalp.hackathon.R;

/**
 * Created by abhishek on 2/10/16.
 */
public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ItemViewHolder> {
    private Context context;
    private  int size;
    private LayoutInflater inflater;
    public SlotAdapter(Context context,int size){
        this.context = context;
        this.size =size;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.slot_item_layout, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
