package com.example.testsqlite;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    public static final String CLASS_ADD_DIALOG = "addClass";
    private OnClickListener listener;

    public OnClickListener getListener() {
        return listener;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        public void onClick(String text1, String text2);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = null;
        if (getTag().equals(CLASS_ADD_DIALOG)) {

            dialog = getAddDialog();
        }


        return dialog;
    }

    private Dialog getAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.show_dialog, null);
        builder.setView(view);
//        AlertDialog dialog = builder.create();
//        dialog.show();

        TextView titleDialog = view.findViewById(R.id.titleDialog);
        titleDialog.setText("Add Class");
        Button add = view.findViewById(R.id.btn_add);
        Button cancel = view.findViewById(R.id.btn_cancel);

        EditText edt01 = view.findViewById(R.id.edt01);
        EditText edt02 = view.findViewById(R.id.edt02);
        edt01.setHint("Class Name");
        edt02.setHint("Subject Name");



//        cancel.setOnClickListener(v-> dialog.dismiss());
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        add.setOnClickListener(v -> {
            String className = edt01.getText().toString();
            String subjectName = edt02.getText().toString();
            listener.onClick(className,subjectName);
            dismiss();
        });
        return builder.create();
    }




}
