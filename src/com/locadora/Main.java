package com.locadora;

import com.locadora.cliente.Cliente;
import com.locadora.cliente.Cnh;
import com.locadora.cliente.Endereco;
import com.locadora.locacao.Alugueis_antigos;
import com.locadora.locacao.Locacao;
import com.locadora.veiculo.CategoriaVeiculo;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // guarda os alugueis antigos por carro alugado e por quem alugou
    public static Alugueis_antigos setCarro(String nome, double preco, String cambio, String placa, String cor, CategoriaVeiculo.Categorias setCategoria, boolean status, String cpf) {
        Veiculo veiculo = new Veiculo(nome,preco,cambio,placa,cor,setCategoria, status);
        Alugueis_antigos novoAluguel = new Alugueis_antigos(veiculo,cpf);

        return novoAluguel;
    }

    public static void main(String[] args) {
        CategoriaVeiculo.Categorias[] todasCategorias = CategoriaVeiculo.Categorias.values();
        // nós adicionamos algumas entidades para simular um select do banco de dadosd
        Veiculo carroTeste = new Veiculo("equinox",200.00,"automatico","koa-4321","prata", todasCategorias[2],false);
        Veiculo carroTeste2 = new Veiculo("fiat argo",120.00,"automatico","kob-4321","prata", todasCategorias[1],false);
        Veiculo carroTeste3 = new Veiculo("fiesta",80.00,"automatico","koc-4321","prata", todasCategorias[0],false);
        Veiculo carroTeste4 = new Veiculo("audi a4",200.00,"automatico","kod-4321","prata", todasCategorias[2],true);
        Veiculo carroTeste5 = new Veiculo("moto foda",50.00,"automatico","koe-4321","prata", todasCategorias[3],false);
        Veiculo carroTeste6 = new Veiculo("van preta ",180.00,"manual","kof-4321","prata", todasCategorias[4],false);
        Endereco enderecoClienteTeste1 = new Endereco("rua vivo fibras cardosos","4123","santo antonio do pinhal"," paraisopolis","451191345");
        Cnh cnhClienteTeste1 = new Cnh("59346135086",LocalDate.of(2028,12,14));
        Cliente clienteTeste1 = new Cliente("vitor","11122233344","11999999999","vitorpallis@gmail.com",enderecoClienteTeste1,cnhClienteTeste1);

        // lista de categorias, clientes e veiculos
        ArrayList<Veiculo> economico = new ArrayList<>();
        ArrayList<Veiculo> intermediario = new ArrayList<>();
        ArrayList<Veiculo> executivo = new ArrayList<>();
        ArrayList<Veiculo> moto = new ArrayList<>();
        ArrayList<Veiculo> van = new ArrayList<>();

        ArrayList<Cliente> clientesDB = new ArrayList<>();
        clientesDB.add(clienteTeste1);

        ArrayList<Veiculo> todos = new ArrayList<>();
        ArrayList<ArrayList<Veiculo>> todosOsveiculos = new ArrayList<>();

        ArrayList<Veiculo> carrosAlugados= new ArrayList<>();

        // mostra todos os carros, aqui ainda precisam ser categorizados
        todos.add(carroTeste);
        todos.add(carroTeste2);
        todos.add(carroTeste3);
        todos.add(carroTeste4);
        todos.add(carroTeste5);
        todos.add(carroTeste6);

        for (Veiculo v : todos) {
            // defini qual categoria é cada carro
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

        // adiciona todas as categorias ao catalogo
        todosOsveiculos.add(economico);
        todosOsveiculos.add(intermediario);
        todosOsveiculos.add(executivo);
        todosOsveiculos.add(moto);
        todosOsveiculos.add(van);


        while (true){
            System.out.println("bem vindo a locadora do seu carlos!");

            System.out.println("digte seu cpf: ");
            Scanner cpfverificacao = new Scanner(System.in);
            String login = cpfverificacao.nextLine();
            for (Cliente c : clientesDB) {
                if(c.getCpf().equals(login)) {
                    if (clientesDB.contains(c)) {
                         // se o cliente ja tiver um cadastro ele vai direto para o menu de categorias
                        continue;
                    }
                }
                else{
                    // pega as informações do cliente nececssarias para o cadastro
                    System.out.println("não achamos registros seus, teremos que fazer um login.");

                    System.out.println("digte a rua da sua casa: ");
                    Scanner novaRua = new Scanner(System.in);
                    String setRua = novaRua.nextLine();
                    System.out.println("digte o numero da sua casa: ");
                    Scanner novoNumero = new Scanner(System.in);
                    String setNumero = novoNumero.nextLine();
                    System.out.println("digte o bairro onde mora: ");
                    Scanner novoBairro = new Scanner(System.in);
                    String setBairro = novoBairro.nextLine();
                    System.out.println("digte a cidade onde mora: ");
                    Scanner novaCidade = new Scanner(System.in);
                    String setCidade = novaCidade.nextLine();
                    System.out.println("digte seu cep: ");
                    Scanner novoCep = new Scanner(System.in);
                    String setCep = novoCep.nextLine();
                    Endereco novoEndereco = new Endereco(setRua,setNumero,setBairro,setCidade,setCep);

                    System.out.println("digte seu numero da cnh: ");
                    Scanner novoNumeroCnh = new Scanner(System.in);
                    String setcnh = novoNumeroCnh.nextLine();
                    System.out.println("digte a validade da sua cnh(AAAA-MM-DD): ");
                    Scanner novaValidade = new Scanner(System.in);
                    String setValidade = novaValidade.nextLine();
                    if (LocalDate.parse(setValidade).isBefore(LocalDate.now())) {
                        System.out.println("a sua CNH esta vencida tente novamente mais tarde!");
                        break;
                    }
                    Cnh novaCnh = new Cnh(setcnh,LocalDate.parse(setValidade));


                    System.out.println("digte seu nome: ");
                    Scanner novoNome = new Scanner(System.in);
                    String setNome = novoNome.nextLine();
                    System.out.println("digte seu cpf: ");
                    Scanner novoCpf = new Scanner(System.in);
                    String setCpf = novoCpf.nextLine();
                    System.out.println("digte seu telefone: ");
                    Scanner novoTelefone = new Scanner(System.in);
                    String setTelefone = novoTelefone.nextLine();
                    System.out.println("digte seu email: ");
                    Scanner novoEmail = new Scanner(System.in);
                    String setEmail = novoEmail.nextLine();
                    Cliente novoCliente = new Cliente(setNome,setCpf,setTelefone,setEmail,novoEndereco,novaCnh);
                    System.out.println(novoCliente);

                    // a chave de entrada vira o cpf do cliente, ja que o cpf é a chave primaria
                    login = setCpf;
                }
            }

            // mostra todas as categorias diferentes
            System.out.println("categorias: ");
            for(int i = 0; i < todasCategorias.length; i++) {
                if (i >= 3 ) {
                    System.out.println(todasCategorias[i] +" para alugar essa categoria digite: " + (i+1));
                }
                else {
                    System.out.println("carro " + todasCategorias[i] +" para alugar essa categoria digite: " + (i+1));
                }
            }

            // permite que o cliente escolha a categoria que gostaria de alugar
            System.out.println("qual categoria você gostaria de alugar?");
            Scanner inputCategoria = new Scanner(System.in);
            int categoriaAluguel = inputCategoria.nextInt();
            String setCategoria = String.format("%s", todasCategorias[categoriaAluguel - 1]);

            // analiza qual categoria foi selecionada
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

            // mostra quais carros disponiveis de acordo com a categoria que o proprio selecionou
            System.out.println("qual o nome do carro vc vai querer alugar? (se não quiser alugar nenhum digite: sair)");
            Scanner inputNome = new Scanner(System.in);
            String nomeAluguel = inputNome.nextLine().toLowerCase(Locale.ROOT).trim();
            // se o cliente não quiser alugar nenhum carro ele tem a opção de sair
            if (nomeAluguel.equals("sair") ) {
                System.out.println("ok ate logo!");
                break;
            }
            // esse for define as datas e verifica se o carro esta apto para aluguel
            for (Veiculo v : todosOsveiculos.get(categoriaAluguel - 1)) {
                if (v.getNome().trim().equals(nomeAluguel)) {
                    if(v.getStatus()) {
                        // se jã estiver alugado ele não efetua a compra
                        System.out.println("infelizmente esse carro ja esta alugado! ate a proxima!");
                        break;
                    }
                    else {
                        // se o carro não estiver alugado ele efetua o aluguel
                        v.setStatus(true);
                        System.out.println("carro alugado!");
                    }
                    // defini a data de entrega e a data de devolução do carro
                    System.out.println("digite a data de retirada(AAAA-MM-DD): ");
                    Scanner dataRetirada = new Scanner(System.in);
                    String retirada = dataRetirada.nextLine();

                    System.out.println("digite a data de entrega(AAAA-MM-DD): ");
                    Scanner dataentrega = new Scanner(System.in);
                    String entrega = dataentrega.nextLine();

                    // calcula o preço de acordo com a data
                    Locacao datasCarro = new Locacao(LocalDate.parse(retirada),LocalDate.parse(entrega),LocalDate.parse(entrega),v);
                    System.out.println(datasCarro);

                    System.out.println("carro alugado: " + v.getNome() + "\nplaca do carro: " + v.getPlaca());

                    // defini qual carro foi alugado e imprime na tela
                    setCarro(v.getNome(),datasCarro.total_a_pagar(), v.getCambio(), v.getPlaca(),v.getCor(),v.getCategoria(),v.getStatus(),login);
                    System.out.println(setCarro(v.getNome(),datasCarro.total_a_pagar(), v.getCambio(), v.getPlaca(),v.getCor(),v.getCategoria(),v.getStatus(),login));
                    break;
                }
                else {
                    // essa mensagem aparece se o cliente digitar algum carro que não tenhamos no catalogo
                    System.out.println("não encontramos o carro que vc gostaria de alugar, tente escrever o nome parecido com o do catalogo.");
                }

            }

            // mostra o catalogo
            System.out.println("de uma olhada no nosso catalogo!");
            System.out.println(todosOsveiculos);
            break;
        }
    }

}
