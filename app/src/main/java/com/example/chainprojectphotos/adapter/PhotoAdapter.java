package com.example.chainprojectphotos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chainprojectphotos.R;
import com.example.chainprojectphotos.models.Photos;

import java.util.Vector;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private Vector<Photos> listPhotos;

    public PhotoAdapter(Vector<Photos>listPhotos) {
        this.listPhotos = listPhotos;


    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
       return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PhotoAdapter.ViewHolder holder, int position) {

        holder.title.setText(listPhotos.get(position).getTitle());
        holder.description.setText(listPhotos.get(position).getDescription());
        holder.imageView.setImageResource(listPhotos.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listPhotos.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hellstat);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvTitleDesc);
        }
    }
}
