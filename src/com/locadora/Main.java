package com.locadora;

import com.locadora.locacao.Locacao;
import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CategoriaVeiculo.Categorias executivo = CategoriaVeiculo.Categorias.EXECUTIVO;
        CategoriaVeiculo.Categorias[] todasCategorias = CategoriaVeiculo.Categorias.values();
        String categoria = String.format("%s", executivo);
        Veiculo carroTeste = new Veiculo("equinox",230.00,"automatico","koa-4321","prata", categoria,false);
        Locacao locacaoTeste = new Locacao(LocalDate.of(2025,3,28),LocalDate.of(2025,4,28),LocalDate.of(2025,4,28),carroTeste);

        while (true){
            System.out.println("bem vindo a locadora do seu carlos!");

            System.out.println("qual categoria você gostaria de alugar?");
            for(int i = 0; i < todasCategorias.length; i++) {
                if (i >= 3 ) {
                    System.out.println(todasCategorias[i] +" aperte: " + (i+1));
                }
                else {
                    System.out.println("carro " + todasCategorias[i] +" aperte: " + (i+1));
                }

            }
            break;
        }

    }
}
