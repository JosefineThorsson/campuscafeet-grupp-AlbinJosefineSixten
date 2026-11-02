 
public class Bestallning {
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
        this.status = "Tillagas";
      
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

