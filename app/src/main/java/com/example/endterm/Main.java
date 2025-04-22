package com.example.endterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCart = findViewById(R.id.btnCart);
        Button btnCustomView = findViewById(R.id.btnCustomView);
        Button btnStartService = findViewById(R.id.btnStartService);

        btnCart.setOnClickListener(v -> {
            startActivity(new Intent(Main.this, CartActivity.class));
        });

        btnCustomView.setOnClickListener(v -> {
            showCustomDialog();
        });

        btnStartService.setOnClickListener(v -> {
            startForegroundService(new Intent(Main.this, MyForegroundService.class));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showCustomDialog() {
        CustomDialog dialog = new CustomDialog(this);
        dialog.setTitle("Custom Dialog");
        dialog.setMessage("This is a custom dialog created for Lab03");
        dialog.show();
    }
}