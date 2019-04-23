package com.example.w2019_g3_androidproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.w2019_g3_androidproject.Models.Customer;
import com.example.w2019_g3_androidproject.Models.Product;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private int[] images = {
            R.drawable.mm,
            R.drawable.elvis2nd,
            R.drawable.gunr3,
            R.drawable.johndenver,
            R.drawable.ledz2,
            R.drawable.muse2,
            R.drawable.rods,
    };

    private Product[] products;
    private Customer customer;


    private RecyclerView.LayoutManager layoutManager;
    //first create class
    private AlbumsAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aqui configurar des dela clase productos@@!

        products = new Product[10];
        products[0] = new Product( 1, "Stiches          ", 10.0, "Mother Mother", 2008, "08 Bit By Bit", "mm.jpg");
        products[1] = new Product( 2, "Elvis 2nd to None", 12.0, "Elvis Presley", 2012, "elvis2nd.jpg", "mm.jpg");
        products[2] = new Product( 3, "Guns&Roses       ", 12.0, "Guns&Roses", 1985, "gunr3.jpg", "mm.jpg");
        products[3] = new Product( 4, "Definitive all   ", 9.10, "John Denver", 1969, "johndenver.jpg", "mm.jpg");
        products[4] = new Product( 5, "Led Zeppelin II  ", 12.0, "Led Zeppelin", 1976, "ledzv.jpg", "mm.jpg");
        products[5] = new Product( 6, "The Resistance   ", 12.0, "Muse", 2014, "mm.jpg", "mm.jpg");
        products[6] = new Product( 7, "Romance", 12.0, "Rod Steward", 2014, "rods.jpg", "mm.jpg");

        this.customer = (Customer) getIntent().getSerializableExtra("customer");


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,1);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AlbumsAdapter(images,this, products, customer);
        //adapter = new Albums_RecyclerAdapter(images,this);       // for click event

        recyclerView.setAdapter(adapter);













    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main,menu);

        return true;//super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String msg = "";
        switch (item.getItemId())
        {
            case R.id.mnuHome:
                msg = "Home";

                Intent mIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(mIntent);
                break;
            case R.id.mnuContact:
                msg = "Contact";

                Intent mIntent2 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(mIntent2);

                break;
            case R.id.mnuAbout:
                msg = "About";
                Intent mIntent3 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(mIntent3);

            case R.id.mnuOrders:
                msg = "Check Out";


                //Intent mIntent4 = new Intent(MainActivity.this, CheckOutActivity.class);
                //startActivity(mIntent4);
                Intent mIntent4 = new Intent(MainActivity.this, CheckOutActivity.class);
                //Set value to pass on next activity

                mIntent4.putExtra("customer", customer);
                startActivity(mIntent4);

                break;
            case R.id.mnuLogout:
                msg = "Logout";
                showDialog();
                Intent mIntent5 = new Intent(MainActivity.this, LoginActivity.class);
                break;
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void showDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        alertDialogBuilder.setTitle("Log Out App");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

}
