package com.example.besocial;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ImagePickerActivity extends AppCompatActivity {
    private RecyclerView rcvImages;

    private int avtarIds[] = {
            R.drawable.default_avtar,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
    };
    private ImagePickerAdapter imagePickerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);
        inItUI();

    }

    private void inItUI() {
        rcvImages = findViewById(R.id.rcvImages);
        rcvImages.setLayoutManager(new GridLayoutManager(this, 3));
        imagePickerAdapter = new ImagePickerAdapter(avtarIds);
        imagePickerAdapter.setOnPostImageClickListener(
                new MysetOnImageCLickListener()
        );
        rcvImages.setAdapter(imagePickerAdapter);

    }
//listener for image click
    private class MysetOnImageCLickListener implements ImagePickerAdapter.OnPostImageClickListener {
        @Override
        public void onPostImageClick(int imageId, int position) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(Constants.KEY_IMAGE_ID, imageId);
            setResult(1, resultIntent);
            finish();
        }
    }
}
