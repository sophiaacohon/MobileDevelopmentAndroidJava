package com.ph.edu.usc.exercise3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<CoursesItem> {
    public CourseAdapter(@NonNull Context context, ArrayList<CoursesItem> courseList) {
        super(context, 0, courseList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner, parent, false);
        }
        TextView txt = convertView.findViewById(R.id.spincustomtxt);
        CoursesItem coursesItem = getItem(position);

        if (coursesItem != null){
            txt.setText(coursesItem.getCoursesName());
        }
        return convertView;
    }
}
