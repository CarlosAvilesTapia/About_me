package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.aboutme.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    // Creación de la clase tipo Binding para generar instancias.
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creación de instancia binding para ser utilizada en esta activity.
        binding = ActivitySecondBinding.inflate(getLayoutInflater());

        // Llamado al método para genetat la vista usando view binding.
        setContentView(binding.getRoot());

        // Llamado al método para inicializar botones
        initListeners();

    }

    // Creación de método para inicializar botones.
    private void initListeners() {

        // Enlace mediante view binding con botón para ir a URL.
        binding.goToLinkedInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Llamado al método para enviar correo electrónico.
                goToUrl("https://www.linkedin.com/in/son-goku-a1253883/");
            }
        });

        // Enlace mediante view binding con botón para enviar correo electrónico.
        binding.sendMailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Llamado al método para enviar correo electrónico.
                composeEmail(new String[]{"songoku@capsulecorp.com"}, "Holi, que ondi", "GOKUUUUUUU!");
            }
        });

        // Enlace mediante view binding con botón para abrir Whatsapp.
        binding.goToWhatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Llamado al método para enviar correo electrónico.
                openWhatsapp();
            }
        });
    }

    // Creación de método con intent implícito para ir a la URL del perfil.
    public void goToUrl(String address) {
        Intent implicitIntentUrl = new Intent(Intent.ACTION_VIEW,
                Uri.parse(address));
        startActivity(implicitIntentUrl);
    }
    // Creación de método con intent implícito para enviar correo electrónico.
    public void composeEmail(String[] address, String subject, String body) {

        // Creación de una instancia de Intent con acción de enviar correo.
        Intent implicitIntentEmail = new Intent(Intent.ACTION_SENDTO);

        // Se asigna el dato de dirección a una aplicación de correo.
        implicitIntentEmail.setData(Uri.parse("mailto:"));

        // Se asigna el dato de dirección en caso de no haber aplicación.
        implicitIntentEmail.putExtra(Intent.EXTRA_EMAIL, address);

        // Se asigna un asunto al correo que se enviará.
        implicitIntentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);

        // Se asigna un cuerpo al correo que se enviará.
        implicitIntentEmail.putExtra(Intent.EXTRA_TEXT, body);

        // Si existe alguna aplicación para resolver el intent, este se ejecuta.
        startActivity(implicitIntentEmail);
    }

    // Creación de método con intent implícito para enviar mensaje por Whatsapp.
    public void openWhatsapp() {
        String contact = "+819856545896";
        String url = "https://api.whatsapp.com/send?phone="+ contact +"&text= Holi, que ondi";
        Intent implicitIntentWhatsapp = new Intent(Intent.ACTION_VIEW);
        implicitIntentWhatsapp.setData(Uri.parse(url));
        startActivity(implicitIntentWhatsapp);
    }
}
