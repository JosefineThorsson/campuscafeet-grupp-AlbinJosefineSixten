import java.util.Scanner;
import java.util.*;

public class CoffeePlace {

    public static void main(String[] args) {
        printMenu();
    }

    static final String placeName = "[placeNameHere]";
    static int nextOrderNumber = 0;
    static boolean currentlyOpen = false;

    static void printMenu() {

        while (true) {
            if (currentlyOpen) {
                System.out.println("=== Välkommen till CampusCaféet " + placeName + "! === \n"
                        + "next orders number(?): " + (nextOrderNumber + 1) + "\n"
                        + "1. Visa produkter och priser \n"
                        + "2. Lägg en beställning \n"
                        + "3. Visa alla beställningar \n"
                        + "4. Visa beställningskön \n"
                        + "5. Gör klar nästa beställning \n"
                        + "6. Lämna ut färdig beställning \n"
                        + "7. Visa dagens statistik \n"
                        + "8. Avsluta");

                String choice = System.console().readLine();

                // if (!Arrays.asList("1","2","3","4","5","6","7","8").contains(choice)){
                // continue;
                // }

                int choiceInt = 0;
                try {
                    choiceInt = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("choice isnt an integer");
                }

                if (choiceInt == 8) {
                    if (System.console().readLine("Exit? yes/no: ").equalsIgnoreCase("yes")) {

                        System.out.println("""
                                    exiting...

                                    Spelet avslutas
                                """);

                        break;
                    } else {
                        continue;
                    }
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
            } else { System.out.println("Sorry dude were closed"); }
            // sc.close(System.out);
        }

    } 
}