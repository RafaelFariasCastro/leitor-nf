# NFLeitor - Extrator de Valores de Notas Fiscais em PDF

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![PDFBox](https://img.shields.io/badge/Apache_PDFBox-2.0.33-red)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Descrição

O NFLeitor é um aplicativo Java que extrai automaticamente valores de notas fiscais e comprovantes em formato PDF, calcula o total gasto e gera relatórios simples. Desenvolvido seguindo o padrão MVC (Model-View-Controller).

## ✨ Funcionalidades

- Extrai valores monetários de PDFs de notas fiscais
- Identifica transações PIX em comprovantes
- Calcula totais e médias de gastos
- Gera relatórios no console
- Fácil integração com outros sistemas

## 🛠️ Tecnologias

- **Java 17+**
- **Apache PDFBox 2.0.33** (para processamento de PDFs)
- **Maven** (para gerenciamento de dependências)

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 ou superior
- Maven 3.6+
- IntelliJ IDEA (recomendado) ou outra IDE Java

## 🔍 Padrões Reconhecidos

O sistema identifica automaticamente valores monetários nos seguintes formatos:

```text
Pix enviado R$ 29,90
Valor: R$ 1.230,50
Total R$42,00
```
