package com.locadora;

import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

public class Main {
    public static void main(String[] args) {
        CategoriaVeiculo.Categorias suv = CategoriaVeiculo.Categorias.EXECUTIVO;
        String categoria = String.format("%s", suv);
        Veiculo equinox = new Veiculo("equinox",230,"automatico","koa-4321","prata", categoria,false);

        System.out.println(equinox.getTudo());

    }
}
