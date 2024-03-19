import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner teclado = new Scanner(System.in); 
		System.out.println("Digite o primeiro numero: ");
		double n1 = teclado.nextDouble();
		System.out.println("Digite o segundo numero: ");
		double n2 = teclado.nextDouble();
		System.out.println("Soma: "+ (n1 + n2));
		System.out.println("Subtracao: "+ (n1 - n2));
		System.out.println("Divisao: "+ (n1 / n2));
		System.out.println("Multiplicacao: "+ (n1 * n2));
	}
}
