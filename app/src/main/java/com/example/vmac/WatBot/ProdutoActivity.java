package com.example.vmac.WatBot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdutoActivity extends AppCompatActivity {

    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Intent it = getIntent();
        Bundle param = it.getExtras();
        String entrada = param.getString("produto");

        img = (ImageView) findViewById(R.id.img_produto);
        txt = (TextView) findViewById(R.id.txt_produto);

        if(entrada.equals("naturalle")) img.setImageResource(R.drawable.naturalle);
        if(entrada.equals("achocolatado")) img.setImageResource(R.drawable.achocolatado);
        if(entrada.equals("kids")) img.setImageResource(R.drawable.kids);
        if(entrada.equals("chocolade")) img.setImageResource(R.drawable.chocolade);


    }
}
