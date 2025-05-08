package com.example.a10pplg2_api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        Button Primer = findViewById(R.id.btnPrimer);
        Button LaManchaland = findViewById(R.id.btnLaManchaland);

        Intent primer = new Intent(this, PremiereRecycle.class);
        Intent lamanchaland = new Intent(this, LaManchalandRecycler.class);

        Primer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(primer);
            }
        });

        LaManchaland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lamanchaland);
            }
        });

    }
}