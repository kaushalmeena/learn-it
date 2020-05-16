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

    RecyclerHolder(View view) {
        super(view);

        View card = view.findViewById((R.id.card_view));

        title = view.findViewById(R.id.card_title);
        description = view.findViewById(R.id.card_desc);
        image = view.findViewById(R.id.card_image);

        card.setOnClickListener(this);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getLayoutPosition());
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }
}