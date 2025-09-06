package br.com.etecia.myapp;

public class Produto {
    private String titulo;
    private String descricao;
    private int imgProduto;

    public Produto(String titulo, String descricao, int imgProduto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imgProduto = imgProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImgProduto() {
        return imgProduto;
    }
}
