package com.example.vmac.WatBot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ConsumidorActivity extends AppCompatActivity {


    LinearLayout chatbot, codebar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumidor);


        codebar = (LinearLayout) findViewById(R.id.btn_codebar);
        chatbot = (LinearLayout) findViewById(R.id.btn_chatbot);


        codebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ConsumidorActivity.this, BarCodeActivity.class));

            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ConsumidorActivity.this, MainActivity.class));

            }
        });






    }
}
