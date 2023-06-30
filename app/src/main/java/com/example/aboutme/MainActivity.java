package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aboutme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Creación de la clase tipo Binding para generar instancias.
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creación de instancia binding para ser utilizada en esta activity.
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Llamado al método para genetat la vista usando view binding.
        setContentView(binding.getRoot());

        // Llamado al método para inicializar botón.
        initListener();
    }

    // Creación de método para dar funcionalidad al botón.
    private void initListener() {

        // Enlace del botón del diseño mediante view binding.
        binding.contactButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Creación de una instancia de la clase Intent de tipo explícito para enlazar con segunda activity.
                Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(explicitIntent);
            }
        });
    }
}
