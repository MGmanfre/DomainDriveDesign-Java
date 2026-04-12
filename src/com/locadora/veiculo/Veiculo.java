package com.locadora.veiculo;

public class Veiculo {
    private String nome;
    private double precoDiaria;
    private String cambio;
    private final String placa;
    private String cor;
    private String categoria;
    private boolean status;

    public Veiculo(String nome,double preco, String cambio, String placa, String cor, String categoria,boolean status) {
        this.nome = nome;
        this.precoDiaria = preco;
        this.cambio = cambio;
        this.placa = placa;
        this.cor = cor;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
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
    public String getCategoria() {
        return categoria;
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
}
