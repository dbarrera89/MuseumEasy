package com.team4misiontic.museumeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.team4misiontic.museumeasy.modelo.Calificar;

import java.util.Calendar;
import java.util.Date;

public class CalificarActivity extends AppCompatActivity {
    //Variables del formulario
    private EditText nombreUser;
    private EditText correoUser;
    private RatingBar estrellasUser;
    private EditText sugerenciaUser;
    private CheckBox anonimatoUser;
    //Date fecha = Calendar.getInstance().getTime(); //Obtener la fecha actual
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);

        //Variables leidas del formulario
        nombreUser=findViewById(R.id.txtNombre);
        correoUser=findViewById(R.id.txtEmail);
        estrellasUser=findViewById(R.id.ratingBarCalificar);
        sugerenciaUser=findViewById(R.id.txtSugerencialibre);
        anonimatoUser=findViewById(R.id.checkBoxAnonimato);
        inicializarFirebase();
    }

    //Método para mostrar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Método para el botón regresar
    public void regresarCalificar(View view){
        Intent regHome = new Intent(CalificarActivity.this, MenuActivity.class);
        startActivity(regHome);
    }

    //Método para mostrar algo al presionar los botones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String nombre = nombreUser.getText().toString();
        String correo = correoUser.getText().toString();
        String estrellas = String.valueOf(estrellasUser.getRating());
        String sugerencia = sugerenciaUser.getText().toString();

        CheckBox c1;
        c1 = (CheckBox) findViewById(R.id.checkBoxAnonimato);
        String anonimato = String.valueOf(c1.isChecked());

        String fecha = Calendar.getInstance().getTime().toString(); //Fecha actual

        switch (item.getItemId()){
            case R.id.ic_guardar:
                if(nombre.isEmpty() || correo.isEmpty() || sugerencia.isEmpty()){
                    validacion();
                    Toast.makeText(this,"Complete el formulario",Toast.LENGTH_SHORT).show();
                    break;
                }else{
                    Calificar calificar = new Calificar();
                    calificar.setNombreUser(nombre);
                    calificar.setCorreoUser(correo);
                    calificar.setEstrellasUser(estrellas);
                    calificar.setSugerenciaUser(sugerencia);
                    calificar.setAnonimatoUser(anonimato);
                    calificar.setFechaUser(fecha);
                    databaseReference.child("calificacion").child(calificar.getNombreUser()).setValue(calificar);

                    Toast.makeText(this,"¡Guardado con éxito!",Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                    break;
                }

            /*case R.id.ic_actualizar:
                Toast.makeText(this,"Hizo clic en actualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_borrar:
                Toast.makeText(this,"Hizo clic en borrar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_home:
                Toast.makeText(this,"Hizo clic en home",Toast.LENGTH_SHORT).show();
                break;*/
            default:
                break;
        }
        return true;
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(this, "Inicializando base de datos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarCajas(){
        nombreUser.setText("");
        correoUser.setText("");
        estrellasUser.setRating(0); //Poner a 0 estrellas
        sugerenciaUser.setText("");
        anonimatoUser.setChecked(false); //Quitar el check
    }

    public void validacion(){
        String nombre = nombreUser.getText().toString();
        String correo = correoUser.getText().toString();
        String sugerencia = sugerenciaUser.getText().toString();

        if (nombre.isEmpty()){
            nombreUser.setError("requerido");
        }else if(correo.isEmpty()){
            correoUser.setError("requerido");
        }else if(sugerencia.isEmpty()){
            sugerenciaUser.setError("requerido");
        }
    }
}