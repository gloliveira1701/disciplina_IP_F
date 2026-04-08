import java.util.Scanner;

public class Uni4Rev02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // #region Entrada
        System.out.println("Informe a velocidade permitida: ");
        double limite = teclado.nextDouble();

        System.out.println("Informe a velocidade do veículo: ");
        double velocidade = teclado.nextDouble();
        // #endregion

        // #region Processo

        double excesso = velocidade - limite;
        double percentual = 0;

        if (velocidade > limite) {
            percentual = (excesso / limite) * 100;
        }

        String situacao;
        double multa = 0;

        /*
         * Classificação:
         * - <= limite → sem multa
         * - até 20% → leve
         * - até 50% → grave
         * - acima → gravíssima
         */

        if (velocidade <= limite) {
            situacao = "Sem multa";

        } else if (percentual <= 20) {
            situacao = "Multa leve";
            multa = 130;

        } else if (percentual <= 50) {
            situacao = "Multa grave";
            multa = 195;

        } else {
            situacao = "Multa gravíssima (CNH suspensa)";
            multa = 880;
        }

        // #endregion

        // #region Saída
        System.out.println("Situação: " + situacao);
        System.out.println("Percentual de excesso: " + percentual + "%");
        System.out.println("Valor da multa: R$ " + multa);
        // #endregion

        teclado.close();
    }
}

/*
 * ========================
 * CASOS DE TESTE
 * 
 * Caso 1:
 * limite = 60, velocidade = 60
 * → sem multa
 * 
 * Caso 2:
 * velocidade = 72
 * excesso = 12 → 20%
 * → multa leve (130)
 * 
 * Caso 3:
 * velocidade = 100
 * excesso = 40 → 66%
 * → multa gravíssima (880)
 * 
 * Caso 4:
 * velocidade = 80
 * excesso = 20 → 33%
 * → multa grave (195)
 */
