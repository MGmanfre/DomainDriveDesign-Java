package com.locadora.cliente;

import java.time.LocalDate;

public class Cnh {
	private final String numero;
	private final LocalDate dataVencimento;

	public Cnh(String numero, LocalDate dataVencimento) {
		if (numero == null || numero.isBlank()) {
			throw new IllegalArgumentException("O numero da CNH e obrigatorio.");
		}
		if (dataVencimento == null) {
			throw new IllegalArgumentException("A data de vencimento da CNH e obrigatoria.");
		}

		this.numero = numero;
		this.dataVencimento = dataVencimento;
	}

	public String getNumero() {
		return numero;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public boolean estaValida() {
		return !dataVencimento.isBefore(LocalDate.now());
	}
}
