package com.example.besocial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddPostActivity extends AppCompatActivity {
    private ImageView ivPickImage;
    private EditText edtBio, edtDescription;
    private Button btnAddPost;
    private int pickedImageid = R.drawable.default_avtar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post);
        inITUI();
        setUpLiseneres();
    }

    private void setUpLiseneres() {
        btnAddPost.setOnClickListener(new BtnAddPostCLickListener());
        ivPickImage.setOnClickListener(new BtnIvImagePickListener());

    }

    private void inITUI() {
        ivPickImage = findViewById(R.id.ivProfileImage);
        edtBio = findViewById(R.id.edtEnterBio);
        edtDescription = findViewById(R.id.edtDescription);
        btnAddPost = findViewById(R.id.btnSaveDetails);

    }
//add post button event
    private class BtnAddPostCLickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            UserDetails newlyAddedDetails = new UserDetails(
                    edtBio.getText().toString(),
                    edtDescription.getText().toString(), pickedImageid);
            Intent resultIntent = new Intent();
            resultIntent.putExtra(Constants.KEY_NEW_AVTAR, newlyAddedDetails);
            setResult(1, resultIntent);
            finish();


        }
    }
//add image button event
    private class BtnIvImagePickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AddPostActivity.this, ImagePickerActivity.class);
            startActivityForResult(intent, 1);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            pickedImageid = data.getIntExtra(Constants.KEY_IMAGE_ID, -1);
            ivPickImage.setImageResource(pickedImageid);
        }
    }
}
