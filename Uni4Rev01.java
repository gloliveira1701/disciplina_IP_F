/*
//__ Entradas: 
ler(nome)
ler(horasTrabalhadas)
ler(valorHora)

//__ Processos: 
Calcular salário bruto com base nas faixas de horas (160, 200)
Calcular desconto INSS (8%)
Calcular desconto IR (10% se bruto > 3000)
Calcular salário líquido

//__ Saídas: 
imprimir(nome, bruto, inss, ir, liquido)
*/

import java.util.Scanner;

public class Uni4Rev01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // __ Entradas:
        System.out.print("Nome do funcionário: ");
        String nome = teclado.nextLine();
        System.out.print("Horas trabalhadas: ");
        double horas = teclado.nextDouble();
        System.out.print("Valor por hora: ");
        double valorHora = teclado.nextDouble();

        double salarioBruto = 0;
        double valorExtra = 0;

        // __ Processamento:
        if (horas <= 160) {
            salarioBruto = horas * valorHora;
        } else if (horas <= 200) {
            double horasNormais = 160 * valorHora;
            double horasExtras = (horas - 160) * (valorHora * 1.5);
            salarioBruto = horasNormais + horasExtras;
        } else {
            double horasNormais = 160 * valorHora;
            double horasExtras50 = 40 * (valorHora * 1.5);
            double horasExtras100 = (horas - 200) * (valorHora * 2.0);
            salarioBruto = horasNormais + horasExtras50 + horasExtras100;
        }

        double inss = salarioBruto * 0.08;
        double ir = (salarioBruto > 3000) ? (salarioBruto * 0.10) : 0;
        double salarioLiquido = salarioBruto - inss - ir;

        // __ Saídas:
        System.out.println("Funcionário: " + nome);
        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("Desconto INSS: R$ " + inss);
        System.out.println("Desconto IR: R$ " + ir);
        System.out.println("Salário Líquido: R$ " + salarioLiquido);

        teclado.close();
    }
}

/*
__ Valores de Testes: 
_ Caso 1 (João) ___
Entrada: 160h, R$10 -> Bruto: 1600.00 | INSS: 128.00 | IR: 0.00 | Líquido: 1472.00

_ Caso 2 (Maria) ___
Entrada: 180h, R$20 -> Bruto: 3800.00 (160*20 + 20*30) | INSS: 304.00 | IR: 380.00 | Líquido: 3116.00

_ Caso 3 (Carlos) ___
Entrada: 220h, R$25 -> Bruto: 6500.00 (160*25 + 40*37.5 + 20*50) | INSS: 520.00 | IR: 650.00 | Líquido: 5330.00
*/
