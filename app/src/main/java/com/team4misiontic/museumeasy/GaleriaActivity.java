package com.team4misiontic.museumeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.core.view.View;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class GaleriaActivity extends AppCompatActivity {
    EasySlider easySlider;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        easySlider =findViewById(R.id.sliderId);

        List<SliderItem> easySliders =new ArrayList<>();

        easySliders.add(new SliderItem("Acuario",R.drawable.acuario));
        easySliders.add(new SliderItem("Vivario",R.drawable.vivario));
        easySliders.add(new SliderItem("Pez Payaso",R.drawable.acua));
        easySliders.add(new SliderItem("Pez Globo",R.drawable.acua2));
        easySliders.add(new SliderItem("Pirarucú",R.drawable.acua3));
        easySliders.add(new SliderItem("Piraña",R.drawable.qacua));
        
        easySlider.setPages(easySliders);
    }

    public void regresarGaleria (View view){
        Intent reg = new Intent(GaleriaActivity.this,MenuActivity.class);
        startActivity(reg);
    }
}