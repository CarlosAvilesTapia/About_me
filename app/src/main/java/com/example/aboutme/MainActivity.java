package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}
