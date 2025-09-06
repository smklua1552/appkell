package br.com.etecia.myapp;

public class Acessorio {
    private String titulo;
    private int imgMiniatura;

    public Acessorio(String titulo, int imgMiniatura) {
        this.titulo = titulo;
        this.imgMiniatura = imgMiniatura;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImgMiniatura() {
        return imgMiniatura;
    }
}
