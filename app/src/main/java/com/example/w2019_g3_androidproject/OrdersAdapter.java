package com.example.w2019_g3_androidproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder>
{

    private List<String> list;

    public OrdersAdapter(List<String> list)
    {
        this.list = list;
    }

    @NonNull
    @Override
    //public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.oders_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {

        viewHolder.versionName.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView versionName;        //Cos we are displaying texts only

        public MyViewHolder(TextView itemView) {     //changed from View to TextView
            super(itemView);

            versionName = itemView;
        }
    }


}
