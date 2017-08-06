package com.example.vmac.WatBot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProdutorActivity extends AppCompatActivity {

    ImageButton chatbot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtor);


        chatbot = (ImageButton) findViewById(R.id.btn_chatbot_prod);



        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ProdutorActivity.this, ChatbotActivity.class));

            }
        });


    }
}
