package com.example.besocial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.UserDetailsViewHlder> {
    private ArrayList<UserDetails> userDetailsList;

    public UserDetailsAdapter(ArrayList<UserDetails> usersList) {
        this.userDetailsList = usersList;
    }

    @NonNull
    @Override
    public UserDetailsViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_details_view_item, null);

        UserDetailsViewHlder userDetailsViewHlder = new UserDetailsViewHlder(view);

        return userDetailsViewHlder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserDetailsViewHlder holder, int position) {
        UserDetails userDetails = userDetailsList.get(position);

        holder.avtarUserDetails.setImageResource(userDetails.getAvtarId());
        holder.tvBio.setText(userDetails.getBio());
        holder.tvDescriptio.setText(userDetails.getDescription());
    }

    @Override
    public int getItemCount() {
       return userDetailsList.size();
    }

    public class UserDetailsViewHlder extends RecyclerView.ViewHolder{
        ImageView avtarUserDetails;
        TextView  tvBio,tvDescriptio;

        public UserDetailsViewHlder(@NonNull View itemView) {
            super(itemView);
            avtarUserDetails=itemView.findViewById(R.id.ivAvtarDisplay);
tvBio=itemView.findViewById(R.id.tvBio);
tvDescriptio=itemView.findViewById(R.id.tvDescription);



        }
    }
}
