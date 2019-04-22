package com.example.w2019_g3_androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.w2019_g3_androidproject.Models.Customer;
import com.example.w2019_g3_androidproject.Models.ShoppingCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    private List<String> list;

    private OrdersAdapter adapter;

    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);



        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //list = Arrays.asList(getResources().getStringArray(R.array.android_version));

        list = new ArrayList<>();

        this.customer = (Customer) getIntent().getSerializableExtra("customer");



        String temp;
        ShoppingCart sc;

        list.add("No.     Title           Price     Qty     Total");
        temp =  "------------------------------------------------";
        list.add(temp);

        Integer a = customer._shoppingCart.size();

        if (a <= 0 )
        {
            list.add(" ----> No items Adden to Cart");
        }
        else
        {

            Double  price;
            Integer qty;
            Double st;
            Double total = 0.0;

            for (int i= 0 ; i<= customer._shoppingCart.size()-1; i++)
            {
                sc = customer._shoppingCart.get(i);
                price = sc.get_productId().get_price();
                qty   = sc.get_quantity();
                st = price * (qty);
                total = total + st;
                temp =  sc.get_cartId().toString() + " - " +
                        sc.get_productId().get_productName() + "     $" +
                        sc.get_productId().get_price().toString() + "     " +
                        sc.get_quantity().toString() + "     $" +
                        st.toString()
                        ;
                list.add(temp);


            }

            temp =  "------------------------------------------------";
            list.add(temp);

            temp =  "Total Items : " + customer._shoppingCart.size();
            list.add(temp);

            temp =  "Total Cost  : $" + total;
            list.add(temp);
        }








        adapter = new OrdersAdapter(list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);




    }
}
