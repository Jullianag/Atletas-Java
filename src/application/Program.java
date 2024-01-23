package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        double somaPeso = 0.0;
        double somaAlturaMulheres = 0.0;
        double porcentHomem = 0.0;
        double atletaMaisAlto = 0.0;
        int numHomem = 0;
        int numMulher = 0;
        String auxAlto = null;
        String nome;

        System.out.print("Qual a quantidade de atletas? ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.printf("Digite os dados do atleta número %d:%n", i + 1);
            System.out.print("Nome: ");
            // não consegui imprimir o nome no final com o nextLine()
            nome = sc.next();
            sc.nextLine();

            System.out.print("Sexo: ");
            char sexo = sc.next().toUpperCase().charAt(0);

            while (sexo != 'F' && sexo != 'M') {
                System.out.print("Valor inválido! Favor digitar F ou M: ");
                sexo = sc.next().toUpperCase().charAt(0);
            }

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            while (altura <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }

            if (altura > atletaMaisAlto) {
                atletaMaisAlto = altura;
                auxAlto = nome;
            }

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            while (peso <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }
            somaPeso += peso;

            if (sexo == 'M') {
                numHomem++;
                porcentHomem = (numHomem * 100.0) / n;
            }
            else {
                somaAlturaMulheres += altura;
                numMulher++;
            }
        }

        double pesoMedio = somaPeso / n;
        double alturaMedia = somaAlturaMulheres / numMulher;


        System.out.printf("%nRELATÓRIO:%n");
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
        System.out.printf("Atleta mais alto: %s%n", auxAlto);
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentHomem);

        if (numMulher > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", alturaMedia);
        }
        else {
            System.out.printf("Não há mulheres cadastradas%n");
        }

        sc.close();
    }
}
