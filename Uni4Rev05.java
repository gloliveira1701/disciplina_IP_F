/*
//__ Entradas: 
ler(nome, n1, n2, n3, frequencia)

//__ Processos: 
Calcular média
Verificar frequência < 75
Verificar faixas de média (7, 5)

//__ Saídas: 
imprimir(nome, media, situacao)
*/

import java.util.Scanner;

public class Uni4Rev05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = teclado.next();
        System.out.print("Notas (1, 2 e 3): ");
        double n1 = teclado.nextDouble();
        double n2 = teclado.nextDouble();
        double n3 = teclado.nextDouble();
        System.out.print("Frequência: ");
        int freq = teclado.nextInt();

        double media = (n1 + n2 + n3) / 3;

        System.out.println("Aluno: " + nome + " | Média: " + media);
        
        if (freq < 75) {
            System.out.println("Situação: Reprovado por falta.");
        } else if (media >= 7) {
            System.out.println("Situação: Aprovado.");
        } else if (media >= 5) {
            System.out.println("Situação: Recuperação.");
        } else {
            System.out.println("Situação: Reprovado.");
        }
        teclado.close();
    }
}
