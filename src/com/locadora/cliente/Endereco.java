package com.locadora.cliente;

public class Endereco {
	private final String rua;
	private final String numero;
	private final String bairro;
	private final String cidade;
	private final String cep;

	public Endereco(String rua, String numero, String bairro, String cidade, String cep) {
		this.rua = validarCampo(rua, "rua");
		this.numero = validarCampo(numero, "numero");
		this.bairro = validarCampo(bairro, "bairro");
		this.cidade = validarCampo(cidade, "cidade");
		this.cep = validarCampo(cep, "cep");
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	private String validarCampo(String valor, String campo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException("O campo " + campo + " e obrigatorio.");
		}

		return valor;
	}

	public String getTudo() {
		return "rua: " + this.getRua() + " " + this.getNumero() + "\nbairro: " + this.getBairro() + "\ncidade: " + this.getCidade() + "\ncep: " + this.getCep() ;
	}

	@Override
	public String toString() {
		return getTudo();
	}
}
