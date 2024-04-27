package com.example.carmaintainf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indexpage);

        Button mechanicalButton = findViewById(R.id.button_mechanical);
        Button ownerButton = findViewById(R.id.button_owner);

        mechanicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MecanicalActivity.class);
                startActivity(intent);
            }
        });

        ownerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ownerActivity.class);
                startActivity(intent);
            }
        });
    }
}
