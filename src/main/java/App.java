import controller.NotaFiscalController;
import services.PdfProcessorService;
import view.NotaFiscalView;

public class App {

    public static void testarPadroes() {
        PdfProcessorService service = new PdfProcessorService();
        String[] exemplos = {
                "Pix enviado R$ 29,90",
                "Valor: R$ 1.230,50",
                "Total R$42,00"
        };

        for (String exemplo : exemplos) {
            double valor = service.extrairValorTotal(exemplo);
            System.out.printf("Texto: '%s' → Valor: R$ %.2f%n", exemplo, valor);
        }
    }

    public static void main(String[] args) {
        // Para testar os padrões de extração
        testarPadroes();

        // Processamento normal do PDF
        NotaFiscalController controller = new NotaFiscalController();
        NotaFiscalView view = new NotaFiscalView();

        // Processa um PDF na pasta 'resources/pdfs/'
        controller.adicionarNota("src/main/resources/pdfs/teste.pdf");

        // Exibe os resultados
        view.exibirNotas(controller.listarNotas());
    }
}