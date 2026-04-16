package com.locadora.locacao;

import com.locadora.veiculo.Veiculo;

public class Alugueis_antigos {
    private Veiculo carroDoAluguel;
    private String usuario;

    public Alugueis_antigos(Veiculo carroDoAluguel, String usuario) {
        this.carroDoAluguel = carroDoAluguel;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public Veiculo getCarroDoAluguel() {
        return carroDoAluguel;
    }

    @Override
    public String toString() {
        return "detalhes do carro: " + carroDoAluguel + " alugado por: " + usuario;
    }
}
