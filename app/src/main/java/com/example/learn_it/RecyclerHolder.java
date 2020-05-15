package com.example.learn_it;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final TextView title;
    final TextView description;
    final ImageView image;
    private ClickListener clickListener;

    RecyclerHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.card_title);
        description = itemView.findViewById(R.id.card_desc);
        image = itemView.findViewById(R.id.card_image);

        itemView.setOnClickListener(this);
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        clickListener.onClick(v, getLayoutPosition());
    }
}