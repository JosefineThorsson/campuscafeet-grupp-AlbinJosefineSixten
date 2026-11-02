/*import java.util.ArrayList;
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
 /* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Part3 {
   
    private static List<Bestallning> allaBestallningar = new ArrayList<>();
    
   
    private static Queue<Bestallning> orderKo = new LinkedList<>();

    public static void main(String[] args) {
        // Test beställningar
        skapaNyBestallning(1, "Dude", new Kaffe());
        skapaNyBestallning(2, "Dude2", new Flaskvatten());
        skapaNyBestallning(3, "Dude3", new Macka());

        System.out.println("Behandlar kön av beställningar: ");
        gorKlarNastaBestallning(); // Behandlar Dude (Kaffe -> Brygger kaffe!)
        gorKlarNastaBestallning(); // Behandlar Dude2 (Vatten -> Blir klar direkt)
        gorKlarNastaBestallning(); // Behandlar Dude3 (Macka -> Brer en macka!)
        gorKlarNastaBestallning(); // Kön är tom -> Visar meddelande

        System.out.println("Alla beställningar: ");
        visaAllaBestallningar();
    }

   
    public static void skapaNyBestallning(int nr, String namn, Produkt produkt) {
        Bestallning nyOrder = new Bestallning(nr, namn, produkt, OrderStatus.NY);
        allaBestallningar.add(nyOrder);
        orderKo.add(nyOrder);
    }

   
    public static void gorKlarNastaBestallning() {
        // Kontrollera om kön är tom
        if (orderKo.isEmpty()) {
            System.out.println("Det finns inga väntande beställningar i kön!");
            return;
        }

      
        Bestallning nastaOrder = orderKo.poll();
        System.out.println("Behandlar order #" + nastaOrder.getOrderNumber() + " för " + nastaOrder.getCustomerName());

        Produkt produkt = nastaOrder.getProduct();

        
        if (produkt instanceof Tillagbar) {
           
            ((Tillagbar) produkt).tillagar();
        } else {
            System.out.println("Flaskvatten kräver ingen tillagning.");
        }

       
        nastaOrder.setStatus(OrderStatus.KLAR);
        System.out.println("Order #" + nastaOrder.getOrderNumber() + " är nu Klar.");
    }

    
    public static void visaAllaBestallningar() {
        for (Bestallning b : allaBestallningar) {
            System.out.println(b); 
            b.getProduct().describeProduct(); 
            System.out.println("-----------------------------------");
        }
    }
}