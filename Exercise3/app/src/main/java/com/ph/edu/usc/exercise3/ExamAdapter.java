package com.ph.edu.usc.exercise3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamViewHolder> {

    List<ExamModel> list = Collections.emptyList();
    Context context;
    ClickListener clickListener;

    public ExamAdapter(List<ExamModel> list, Context context, ClickListener clickListener) {
        this.list = list;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context1);
        View photoView = inflater.inflate(R.layout.card_layout, parent, false);
        ExamViewHolder viewHolder = new ExamViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        //final index = holder.getAdapterPosition();
        holder.examTitle.setText(list.get(position).getName());
        holder.getAdapterPosition();
        holder.examDate.setText(list.get(position).getDate());
        holder.getAdapterPosition();
        holder.examMessage.setText(list.get(position).getMessage());
        holder.getAdapterPosition();

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clickListener.click(index);
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
