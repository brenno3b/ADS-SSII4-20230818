import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int key = 3;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Algoritmo de cifragem de césar ---\n");

            System.out.println("0 - Sair");
            System.out.println("1 - Cifrar texto");
            System.out.println("2 - Decifrar texto\n");

            System.out.print("Digite uma opção: ");

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.exit(0);
                    case 1:
                        System.out.print("Digite um texto: ");
                        String plainText = scanner.next();
                        System.out.println("Texto cifrado: " + encrypt(plainText, key));
                        break;
                    case 2:
                        System.out.print("Digite o texto cifrado: ");
                        String encryptedText = scanner.next();
                        System.out.println("Texto decifrado: " + decrypt(encryptedText, key));
                        break;
                    default:
                        System.out.println("Opção inexistente.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                System.exit(-1);
            }
        }
    }

    public static String encrypt(String plainText, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String encryptedText, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }
}