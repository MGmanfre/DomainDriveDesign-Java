package com.locadora.locacao;

import com.locadora.veiculo.Veiculo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private LocalDate pegaCarro;
    private LocalDate devolveCarro;
    private LocalDate quandoDevolveu;
    private Veiculo veiculo;

    public Locacao(LocalDate pegaCarro, LocalDate devolveCarro,LocalDate quandoDevolveu ,Veiculo veiculo) {
        this.pegaCarro = pegaCarro;
        this.devolveCarro = devolveCarro;
        this.quandoDevolveu = quandoDevolveu;
        this.veiculo = veiculo;
    }

    public long getQuantidadeDias() {
        long quantidadeDias = ChronoUnit.DAYS.between(pegaCarro, quandoDevolveu);
        return quantidadeDias;
    }

    public double calcularPrecoAluguel() {
        if (veiculo.getStatus()){
            double precoDeAluguel = getQuantidadeDias() * veiculo.getPrecoDiaria();
            return precoDeAluguel;
        }
        else {
            double precoDeAluguel = 0.00;
            return precoDeAluguel;
        }
    }

    public double multa() {
        long diasDeAtraso = ChronoUnit.DAYS.between(devolveCarro,quandoDevolveu);
        if (diasDeAtraso > 0) {
            return 50 * diasDeAtraso;
        }
        else {
            return 0.0;
        }
    }

    public double total_a_pagar() {
        return multa() + calcularPrecoAluguel();
    }


    @Override
    public String toString() {
        return "quantidade de dias alugados: " + this.getQuantidadeDias() + "\n" + "total a ser pago: " + this.total_a_pagar();
    }


}
