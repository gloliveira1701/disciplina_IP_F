/*
//__ Entradas: 
ler(saldoInicial)
ler(opcao)

//__ Processos: 
Switch case para operações (Depósito, Saque, Consulta, Rendimento)

//__ Saídas: 
imprimir(resultadoOperacao, saldoFinal)
*/

import java.util.Scanner;

public class Uni4Rev04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Saldo Inicial: ");
        double saldo = teclado.nextDouble();
        
        System.out.println("1-Depósito | 2-Saque | 3-Consulta | 4-Rendimento");
        int opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Valor do depósito: ");
                double dep = teclado.nextDouble();
                if (dep > 0) saldo += dep;
                System.out.println("Depósito realizado. Saldo: " + saldo);
                break;
            case 2:
                System.out.print("Valor do saque: ");
                double saque = teclado.nextDouble();
                if (saque <= saldo) {
                    saldo -= saque;
                    System.out.println("Saque realizado. Saldo: " + saldo);
                } else {
                    System.out.println("Saldo insuficiente.");
                }
                break;
            case 3:
                System.out.println("Saldo atual: R$ " + saldo);
                break;
            case 4:
                saldo *= 1.05;
                System.out.println("Rendimento aplicado. Novo saldo: " + saldo);
                break;
            default:
                System.out.println("Opção Inválida.");
        }
        teclado.close();
    }
}
