import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class uzduotis1 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\simku\\Desktop\\Traškutė.txt";
        String tekstas1 = "\nAtrodo nuostabiai, bet tęskime toliau. ";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Netinkamas failas: " + e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite Savo varda:");
        String vardas = sc.nextLine();
        sc.close();
        if(vardas.contains("as")) {
            String vardas1 = vardas.replace('a', 'o').replace('s',' ');
            System.out.println("Puikus receptas iš:" + vardas1);
        }
        try {
            String existingContent = new String(Files.readAllBytes(Paths.get(fileName)));
            String newContent = existingContent.substring(0,2418) + tekstas1 + existingContent.substring(2420,4258);
            Files.write(Paths.get(fileName), newContent.getBytes());
        } catch (IOException e) {
            System.err.println("Klaida: " + e.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Netinkamas failas: " + e.getMessage());
        }
    }
}
