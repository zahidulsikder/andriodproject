package com.example.testsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floating_add_btn;
     RecyclerView recyclerView;
     RecyclerView.LayoutManager layoutManager;
     ClassAdapter classAdapter;
     ArrayList<ClassItem> classItems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floating_add_btn = findViewById(R.id.floating_add_btn);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        classAdapter=new ClassAdapter(classItems, this);
        recyclerView.setAdapter(classAdapter);

        floating_add_btn.setOnClickListener(v -> showDialog());


    }

    private void showDialog() {

        MyDialog dialog= new MyDialog();
        dialog.show(getSupportFragmentManager(),MyDialog.CLASS_ADD_DIALOG);
        dialog.setListener((className, subjectName)->addClass(className,subjectName));

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View view = LayoutInflater.from(this).inflate(R.layout.show_dialog, null);
//        builder.setView(view);
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//        Button add = view.findViewById(R.id.btn_add);
//        Button cancel = view.findViewById(R.id.btn_cancel);
//
//        edt_className=view.findViewById(R.id.edt_className);
//        edt_subjectName=view.findViewById(R.id.edt_subjectName);
//
//
////        cancel.setOnClickListener(v-> dialog.dismiss());
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        add.setOnClickListener(v -> {
//            addClass();
//            dialog.dismiss();
//        });

    }

    private void addClass(String className,String subjectName) {


        classItems.add(new ClassItem(className, subjectName));
        classAdapter.notifyDataSetChanged();

    }


}