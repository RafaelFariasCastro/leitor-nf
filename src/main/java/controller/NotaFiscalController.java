package controller;

import model.entities.NotaFiscal;
import services.PdfProcessorService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalController {
    private final PdfProcessorService pdfService = new PdfProcessorService();
    private final List<NotaFiscal> notasProcessadas = new ArrayList<>();

    public void adicionarNota(String caminhoArquivo) {
        try {
            notasProcessadas.add(pdfService.processarPdf(caminhoArquivo));
        } catch (IOException e) {
            System.err.println("Erro ao processar PDF: " + e.getMessage());
        }
    }

    public List<NotaFiscal> listarNotas() {
        return new ArrayList<>(notasProcessadas);
    }
}