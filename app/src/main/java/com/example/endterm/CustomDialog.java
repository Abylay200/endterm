package com.example.endterm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog {

    private String title;
    private String message;

    public CustomDialog(Context context) {
        super(context);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnOk = findViewById(R.id.btnOk);

        tvTitle.setText(title);
        tvMessage.setText(message);

        btnOk.setOnClickListener(v -> dismiss());
    }
}
