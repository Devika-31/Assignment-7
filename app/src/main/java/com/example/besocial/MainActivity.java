 package com.example.besocial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
private Button btnaddPost;
private ArrayList<UserDetails> userDetailsList;
private RecyclerView rcvUserDetails;
private  UserDetailsAdapter userDetailsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnaddPost.setOnClickListener(new btnAddPostListener());
    }

     private void initUI() {
        btnaddPost=findViewById(R.id.btnAddPost);
         rcvUserDetails = findViewById(R.id.rcvUSerDetails);
         rcvUserDetails.setLayoutManager(
                 new LinearLayoutManager(
                         this,
                         LinearLayoutManager.VERTICAL,
                         false
                 )
         );

         userDetailsList = new ArrayList<UserDetails>();

         userDetailsAdapter = new UserDetailsAdapter(userDetailsList);
         rcvUserDetails.setAdapter(userDetailsAdapter);
     }

     private class btnAddPostListener implements View.OnClickListener {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this, AddPostActivity.class);
             startActivityForResult(intent,1);
         }
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         if(data != null) {
             UserDetails newProduct = (UserDetails) data.getSerializableExtra(Constants.KEY_NEW_AVTAR);
             userDetailsList.add(newProduct);
             userDetailsAdapter.notifyDataSetChanged();
         }
        super.onActivityResult(requestCode, resultCode, data);
     }
 }