package com.example.besocial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnaddPost;
    private ArrayList<UserDetails> userDetailsList;
    private RecyclerView rcvUserDetails;
    private UserDetailsAdapter userDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnaddPost.setOnClickListener(new btnAddPostListener());
    }

    private void initUI() {
        btnaddPost = findViewById(R.id.btnAddPost);
       //setting up the recycler view
        rcvUserDetails = findViewById(R.id.rcvUSerDetails);
        rcvUserDetails.setLayoutManager(
                new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL
                )
        );

        userDetailsList = new ArrayList<UserDetails>();

        userDetailsAdapter = new UserDetailsAdapter(userDetailsList);
        rcvUserDetails.setAdapter(userDetailsAdapter);
        userDetailsAdapter.setOnClickListener(new MyAdapetrClickeListner());
    }

    private class btnAddPostListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AddPostActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            UserDetails newProduct = (UserDetails) data.getSerializableExtra(Constants.KEY_NEW_AVTAR);
            userDetailsList.add(newProduct);
            userDetailsAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private class MyAdapetrClickeListner implements UserDetailsAdapter.OnClickListener {
        @Override
        public void onLayutClicked(UserDetails userDetails, int position) {
            Intent intent=new Intent(MainActivity.this,PostDetailedActivity.class);
            intent.putExtra(UserDetails.KEY_USER_DETAILS,userDetails);
            startActivity(intent);

        }
    }


}