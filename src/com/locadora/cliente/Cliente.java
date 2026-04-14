package com.locadora.cliente;

public class Cliente {
    private String nome;
    private final String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Cnh cnh;

    public Cliente(String nome, String cpf, String telefone, String email, Endereco endereco, Cnh cnh) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Cnh getCnh() {
        return cnh;
    }

   public String getTudo() {
        return "nome: " + this.getNome() + "\ncpf: " + this.getCpf() + "\ntelefone: " + this.getTelefone() + "\nemail: " + this.getEmail() + "\nendereço: " + this.getEndereco() + "\ncnh: " + this.getCnh() ;
   }

    @Override
    public String toString() {
        return getTudo();
    }
}
