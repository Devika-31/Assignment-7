package com.example.besocial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagePickerAdapter extends RecyclerView.Adapter<ImagePickerAdapter.ImageViewHolder> {
    private int[] avtarIds;
//interface
    public interface OnPostImageClickListener {
        void onPostImageClick(int imageId, int position);
    }

    private OnPostImageClickListener onPostImageClickListener;

    public void setOnPostImageClickListener(OnPostImageClickListener onPostImageClickListener) {
        this.onPostImageClickListener = onPostImageClickListener;
    }

    public ImagePickerAdapter(int[] avtarIds) {
        this.avtarIds = avtarIds;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.avtar_image, null)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.avtarImg.setImageResource(avtarIds[position]);

    }

    @Override
    public int getItemCount() {
        return avtarIds.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView avtarImg;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            avtarImg = (ImageView) itemView;
            avtarImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onPostImageClickListener != null) {
                        onPostImageClickListener.onPostImageClick(
                                avtarIds[getAdapterPosition()],
                                getAdapterPosition()
                        );
                    }
                }
            });
        }
    }

}
