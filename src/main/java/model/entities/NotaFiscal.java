package model.entities;

import java.util.Date;

public class NotaFiscal {
    private String nomeArquivo;
    private double valorTotal;
    private Date dataEmissao;

    // Construtor
    public NotaFiscal(String nomeArquivo, double valorTotal) {
        this.nomeArquivo = nomeArquivo;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters (gerar automaticamente no IntelliJ: Alt + Insert)
    public String getNomeArquivo() { return nomeArquivo; }
    public double getValorTotal() { return valorTotal; }
    // ... (adicionar setters se necessário)
}