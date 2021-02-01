package com.example.td1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class td1_1 extends AppCompatActivity {

    private TextView exo;
    private TextView info;
    private Button ok;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_td1_1);
        exo = (TextView) findViewById(R.id.activity_info);
        info = (TextView) findViewById(R.id.activity_intent_text);
        ok = (Button) findViewById(R.id.activity_ok_button);
        retour = (Button) findViewById(R.id.activity_return_button);

        Intent i = getIntent();
        String nom = i.getStringExtra("NOM");
        String prenom = i.getStringExtra("PRENOM");
        String competence = i.getStringExtra("COMPETENCE");
        String age = i.getStringExtra("AGE");
        String telephone = i.getStringExtra("TELEPHONE");

        info.setText(nom + prenom + "\n" + competence + "\n" + age + "\n" + telephone + "\n");

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent okView = new Intent(td1_1.this, td1_2.class);

                okView.putExtra("TEL",telephone);

                startActivity(okView);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}