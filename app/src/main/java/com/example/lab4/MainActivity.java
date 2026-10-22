package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_CODE_ADAUGARE = 1;
    private TextView tvAfisareDate;
    private Button btnDeschideFormular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAfisareDate = findViewById(R.id.tvAfisareDate);
        btnDeschideFormular = findViewById(R.id.btnDeschideFormular);


        btnDeschideFormular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitateAdaugare.class);
                startActivityForResult(intent, REQUEST_CODE_ADAUGARE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADAUGARE && resultCode == RESULT_OK && data != null) {

            masina masinaPrimitiva = (masina) data.getSerializableExtra("masina_cheie");

            if (masinaPrimitiva != null) {

                String info = "Marcă: " + masinaPrimitiva.getMarca() +
                        "\nAn: " + masinaPrimitiva.getAnFabricatie() +
                        "\nElectrică: " + (masinaPrimitiva.isEsteElectrica() ? "Da" : "Nu") +
                        "\nRating: " + masinaPrimitiva.getRating();

                tvAfisareDate.setText(info);
            }
        }
    }
}