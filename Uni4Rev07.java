/*
//__ Entradas: 
ler(nomeHospede)
ler(categoriaFidelidade)
ler(tipoAposento)
ler(qtdDiarias)
ler(valorFrigobar)
ler(formaPagamento)

//__ Processos: 
- Seleção do valor da diária (switch-case)
- Cálculo da taxa de serviço (if/else)
- Aplicação de desconto por String (equals/fidelidade)
- Cálculo do desconto final por pagamento

//__ Saídas: 
- Extrato detalhado com totalizadores
*/

import java.util.Scanner;

public class Uni4Rev07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // --- ENTRADAS ---
        System.out.println("--- CHECKOUT BLUMENAU TECH HOTEL ---");
        System.out.print("Nome do Hóspede: ");
        String nome = teclado.nextLine();

        System.out.print("Categoria de Fidelidade (VIP, COMUM, NOVO): ");
        String categoria = teclado.next().toUpperCase();

        System.out.print("Tipo de Aposento (S/D/L): ");
        char tipo = teclado.next().toUpperCase().charAt(0);

        System.out.print("Quantidade de diárias: ");
        int diarias = teclado.nextInt();

        System.out.print("Consumo total Frigobar: R$ ");
        double frigobar = teclado.nextDouble();

        System.out.print("Forma de Pagamento (1-PIX/Dinheiro | 2-Cartão): ");
        int forma = teclado.nextInt();

        // --- PROCESSAMENTO ---
        double valorDiaria = 0;
        String nomeQuarto = "";

        // Definindo valor do quarto com Switch Case
        switch (tipo) {
            case 'S':
                valorDiaria = 150.00;
                nomeQuarto = "Standard";
                break;
            case 'D':
                valorDiaria = 220.00;
                nomeQuarto = "Duplo";
                break;
            case 'L':
                valorDiaria = 350.00;
                nomeQuarto = "Luxo";
                break;
            default:
                System.out.println("\n[ERRO]: Tipo inválido. Definido como Standard por padrão.");
                valorDiaria = 150.00;
                nomeQuarto = "Standard (Ajustado)";
                break;
        }

        double totalDiarias = valorDiaria * diarias;
        double taxaServico = 0;

        // Cálculo da Taxa de Serviço com IFs encadeados
        if (diarias < 5) {
            taxaServico = totalDiarias * 0.15;
        } else if (diarias <= 10) {
            taxaServico = totalDiarias * 0.10;
        } else {
            taxaServico = totalDiarias * 0.05;
        }

        double subtotal = totalDiarias + taxaServico + frigobar;

        // Desconto de Fidelidade (Comparações de String)
        double descFidelidade = 0;
        if (categoria.equals("VIP")) {
            descFidelidade = subtotal * 0.15;
        } else if (categoria.equals("COMUM")) {
            descFidelidade = subtotal * 0.05;
        }

        double valorComFidelidade = subtotal - descFidelidade;

        // Condição de Pagamento Final
        double descPagamento = 0;
        if (forma == 1) {
            descPagamento = valorComFidelidade * 0.05;
        }

        double valorFinal = valorComFidelidade - descPagamento;

        // --- SAÍDA ---
        System.out.println("\n========================================");
        System.out.println("           RESUMO DO CHECKOUT           ");
        System.out.println("========================================");
        System.out.println("Hóspede: " + nome + " | Categoria: " + categoria);
        System.out.println("Quarto:  " + nomeQuarto + " (" + diarias + " diárias)");
        System.out.println("----------------------------------------");
        System.out.printf("Subtotal Diárias:    R$ %.2f\n", totalDiarias);
        System.out.printf("Taxa de Serviço:     R$ %.2f\n", taxaServico);
        System.out.printf("Consumo Frigobar:    R$ %.2f\n", frigobar);
        System.out.printf("Desconto Fidelidade: R$ %.2f\n", descFidelidade);
        
        if (forma == 1) {
            System.out.printf("Desconto PIX/Din:    R$ %.2f\n", descPagamento);
        }

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL FINAL A PAGAR: R$ %.2f\n", valorFinal);
        System.out.println("========================================\n");

        teclado.close();
    }
}

/*
__ Valores de Testes (Teste de Mesa): 
_ Caso 1 (VIP em Luxo) ___
Entrada: Guilherme, VIP, L, 12 dias, Frigobar 100, Pagamento 1 (PIX)
1. Diárias: 12 * 350 = 4200
2. Taxa (5%): 210
3. Subtotal: 4510
4. Desc. VIP (15%): 676.50
5. Desc. PIX (5% s/ 3833.50): 191.67
Total Final: R$ 3641.83

_ Caso 2 (Novo em Standard) ___
Entrada: Joana, NOVO, S, 2 dias, Frigobar 50, Pagamento 2 (Cartão)
1. Diárias: 2 * 150 = 300
2. Taxa (15%): 45
3. Subtotal: 395
4. Desc. NOVO: 0
5. Desc. Cartão: 0
Total Final: R$ 395.00
*/
