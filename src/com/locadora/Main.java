package com.locadora;

import com.locadora.locacao.Locacao;
import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CategoriaVeiculo.Categorias executivo = CategoriaVeiculo.Categorias.EXECUTIVO;
        String categoria = String.format("%s", executivo);
        Veiculo equinox = new Veiculo("equinox",230.00,"automatico","koa-4321","prata", categoria,false);
        Locacao locacao = new Locacao(LocalDate.of(2025,3,28),LocalDate.of(2025,4,28),LocalDate.of(2025,4,28),equinox);

        System.out.println(equinox.getTudo());

        System.out.println(locacao.getQuantidadeDias());
        System.out.println(locacao.calcularPrecoAluguel());
        System.out.println(locacao.multa());
        System.out.println(locacao.total_a_pagar());

    }
}
