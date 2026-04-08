/*
//__ Entradas: 
ler(nome, tipoQuarto, diarias, pagamento)

//__ Processos: 
Definir preço base pelo tipo (S, D, L)
Adicionar taxa se diarias > 5
Aplicar desconto se pagamento à vista (1)

//__ Saídas: 
imprimir(cliente, quarto, total)
*/

import java.util.Scanner;

public class Uni4Rev06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = teclado.next();
        System.out.print("Tipo Quarto (S/D/L): ");
        char tipo = teclado.next().toUpperCase().charAt(0);
        System.out.print("Diárias: ");
        int dias = teclado.nextInt();
        System.out.print("Pagamento (1-À vista, 2-Prazo): ");
        int pag = teclado.nextInt();

        double precoBase = 0;
        String descQuarto = "";

        switch (tipo) {
            case 'S': precoBase = 100; descQuarto = "Standard"; break;
            case 'D': precoBase = 180; descQuarto = "Deluxe"; break;
            case 'L': precoBase = 250; descQuarto = "Luxo"; break;
        }

        double total = precoBase * dias;
        if (dias > 5) total += 50;
        if (pag == 1) total *= 0.90;

        System.out.println("Cliente: " + nome + " | Quarto: " + descQuarto + " | Total: R$ " + total);
        teclado.close();
    }
}
