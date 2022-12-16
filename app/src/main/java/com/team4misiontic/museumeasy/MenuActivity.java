package com.team4misiontic.museumeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void calificar(View view){
        Intent cali = new Intent(MenuActivity.this,CalificarActivity.class);
        startActivity(cali);
    }

    public void mapa(View view){
        Intent map = new Intent(MenuActivity.this,MapaActivity.class);
        startActivity(map);
    }
    public void galeria(View view){
        Intent gale = new Intent(MenuActivity.this,GaleriaActivity.class);
        startActivity(gale);
    }

}