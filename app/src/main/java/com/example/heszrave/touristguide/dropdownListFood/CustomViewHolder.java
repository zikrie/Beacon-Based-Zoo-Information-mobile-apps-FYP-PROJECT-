package com.example.heszrave.touristguide.dropdownListFood;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heszrave.touristguide.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    TextView foodNameTextView;
    TextView foodPriceTextView;
    TextView foodDetailsTextView;
    ImageView foodImageView;
    ImageView favoriteIcon;

    public CustomViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardView);
        foodNameTextView = itemView.findViewById(R.id.nameTextView);
        foodPriceTextView = itemView.findViewById(R.id.priceTextView);
        foodDetailsTextView = itemView.findViewById(R.id.detailsTextView);
        foodImageView = itemView.findViewById(R.id.imageView);
        favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
    }
}