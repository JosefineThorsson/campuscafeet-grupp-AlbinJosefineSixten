import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Part3 {
    public static void main(String[] args) {
     
        List<Bestallning> bestallningar = new ArrayList<>();

       
        Queue<Bestallning> bestallningsKö = new LinkedList<>();

       
        Bestallning order1 = new Bestallning("Obama", "Kaffe");
        Bestallning order2 = new Bestallning("Kennedy", "Flaskvatten");
        Bestallning order3 = new Bestallning("Lincoln", "Macka");

      
        bestallningar.add(order1); bestallningsKö.add(order1);
        bestallningar.add(order2); bestallningsKö.add(order2);
        bestallningar.add(order3); bestallningsKö.add(order3);

       
        System.out.println(" Behandlar kön: ");
        while (true) {
            if (!bestallningsKö.isEmpty()) {
                Bestallning nextOrder = bestallningsKö.poll(); 

              
                if (nextOrder.getProdukt().equalsIgnoreCase("Flaskvatten")) {
                    nextOrder.setStatus("Klar");
                } else {
                   
                    nextOrder.tillagbar();
                   
                    nextOrder.setStatus("Klar"); 
                }
                System.out.println("Behandlad order: " + nextOrder);
            } else {
                System.out.println("Kön är tom.");
                break;
            }
        }

       
        System.out.println(" Orderhistorik: ");
        for (Bestallning b : bestallningar) {
            System.out.println(b);
        }
    }
}
 