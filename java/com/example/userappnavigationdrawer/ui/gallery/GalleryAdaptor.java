package com.example.userappnavigationdrawer.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.userappnavigationdrawer.R;

import java.util.List;

public class GalleryAdaptor extends RecyclerView.Adapter<GalleryAdaptor.GalleryViewAdaptor> {
    private Context context;
    private List<String> images;

    public GalleryAdaptor(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViewAdaptor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);
        return new GalleryViewAdaptor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdaptor holder, int position) {
        Glide.with(context).load(images.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewAdaptor extends RecyclerView.ViewHolder {
        ImageView imageView;
        public GalleryViewAdaptor(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
