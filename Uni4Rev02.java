/*
//__ Entradas: 
ler(limite)
ler(velocidadeVeiculo)

//__ Processos: 
Calcular percentual de excesso
Verificar faixa da multa (20%, 50%, acima)

//__ Saídas: 
imprimir(situacao, excesso, valorMulta)
*/

import java.util.Scanner;

public class Uni4Rev02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Velocidade permitida: ");
        double limite = teclado.nextDouble();
        System.out.print("Velocidade do veículo: ");
        double vel = teclado.nextDouble();

        if (vel <= limite) {
            System.out.println("Situação: Sem multa | Excesso: 0% | Multa: R$ 0");
        } else {
            double excessoPerc = ((vel - limite) / limite) * 100;

            if (excessoPerc <= 20) {
                System.out.println("Situação: Multa Leve | Excesso: " + excessoPerc + "% | Multa: R$ 130");
            } else if (excessoPerc <= 50) {
                System.out.println("Situação: Multa Grave | Excesso: " + excessoPerc + "% | Multa: R$ 195");
            } else {
                System.out.println("Situação: Multa Gravíssima (CNH Suspensa) | Excesso: " + excessoPerc + "% | Multa: R$ 880");
            }
        }
        teclado.close();
    }
}

/*
__ Valores de Testes: 
_ Caso 1 ___
Limite: 60 | Vel: 60 -> Sem multa

_ Caso 2 ___
Limite: 60 | Vel: 72 -> (72-60)/60 = 20% -> Multa Leve (130)

_ Caso 3 ___
Limite: 60 | Vel: 100 -> (100-60)/60 = 66.6% -> Multa Grave (195)
*/
