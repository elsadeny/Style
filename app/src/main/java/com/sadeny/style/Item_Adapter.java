package com.sadeny.style;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Item_Adapter extends  Adapter<Item_Adapter.MyViewHolder>{

    private Context context;
    private List<ItemDesc> itemList;

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public class MyViewHolder extends ViewHolder
    {
        public TextView it_desc,it_price;
        public ImageView it_image;

        MyViewHolder(View view)
        {
            super(view);
            it_desc = (TextView)view.findViewById(R.id.it_name_1);
            it_image=(ImageView)view.findViewById(R.id.item_img_1);
            it_price=(TextView)view.findViewById(R.id.it_price_1);
        }
    }

    public Item_Adapter(Context context,List<ItemDesc> itemList)
    {
        this.context=context;
        this.itemList=itemList;
    }

    //creating the view holder instance
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent ,int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.s_item_card,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        ItemDesc itemDesc = itemList.get(position);
        holder.it_desc.setText(itemDesc.getItemName());
        holder.it_price.setText(Float.toString(itemDesc.getItem_price()));
        //adding image to the holder
        holder.it_image.setImageBitmap(itemDesc.getItem_pic());
        //set the event

    }




}
