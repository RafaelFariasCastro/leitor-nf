package services;

import model.entities.NotaFiscal;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.*;

public class PdfProcessorService {
    public NotaFiscal processarPdf(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        PDDocument documento = PDDocument.load(arquivo);
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);
        String texto = stripper.getText(documento);
        documento.close();

        debugTextoPDF(texto);
        double valorTotal = extrairValorTotal(texto);
        return new NotaFiscal(arquivo.getName(), valorTotal);
    }

    // Alterado para public para poder ser acessado pela classe App
    public double extrairValorTotal(String texto) {
        // Padrões corrigidos com parênteses balanceados
        Pattern[] padroes = {
                Pattern.compile("Pix enviado\\s+R\\$\\s*(\\d{1,3}(?:\\.\\d{3})*(?:,\\d{2}))"),  // Parêntese fechado
                Pattern.compile("R\\$\\s*(\\d{1,3}(?:\\.\\d{3})*(?:,\\d{2}))"),  // Corrigido
                Pattern.compile("Valor.*?[R$]\\s*(\\d+,\\d{2})")  // Corrigido
        };

        for (Pattern padrao : padroes) {
            Matcher matcher = padrao.matcher(texto);
            if (matcher.find()) {
                try {
                    String valorStr = matcher.group(1).replace(".", "").replace(",", ".");
                    return Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor: " + matcher.group(1));
                }
            }
        }
        return 0.0;
    }

    public void debugTextoPDF(String texto) {
        System.out.println("\n=== TEXTO EXTRAÍDO DO PDF ===");
        System.out.println(texto.substring(0, Math.min(200, texto.length())));
        System.out.println("... [texto truncado] ...");
        System.out.println("=============================");

        System.out.println("Contém 'R$'? " + texto.contains("R$"));
        System.out.println("Contém 'Pix'? " + texto.contains("Pix"));
    }
}