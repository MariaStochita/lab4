package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitateAdaugare extends AppCompatActivity {

    private EditText etMarca, etAn;
    private Spinner spinnerTransmisie;
    private RadioGroup rgCombustibil;
    private CheckBox cbAsigurare;
    private Switch switchElectric;
    private RatingBar ratingBarStare;
    private Button btnSalvare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_adaugare);

        etMarca = findViewById(R.id.etMarca);
        etAn = findViewById(R.id.etAn);
        spinnerTransmisie = findViewById(R.id.spinnerTransmisie);
        rgCombustibil = findViewById(R.id.rgCombustibil);
        cbAsigurare = findViewById(R.id.cbAsigurare);
        switchElectric = findViewById(R.id.switchElectric);
        ratingBarStare = findViewById(R.id.ratingBarStare);
        btnSalvare = findViewById(R.id.btnSalvare);


        String[] optiuni = {"Manuală", "Automată", "Semi-automată"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, optiuni);
        spinnerTransmisie.setAdapter(adapter);
        spinnerTransmisie.setAdapter(adapter);


        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marca = etMarca.getText().toString().trim();
                String anStr = etAn.getText().toString().trim();

                if (marca.isEmpty() || anStr.isEmpty()) {
                    Toast.makeText(ActivitateAdaugare.this, "Completează toate câmpurile!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int an = Integer.parseInt(anStr);
                boolean esteElectrica = switchElectric.isChecked();
                float rating = ratingBarStare.getRating();

                masina masinaNoua = new masina(marca, an, esteElectrica, rating);

                Intent intentRezultat = new Intent();
                intentRezultat.putExtra("masina_cheie", masinaNoua);
                setResult(RESULT_OK, intentRezultat);
                finish();
            }
        });
    }
}