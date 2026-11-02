 
 /*    public class Bestallning {
    private static int orderCount = 0;
    private int ordernummer;
    private String kundnamn;
    private String produkt;
    private String status;

    public Bestallning(String kundnamn, String produkt) {
        orderCount++;
        this.ordernummer = orderCount;
        this.kundnamn = kundnamn;
        this.produkt = produkt;
        this.status = "Väntar";
    }

    public String getProdukt() {
        return produkt;
    }

    public void tillagbar() {
        this.status = "";
      
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    @Override
    public String toString() {
        return "Order #" + ordernummer + " | Kund: " + kundnamn + 
               " | Produkt: " + produkt + " | Status: " + status;
    }
}

*/
// import java.util.*;

class Bestallning {
    private int orderNumber;
    private String customerName;
    private Produkt product;
    private OrderStatus status;

    // Korrigerat Product till Produkt
    Bestallning(int a, String b, Produkt c, OrderStatus d) {
        this.orderNumber = a;
        this.customerName = b;
        this.product = c;
        this.status = d;
    }

    int getOrderNumber() { return orderNumber; }
    String getCustomerName() { return customerName; }
    Produkt getProduct() { return product; }
    OrderStatus getStatus() { return status; }
    
    // Setter för status så vi kan ändra till klar
    void setStatus(OrderStatus status) { this.status = status; }

    // Setter - korrigerad för att faktiskt sätta värdet
    void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }

    // För att enkelt kunna skriva ut beställningen i listan
    @Override
    public String toString() {
        return "Order #" + orderNumber + " | Kund: " + customerName + " | Status: " + status;
    }
}

abstract class Produkt {
    abstract void describeProduct();
}


class Kaffe extends Produkt implements Tillagbar {
    @Override
    void describeProduct() { System.out.println("Jag dricker kaffe!"); }
    public void tillagar() { System.out.println("Brygger kaffe!"); }
}

class Macka extends Produkt implements Tillagbar {
    @Override
    void describeProduct() { System.out.println("Jag äter en macka!"); }
    public void tillagar() { System.out.println("Brer en macka!"); }
}

class Flaskvatten extends Produkt {
    @Override
    void describeProduct() { System.out.println("Jag dricker flaskvatten!"); }
}

interface Tillagbar {
    void tillagar();
}

enum OrderStatus { NY, KLAR, HAMTAD }