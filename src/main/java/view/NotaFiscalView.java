package view;

import model.entities.NotaFiscal;
import java.util.List;

public class NotaFiscalView {
    public void exibirNotas(List<NotaFiscal> notas) {
        System.out.println("=== NOTAS FISCAIS ===");
        notas.forEach(nota -> System.out.printf(
                "Arquivo: %s | Valor: R$ %.2f%n",
                nota.getNomeArquivo(), nota.getValorTotal()
        ));
    }
}