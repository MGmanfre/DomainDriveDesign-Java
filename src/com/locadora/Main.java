package com.locadora;

import com.locadora.locacao.Locacao;
import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Veiculo setCarro(String nome, double preco, String cambio, String placa, String cor, CategoriaVeiculo.Categorias setCategoria, boolean status) {
        Veiculo novoAluguel = new Veiculo(nome,preco,cambio,placa,cor,setCategoria, status);
        return novoAluguel;
    }

    public static void main(String[] args) {
        CategoriaVeiculo.Categorias[] todasCategorias = CategoriaVeiculo.Categorias.values();
        Veiculo carroTeste = new Veiculo("equinox",230.00,"automatico","koa-4321","prata", todasCategorias[2],false);
        Veiculo carroTeste2 = new Veiculo("fiat argo",130.00,"automatico","kob-4321","prata", todasCategorias[1],false);
        Veiculo carroTeste3 = new Veiculo("fiesta",330.00,"automatico","koc-4321","prata", todasCategorias[0],false);
        Veiculo carroTeste4 = new Veiculo("audi a4",330.00,"automatico","kod-4321","prata", todasCategorias[2],true);
        Veiculo carroTeste5 = new Veiculo("moto foda",330.00,"automatico","koe-4321","prata", todasCategorias[3],false);
        Veiculo carroTeste6 = new Veiculo("van preta para traficantes",330.00,"manual","kof-4321","prata", todasCategorias[4],false);
        Locacao locacaoTeste = new Locacao(LocalDate.of(2025,3,28),LocalDate.of(2025,4,28),LocalDate.of(2025,4,28),carroTeste);

        ArrayList<Veiculo> economico = new ArrayList<>();
        ArrayList<Veiculo> intermediario = new ArrayList<>();
        ArrayList<Veiculo> executivo = new ArrayList<>();
        ArrayList<Veiculo> moto = new ArrayList<>();
        ArrayList<Veiculo> van = new ArrayList<>();

        ArrayList<Veiculo> todos = new ArrayList<>();
        ArrayList<ArrayList<Veiculo>> todosOsveiculos = new ArrayList<>();

        todos.add(carroTeste);
        todos.add(carroTeste2);
        todos.add(carroTeste3);
        todos.add(carroTeste4);
        todos.add(carroTeste5);
        todos.add(carroTeste6);

        for (Veiculo v : todos) {
            switch (v.getCategoria()) {
                case ECONOMICO:
                    economico.add(v);
                    break;
                case INTERMEDIARIO:
                    intermediario.add(v);
                    break;
                case EXECUTIVO:
                    executivo.add(v);
                    break;
                case MOTO:
                    moto.add(v);
                    break;
                case VAN:
                    van.add(v);
                    break;
            }
        }

        todosOsveiculos.add(economico);
        todosOsveiculos.add(intermediario);
        todosOsveiculos.add(executivo);
        todosOsveiculos.add(moto);
        todosOsveiculos.add(van);


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
            for (Veiculo v : todosOsveiculos.get(categoriaAluguel - 1)) {
                if (v.getNome().equals(nomeAluguel)) {
                    if(v.getStatus()) {
                        System.out.println("infelizmente esse carro ja esta alugado! ate a proxima!");
                    }
                    else {
                        v.setStatus(true);
                        System.out.println("carro alugado: " + v.getNome());
                        break;
                    }
                }
            }
            System.out.println("de uma olhada no nosso catalogo!");
            System.out.println(todosOsveiculos);
            break;
        }
        System.out.println();
    }

}
