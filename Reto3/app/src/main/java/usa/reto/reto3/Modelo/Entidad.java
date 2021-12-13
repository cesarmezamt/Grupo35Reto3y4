package usa.reto.reto3.Modelo;


import android.net.Uri;

import java.util.List;

public class Entidad {

    //int imagen;
    Uri imagen;
    String titulo;
    String descripcion;


    public Entidad(Uri imagen, String titulo, String descripcion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Uri getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
