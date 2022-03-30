package com.ebookfrenzy.uifyp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ebookfrenzy.uifyp.R;
import com.ebookfrenzy.uifyp.model.FeaturedProduct;

import java.util.List;


public class FeaturedProductAdapter extends RecyclerView.Adapter<FeaturedProductAdapter.FeaturedProductViewHolder> {

    Context context;
    List<FeaturedProduct> featuredProductsList;

    public FeaturedProductAdapter(Context context, List<FeaturedProduct> featuredProductsList){
        this.context = context;
        this.featuredProductsList = featuredProductsList;
    }

    @NonNull
    @Override
    public FeaturedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.featured_row_items,parent, false);
        return new FeaturedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedProductViewHolder holder, int position){
        holder.featuredImageView.setImageResource(featuredProductsList.get(position).getImageurl());
    }

    @Override
    public int getItemCount(){
        return featuredProductsList.size();
    }

    public static class FeaturedProductViewHolder extends RecyclerView.ViewHolder{
        ImageView featuredImageView;

        public FeaturedProductViewHolder(@NonNull View itemView){
            super(itemView);

            featuredImageView = itemView.findViewById(R.id.featureImage);
        }
    }


}
