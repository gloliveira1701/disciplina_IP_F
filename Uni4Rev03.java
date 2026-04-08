import java.util.Scanner;

public class Uni4Rev03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // #region Entrada
        System.out.println("Informe o valor da compra: ");
        double valor = teclado.nextDouble();

        System.out.println("Forma de pagamento (1 à vista / 2 parcelado): ");
        int forma = teclado.nextInt();
        // #endregion

        // #region Processo

        double valorFinal = valor;
        String descricao = "";

        if (forma == 1) {
            descricao = "à vista";

            /*
             * Regras:
             * até 100 → 5%
             * acima → 10%
             */
            if (valor <= 100) {
                valorFinal = valor * 0.95;
            } else {
                valorFinal = valor * 0.90;
            }

        } else if (forma == 2) {

            System.out.println("Número de parcelas: ");
            int parcelas = teclado.nextInt();

            descricao = "parcelado em " + parcelas + "x";

            /*
             * Regras:
             * até 3x → sem juros
             * acima → +20%
             */
            if (parcelas > 3) {
                valorFinal = valor * 1.20;
            }
        }

        // #endregion

        // #region Saída
        System.out.println("Valor final: R$ " + valorFinal);
        System.out.println("Forma de pagamento: " + descricao);
        // #endregion

        teclado.close();
    }
}

/*
 * ========================
 * CASOS DE TESTE
 * 
 * Caso 1:
 * valor = 80 à vista
 * → 5% desconto → 76
 * 
 * Caso 2:
 * valor = 200 à vista
 * → 10% desconto → 180
 * 
 * Caso 3:
 * valor = 200 em 2x
 * → sem juros → 200
 * 
 * Caso 4:
 * valor = 200 em 5x
 * → +20% → 240
 */
