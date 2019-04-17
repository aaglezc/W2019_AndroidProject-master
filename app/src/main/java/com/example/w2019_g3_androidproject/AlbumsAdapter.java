package com.example.w2019_g3_androidproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.w2019_g3_androidproject.Models.Customer;
import com.example.w2019_g3_androidproject.Models.Product;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ImageViewHolder> {
    @NonNull

    private int[] images;
    public Product[] products;
    private Customer customer;

    private Context context;      // For the click event


    //public RecyclerAdapter(int[] images)
    public AlbumsAdapter(int[] images, Context context, Product[] products, Customer customer)       //for click event
    {
        this.images = images;
        this.products = products;
        this.customer = customer;

        this.context = context;         // For the click event
    }



    @Override
    //public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.albums_layout,viewGroup,false);
        //ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context,images,products, customer);    //for the click event

        return imageViewHolder;
    }

    @Override
    //public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {

        int imgID = images[i];


        //Aqui configurar des dela clase productos@@!

        viewHolder.album.setImageResource(imgID);
        viewHolder.albumTitle.setText(products[i].get_productName());
        viewHolder.albumYear.setText(products[i].get_year().toString());
        viewHolder.albumAuthor.setText(products[i].get_author());


    }

    @Override
    public int getItemCount() {

        return images.length;
    }



    //------holder

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView album;
        TextView albumTitle;
        TextView albumYear;
        TextView albumAuthor;


        Context context;         // for the click event
        int[] images;            // for the click event

        Product[] products;
        Customer customer;


        //public ImageViewHolder(@NonNull View itemView, Context context)
        public ImageViewHolder(@NonNull View itemView, Context context, int[] images, Product[] products, Customer customer)      //for click event
        {
            super(itemView);

            album = itemView.findViewById(R.id.album);
            albumTitle = itemView.findViewById(R.id.albumTitle);
            albumYear = itemView.findViewById(R.id.albumYear);
            albumAuthor = itemView.findViewById(R.id.albumAuthor);


            itemView.setOnClickListener(this);     //Added for Click event
            this.context = context;               // for the click event
            this.images = images;                 // for the click event
            this.products = products;
            this.customer = customer;


        }


        @Override
        public void onClick(View view)
        {

            Intent intent = new Intent(context,DisplayAlbumActivity.class);

            Product p = products[getAdapterPosition()];

            intent.putExtra("image_id",images[getAdapterPosition()]);

            intent.putExtra("product",p);
            intent.putExtra("customer", customer);

            context.startActivity(intent);


        }
    }

}
