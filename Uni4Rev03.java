/*
//__ Entradas: 
ler(valorCompra)
ler(formaPagamento)
se (forma == 2) ler(parcelas)

//__ Processos: 
Calcular descontos para à vista (5% ou 10%)
Calcular juros para parcelado (>3x = 20%)

//__ Saídas: 
imprimir(valorFinal, descricaoPagamento)
*/

import java.util.Scanner;

public class Uni4Rev03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Valor da compra: ");
        double valor = teclado.nextDouble();
        System.out.print("Forma (1-À vista, 2-Parcelado): ");
        int forma = teclado.nextInt();

        double valorFinal = 0;

        if (forma == 1) {
            if (valor <= 100) {
                valorFinal = valor * 0.95;
            } else {
                valorFinal = valor * 0.90;
            }
            System.out.println("Valor Final: R$ " + valorFinal + " (À vista)");
        } else if (forma == 2) {
            System.out.print("Número de parcelas: ");
            int parcelas = teclado.nextInt();
            
            if (parcelas <= 3) {
                valorFinal = valor;
            } else {
                valorFinal = valor * 1.20;
            }
            System.out.println("Valor Final: R$ " + valorFinal + " (Parcelado " + parcelas + "x)");
        } else {
            System.out.println("Opção inválida.");
        }
        teclado.close();
    }
}

/*
__ Valores de Testes: 
_ Caso 1 ___
Valor: 80 | Forma: 1 -> R$ 76.00

_ Caso 2 ___
Valor: 200 | Forma: 1 -> R$ 180.00

_ Caso 3 ___
Valor: 200 | Forma: 2 | Parcelas: 5 -> R$ 240.00
*/
