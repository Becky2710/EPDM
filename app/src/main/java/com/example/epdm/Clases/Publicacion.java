package com.example.epdm.Clases;

public abstract class Publicacion {
    private int codigoPublicacion;
    private String tituloPublicacion;
    private int anioPublicacion;
    public Publicacion(){
    }
    public Publicacion(int codigoPublicacion, String tituloPublicacion, int anioPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
        this.tituloPublicacion = tituloPublicacion;
        this.anioPublicacion = anioPublicacion;
    }

    public int getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(int codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public abstract int getTipoPublicacion();
}
