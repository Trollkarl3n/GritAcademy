import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // Antalet varor till respektive vara
        int antalVara1 = 35;
        int antalVara2 = 40;
        int antalVara3 = 15;

        // Lista på varor
        Kund kund = new Kund();
        ArrayList<Vara> varor = new ArrayList<>();
        varor.add(new Vara("Vara 1", 100.0, antalVara1));
        varor.add(new Vara("Vara 2", 150.0, antalVara2));
        varor.add(new RabattVara("Vara 3", 300.0, 0.1, antalVara3));

        Scanner scanner = new Scanner(System.in);

        //Loop för att kunna köpa fler produkter
        while (true){

            // Skriver ut varorna
            for (int i = 0; i < varor.size(); i++){
                Vara vara = varor.get(i);
                System.out.println((i + 1) + " Köp " + vara.getNamn() + " Pris " + vara.getPris() + "kr antal " + vara.getAntal());
            }
            System.out.println((varor.size() + 1 ) + " Avsluta ");

            System.out.println("Välj en vara att köpa (1 - " + (varor.size() + 1) + "): ");
            // Väljer vilken vara du vill ha
            int val = scanner.nextInt();

            // Kollar vilken vara du har köpt
            if (val > 0 && val <= varor.size()){
                Vara valdVara = varor.get(val - 1);
                kund.kopaVara(valdVara);
                valdVara.setAntal(valdVara.getAntal()); // Minskar antalet varor
                System.out.println("Du har köpt " + valdVara.getNamn() + " för " + valdVara.getPris() + " kr");
            } else if (val == 4) {
                // Avslutar programmet
                break;
            }
        }

        // Printar totala kostnaden & antalet produkter
        System.out.println("Antal produkter du har köpt: " + kund.getAntalVaraKopt() + " st");
        System.out.println("Totala kostnaden: " + kund.getTotalAntalVara() + " kr");

        // Stänger scannern
        scanner.close();

    }
}