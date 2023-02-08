package com.example.testsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {
    ArrayList<ClassItem> classItems;
    Context context;

    public ClassAdapter(ArrayList<ClassItem> classItems, Context context) {
        this.classItems = classItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);

        return new ClassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {

        holder.className.setText(classItems.get(position).getClassName());
        holder.subjectName.setText(classItems.get(position).getSubjectName());

    }

    @Override
    public int getItemCount() {

        return classItems.size();

    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {

        TextView className, subjectName;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.tv_className);
            subjectName = itemView.findViewById(R.id.tv_subjectName);

        }
    }

}
