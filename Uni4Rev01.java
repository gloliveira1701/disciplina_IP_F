import java.util.Scanner;

public class Uni4Rev01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // #region Entrada
        System.out.println("Informe o nome do funcionário: ");
        String nome = teclado.nextLine();

        System.out.println("Informe as horas trabalhadas no mês: ");
        int horas = teclado.nextInt();

        System.out.println("Informe o valor pago por hora: ");
        double valorHora = teclado.nextDouble();
        // #endregion

        // #region Processo

        /*
         * Regras:
         * - Até 160h → normal
         * - 161 a 200 → extra 50%
         * - >200 → extra 50% até 200 + extra 100% acima disso
         */

        double salarioBruto;

        if (horas <= 160) {
            salarioBruto = horas * valorHora;

        } else if (horas <= 200) {
            int horasExtra = horas - 160;
            double valorExtra = horasExtra * valorHora * 1.5;

            salarioBruto = (160 * valorHora) + valorExtra;

        } else {
            int horasExtra50 = 40; // de 160 até 200
            int horasExtra100 = horas - 200;

            double valorExtra50 = horasExtra50 * valorHora * 1.5;
            double valorExtra100 = horasExtra100 * valorHora * 2;

            salarioBruto = (160 * valorHora) + valorExtra50 + valorExtra100;
        }

        // Descontos
        double inss = salarioBruto * 0.08;

        double ir = 0;
        if (salarioBruto > 3000) {
            ir = salarioBruto * 0.10;
        }

        double salarioLiquido = salarioBruto - inss - ir;

        // #endregion

        // #region Saída
        System.out.println("Funcionário: " + nome);
        System.out.println("Salário bruto: " + salarioBruto);
        System.out.println("INSS: " + inss);
        System.out.println("IR: " + ir);
        System.out.println("Salário líquido: " + salarioLiquido);
        // #endregion

        teclado.close();
    }
}

/*
 * ========================
 * CASOS DE TESTE
 * 
 * Caso 1:
 * horas = 160 | valor = 10
 * bruto = 1600
 * INSS = 128
 * IR = 0
 * líquido = 1472
 * 
 * Caso 2:
 * horas = 180 | valor = 20
 * extra = 20h → 20 * 20 * 1.5 = 600
 * bruto = 3200 + 600 = 3800
 * INSS = 304
 * IR = 380
 * líquido = 3116
 * 
 * Caso 3:
 * horas = 220 | valor = 25
 * extra50 = 40h → 1500
 * extra100 = 20h → 1000
 * bruto = 4000 + 1500 + 1000 = 6500
 */
