package com.example.vmac.WatBot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DirectActivity extends AppCompatActivity {


    ImageButton consumidor, produtor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);


        consumidor = (ImageButton) findViewById(R.id.btn_consumidor);
        produtor = (ImageButton) findViewById(R.id.btn_produtor);


        consumidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DirectActivity.this, ConsumidorActivity.class));

            }
        });

        produtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DirectActivity.this, ProdutorActivity.class));

            }
        });



    }
}
