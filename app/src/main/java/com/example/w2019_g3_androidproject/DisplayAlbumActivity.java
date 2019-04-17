package com.example.w2019_g3_androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.w2019_g3_androidproject.Models.Customer;
import com.example.w2019_g3_androidproject.Models.Product;
import com.example.w2019_g3_androidproject.Models.ShoppingCart;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DisplayAlbumActivity extends AppCompatActivity {


    ImageView imageView;
    TextView albumTitle;
    TextView albumAuthor;
    TextView albumYear;
    TextView albumPrice;

    Product product;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_album);

        imageView = findViewById(R.id.albumCover);
        albumTitle = findViewById(R.id.albumTitle);
        albumAuthor = findViewById(R.id.albumAuthor);
        albumYear = findViewById(R.id.albumYear);
        albumPrice = findViewById(R.id.albumPrice);

        product = (Product) getIntent().getSerializableExtra("product");
        customer = (Customer) getIntent().getSerializableExtra("customer");

        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
        albumTitle.setText("Title : " + product.get_productName()+customer.get_custName());
        albumAuthor.setText("Author : " + product.get_author());
        albumYear.setText("Year : " + product.get_year().toString());
        albumPrice.setText("Price : $" + product.get_price().toString());



    }

    public void AddItem(View view)
    {


        ShoppingCart cartItem = new ShoppingCart(1,  product, 1);

        cartItem.addCartItem(customer);
            int tot = customer._shoppingCart.size();
        Toast.makeText(DisplayAlbumActivity.this, "Album Added to Cart (" + tot+")", Toast.LENGTH_SHORT).show();




    }

    public void GoAlbums(View view)
    {

        Intent mIntent = new Intent(DisplayAlbumActivity.this, MainActivity.class);
        //Set value to pass on next activity

        mIntent.putExtra("customer", this.customer);
        startActivity(mIntent);





    }

}
