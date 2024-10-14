package com.ph.edu.usc.exercise3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExamViewHolder extends RecyclerView.ViewHolder {

    TextView examTitle, examDate, examMessage;
    ImageView imgIcon1, imgIcon2;
    View view;

    public ExamViewHolder(@NonNull View itemView) {
        super(itemView);
        examTitle = itemView.findViewById(R.id.txtterm);
        examDate = itemView.findViewById(R.id.txtdate);
        examMessage = itemView.findViewById(R.id.txtcomment);
        imgIcon1 = itemView.findViewById(R.id.imgsched);
        imgIcon2 = itemView.findViewById(R.id.imgcomment);
        view = itemView;

    }
}
