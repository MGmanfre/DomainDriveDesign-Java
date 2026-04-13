package com.locadora;

import com.locadora.locacao.Locacao;
import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Veiculo setCarro(String nome, double preco, String cambio, String placa, String cor, String setCategoria, boolean status) {
        Veiculo novoAluguel = new Veiculo(nome,preco,cambio,placa,cor,setCategoria, status);
        return novoAluguel;
    }

    public static void main(String[] args) {
        CategoriaVeiculo.Categorias carroExecutivo = CategoriaVeiculo.Categorias.EXECUTIVO;
        CategoriaVeiculo.Categorias[] todasCategorias = CategoriaVeiculo.Categorias.values();
        String categoria = String.format("%s", carroExecutivo);
        Veiculo carroTeste = new Veiculo("equinox",230.00,"automatico","koa-4321","prata", categoria,false);
        Veiculo carroTeste2 = new Veiculo("fiat argo",130.00,"automatico","kob-4321","prata", categoria,false);
        Veiculo carroTeste3 = new Veiculo("fiesta",330.00,"automatico","koc-4321","prata", categoria,false);
        Locacao locacaoTeste = new Locacao(LocalDate.of(2025,3,28),LocalDate.of(2025,4,28),LocalDate.of(2025,4,28),carroTeste);

        ArrayList<Veiculo> economico = new ArrayList<>();
        ArrayList<Veiculo> intermediario = new ArrayList<>();
        ArrayList<Veiculo> executivo = new ArrayList<>();
        ArrayList<Veiculo> moto = new ArrayList<>();
        ArrayList<Veiculo> van = new ArrayList<>();

        executivo.add(carroTeste);
        executivo.add(carroTeste2);
        executivo.add(carroTeste3);

        while (true){
            System.out.println("bem vindo a locadora do seu carlos!");

            System.out.println("categorias: ");
            for(int i = 0; i < todasCategorias.length; i++) {
                if (i >= 3 ) {
                    System.out.println(todasCategorias[i] +" para alugar essa categoria digite: " + (i+1));
                }
                else {
                    System.out.println("carro " + todasCategorias[i] +" para alugar essa categoria digite: " + (i+1));
                }
            }

            System.out.println("qual categoria você gostaria de alugar?");
            Scanner inputCategoria = new Scanner(System.in);
            int categoriaAluguel = inputCategoria.nextInt();
            String setCategoria = String.format("%s", todasCategorias[categoriaAluguel - 1]);

            System.out.println("todos os automoveis disponiveis da categoria: " + setCategoria);
            if (categoriaAluguel == 1) {
                System.out.println(economico);
            }
            else if (categoriaAluguel == 2) {
                System.out.println(intermediario);
            }
            else if (categoriaAluguel == 3) {
                System.out.println(executivo);
            }
            else if (categoriaAluguel == 4) {
                System.out.println(moto);
            }
            else if (categoriaAluguel == 5) {
                System.out.println(van);
            }

            System.out.println("qual o nome do carro vc vai querer alugar? (se não quiser alugar nenhum digite: sair)");
            Scanner inputNome = new Scanner(System.in);
            String nomeAluguel = inputNome.nextLine().toLowerCase(Locale.ROOT).trim();
            if (nomeAluguel.equals("sair") ) {
                System.out.println("ok ate logo!");
                break;
            }

            // setCarro();

            break;
        }
        System.out.println();
    }

}
