package br.com.etecia.myapp;

public class Miniatura {
    private String titulo;
    private String descricao;
    private int imgMiniatura;

    public Miniatura(String titulo, String descricao, int imgMiniatura) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imgMiniatura = imgMiniatura;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImgMiniatura() {
        return imgMiniatura;
    }
}
