package com.team4misiontic.museumeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class MapaActivity extends AppCompatActivity {

    ImageView imageView;
    Matrix matrix=new Matrix();
    Float scale=1f;
    ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        imageView=(ImageView) findViewById(R.id.imageView3);
        SGD=new ScaleGestureDetector(this,new ScaleListener());
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale= scale*detector.getScaleFactor();
            scale= Math.max(0.1f, Math.min(scale,5f));
            matrix.setScale(scale,scale);
            imageView.setImageMatrix(matrix);
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SGD.onTouchEvent(event);
        return true;
    }

    public void regresarMapa (View view){
        Intent reg = new Intent(MapaActivity.this,MenuActivity.class);
        startActivity(reg);
    }
}