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

    RecyclerAdapter(List<DataModel> list) {
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

                int pageNo = 1;

                switch (position) {
                    case 0:
                        pageNo = 1;
                        break;
                    case 1:
                        pageNo = 10;
                        break;
                    case 2:
                        pageNo = 17;
                        break;
                    case 3:
                        pageNo = 24;
                        break;
                    case 4:
                        pageNo = 29;
                        break;
                    case 5:
                        pageNo = 36;
                        break;
                }

                intent.putExtra("PAGE_NO", pageNo);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}