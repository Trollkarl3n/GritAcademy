import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner input = new Scanner(System.in);

        // Sätta spel till true för loopen
        boolean spel = true;
        while (spel) {

            int tal = randomNum();
            int counter = 0;

            // Loop för att se om du har rätt/fel
            while(true) {
                System.out.println("Gissa ett tal mellan 0-100");
                int guess = input.nextInt();
                counter++;

                // Ger ut din gissning till respektive random nummer
                String resultat = dinGissning(tal, guess);
                System.out.println(resultat + " Du har gissat: " + counter + " gånger");

                // If sats för att ge dig rätt svar
                if (resultat.equals("Du har gissat rätt")) {
                    System.out.println("Du har gissat: " + counter + " gånger");
                    break;
                }
            }

            // Om du vill spela igen
            System.out.println("Vill du spela igen? (ja/nej): ");
            String svar = input.next();
            spel = svar.equalsIgnoreCase("ja");
        }

        // Stänger scanner
        input.close();

    }

    // Metod för random nummer
    public static int randomNum() {
        Random random = new Random();
        return random.nextInt(101); // Slumptal mellan 0 och 100
    }

    // Metod för att titta över dina gissningar
    public static String dinGissning(int tal, int guess) {
        if (guess < tal) {
            return "Gissa högre, ";
        } else if (guess > tal) {
            return "Gissa lägre, ";
        } else {
            return "Du har gissat rätt";
        }
    }
}