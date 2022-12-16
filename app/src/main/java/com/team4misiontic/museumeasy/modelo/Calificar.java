package com.team4misiontic.museumeasy.modelo;

//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.RatingBar;

public class Calificar {
    // Variables para la Base de datos
    private String nombreUser;
    private String correoUser;
    //private RatingBar estrellasUser;
    private String estrellasUser;
    private String sugerenciaUser;
    //private CheckBox anonimatoUser;
    private String anonimatoUser;
    private String fechaUser;

    //Constructor vacio
    public Calificar() {
    }

    //Getter and Setter

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getEstrellasUser() {
        return estrellasUser;
    }

    public void setEstrellasUser(String estrellasUser) {
        this.estrellasUser = estrellasUser;
    }

    public String getSugerenciaUser() {
        return sugerenciaUser;
    }

    public void setSugerenciaUser(String sugerenciaUser) {
        this.sugerenciaUser = sugerenciaUser;
    }

    public String getAnonimatoUser() {
        return anonimatoUser;
    }

    public void setAnonimatoUser(String anonimatoUser) {
        this.anonimatoUser = anonimatoUser;
    }

    public String getFechaUser() {
        return fechaUser;
    }

    public void setFechaUser(String fechaUser) {
        this.fechaUser = fechaUser;
    }

    // Método toString
    @Override
    public String toString() {
        return "Calificar{" +
                "nombreUser='" + nombreUser + '\'' +
                ", correoUser='" + correoUser + '\'' +
                ", estrellasUser='" + estrellasUser + '\'' +
                ", sugerenciaUser='" + sugerenciaUser + '\'' +
                ", anonimatoUser='" + anonimatoUser + '\'' +
                ", fechaUser='" + fechaUser + '\'' +
                '}';
    }
}
