import java.util.Scanner;
import java.util.*;

public class CoffeePlace {

    // 2. Skriv ut välkomsttexten och menyn. Använd variabler för till exempel
    // cafénamn, nästa ordernummer och om
    // caféet är öppet.
    // 3. Läs användarens val. Använd en while-loop för att visa menyn tills
    // användaren väljer Avsluta, och en switch för
    // menyvalen.
    // 4. Kontrollera felaktiga menyval med if/else. Visa ett begripligt meddelande
    // och gå tillbaka till menyn.
    // 5. Testa String och equals eller equalsIgnoreCase när ni exempelvis frågar om
    // användaren vill fortsätta med
    // ja/nej.

    static final String placeName = "[placeNameHere]";
    int nextOrderNumber = 0;
    boolean currentlyOpen = false;

    static void printMenu() {

        while (true) {
            System.out.println("=== Välkommen till CampusCaféet" + placeName + "! === \n"
                    + "1. Visa produkter och priser \n"
                    + "2. Lägg en beställning \n"
                    + "3. Visa alla beställningar \n"
                    + "4. Visa beställningskön \n"
                    + "5. Gör klar nästa beställning \n"
                    + "6. Lämna ut färdig beställning \n"
                    + "7. Visa dagens statistik \n"
                    + "8. Avsluta");

            String choice = System.console().readLine();
            if (!Arrays.asList("1","2","3","4","5","6","7","8").contains(choice)){

            }

            int choiceInt = Integer.parseInt(choice);

            if (choiceInt == 8) {
                System.out.println("""
                        Du har valt: 8. Avsluta

                        Spelet avslutas
                        """);

                break;
            }

            switch (choiceInt) {
                case 1:

                    continue;

                case 2:

                    continue;

                case 3:

                    continue;

                case 4:

                    continue;

                case 5:

                    continue;

                case 6:

                    continue;

                case 7:

                    continue;

                default:
                    System.out.println("\nOgiltigt nummer. Skriv in ett nummer mellan 1-8 och försök igen");

                    continue;
            }
        }
        // sc.close(System.out);
    }

}