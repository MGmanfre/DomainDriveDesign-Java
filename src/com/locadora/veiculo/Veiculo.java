package com.locadora.veiculo;

public class Veiculo {
    private String nome;
    private double precoDiaria;
    private String cambio;
    private final String placa;
    private String cor;
    private CategoriaVeiculo.Categorias categoria;
    private boolean status;

    public Veiculo(String nome, double preco, String cambio, String placa, String cor, CategoriaVeiculo.Categorias categoria, boolean status) {
        this.nome = nome;
        this.precoDiaria = preco;
        this.cambio = cambio;
        this.placa = placa;
        this.cor = cor;
        this.categoria = categoria;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public String getCambio() {
        return cambio;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public CategoriaVeiculo.Categorias getCategoria() {
        return categoria;
    }

    public boolean getStatus() {
        return status;
    }

    public String isStatus() {
        if (status == true) {
            String S = "carro já esta alugado";
            return S;
        }
        else {
            String S = "carro disponivel";
            return S ;
        }
    }
    public String getTudo() {
        return (nome + " "+ precoDiaria +" "+  cambio +" "+  placa +" "+  cor +" "+  categoria +" "+ isStatus());
    }

    @Override
    public String toString() {
        return this.getTudo() + "\n";
    }
}
