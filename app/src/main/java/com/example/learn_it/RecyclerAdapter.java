package com.example.learn_it;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private final List<DataModel> list;

    public RecyclerAdapter(List<DataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
        holder.image.setImageResource(list.get(position).getImageId());

        holder.setClickListener(new RecyclerHolder.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(view.getContext(), SlideActivity.class);

                if (position == 0) {
                    intent.putExtra("PAGE_NO", 1);
                } else if (position == 1) {
                    intent.putExtra("PAGE_NO", 10);
                } else if (position == 2) {
                    intent.putExtra("PAGE_NO", 17);
                } else if (position == 3) {
                    intent.putExtra("PAGE_NO", 24);
                } else if (position == 4) {
                    intent.putExtra("PAGE_NO", 29);
                } else if (position == 5) {
                    intent.putExtra("PAGE_NO", 36);
                }

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}