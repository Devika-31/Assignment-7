package com.example.besocial;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PostDetailedActivity extends AppCompatActivity {
    private UserDetails userDetails;
    private TextView tvDesc,tvBio;
    private ImageView ivAvtar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDetails = (UserDetails) getIntent().getSerializableExtra(UserDetails.KEY_USER_DETAILS);

        setContentView(R.layout.post_detailed_activity);
        init();
        bindDataToViews();
    }

    private void bindDataToViews() {
        ivAvtar.setImageResource(userDetails.getAvtarId());
        tvBio.setText(userDetails.getBio());
        tvDesc.setText(userDetails.getDescription());

    }

    private void init() {
      tvDesc=findViewById(R.id.tvDescD);
      tvBio=findViewById(R.id.tvBioD);
      ivAvtar=findViewById(R.id.ivAvtarD);


    }
}
