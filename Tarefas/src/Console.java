import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
        return valor;
    }

    public static float lerFloat(String mensagem) {
        System.out.print(mensagem + ": ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Entrada inválida. Por favor, digite um número decimal.");
            scanner.next();
        }
        float valor = scanner.nextFloat();
        scanner.nextLine(); // Limpa o buffer do scanner
        return valor;
    }
}
