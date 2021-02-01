package com.example.td1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText edit_nom;
    private EditText edit_prenom;
    private EditText edit_age;
    private EditText edit_competence;
    private EditText edit_tel;
    private Button goButton;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.activity_main_txt);
        edit_nom = (EditText) findViewById(R.id.edit_nom);
        edit_prenom = (EditText) findViewById(R.id.edit_prenom);
        edit_age = (EditText) findViewById(R.id.edit_age);
        edit_competence = (EditText) findViewById(R.id.edit_competence);
        edit_tel = (EditText) findViewById(R.id.edit_tel);
        goButton = (Button) findViewById(R.id.activity_main_button);

        goButton.setEnabled(false);

        // Je configure qu'une obligation sur nom pour l'exemple / des tests
        edit_nom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                goButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(R.string.msg);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // En cas d'acceptation de la pop up
                Intent apresFormulaire = new Intent(MainActivity.this, td1_1.class);

                apresFormulaire.putExtra("NOM",edit_nom.getText().toString());
                apresFormulaire.putExtra("PRENOM",edit_prenom.getText().toString());
                apresFormulaire.putExtra("AGE",edit_age.getText().toString());
                apresFormulaire.putExtra("COMPETENCE",edit_competence.getText().toString());
                apresFormulaire.putExtra("TELEPHONE",edit_tel.getText().toString());

                startActivity(apresFormulaire);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // En cas de refus de la pop up.
            }
        });
        AlertDialog alert = builder.create();

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });
    }
}