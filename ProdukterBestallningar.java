public class ProdukterBestallningar {

    // Registrera en ny beställning
    static Bestallning registerNewOrder(int orderNumber, String customerName, Produkt produkt)  {
        
        // Kontrollerar att en konsol finns innan vi använder den
        java.io.Console console = System.console();

        if (console == null) {
            System.out.println("Ingen konsol tillgänglig. Kör programmet i terminalen.");
            return null;
        }

        String svar = console.readLine("Bekräfta beställningen? (J/N): ");
        
        // Kontrollerar att kunden skriver in något som inte är null, eller något längre än en char
        if (svar == null || svar.length() != 1) {
            System.out.println("Skriv in J eller N.");
            return null;
        }

        char choice = svar.charAt(0);
        
        if (confirmNewOrder(choice))  {
            Bestallning newOrder = new Bestallning(orderNumber, customerName, produkt);

            System.out.println("Köpet godkändes och en ny order har skapats!");
            
            return newOrder;
        }
        
        if (choice == 'N' || choice == 'n')   {
            System.out.println("Köpet har avbrutits.");
        } else {
            System.out.println("Skriv in J eller N för att bekräfta eller avrbyta beställningen.");
        }
        
        // Returnera inget när köpet misslyckats
        return null;       
    }
    

    // Skriv ut kvitto
    static void printKvitto(Bestallning order)  {
        System.out.println(
            "\n=== KVITTO ==="
            + "\nOrdernummer: " + order.getOrderNumber()
            + "\nKundnamn: " + order.getCustomerName()
            + "\nProdukt: " + order.getProduct().getNameOfProduct()
            + "\nPris: " + order.getProduct().getPriceOfProduct() + " kronor"
        );
    }

    // Hantera kundens bekräftelse med J/N
    static boolean confirmNewOrder(char choice)   {
        return choice == 'J' || choice == 'j';
    }
}

class Bestallning   {
    private int orderNumber;
    private String customerName;
    private Produkt product;
    private OrderStatus status;

    // Skapar konstruktor
    Bestallning(int orderNumber, String customerName, Produkt product)  {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.product = product;
        this.status = OrderStatus.NY;
    }

    // Getter - hämta ordernummer
    int getOrderNumber() {
        return orderNumber;
    }

    // Setter - ändra ordernummer
    void setOrderNumber(int newOrderNumber)    {
        this.orderNumber = newOrderNumber;
    }
    // Getter - hämta kundnamn
    String getCustomerName() {
        return customerName;
    }

    // Setter - ändra kundnamn
    void setCustomerName(String newCustomerName)    {
        this.customerName = newCustomerName;
    }

    // Getter - hämta product
    Produkt getProduct() {
        return product;
    }

    // Setter - ändra product
    void setProduct(Produkt newProduct)    {
        this.product = newProduct;
    }

    // Getter - hämta orderstatus
    OrderStatus getOrderStatus() {
        return status;
    }

    // Markera beställningen som klar
    void markOrderAsReady() {
        if (status == OrderStatus.NY)    {
            status = OrderStatus.KLAR;
        } else  {
            System.out.println("Enbart en ny beställning kan göras klar.");
        }
    }

    // Markera beställningen som upphämtad
    void markOrderAsPickedUp()  {
        if (status == OrderStatus.KLAR)  {
            status = OrderStatus.HAMTAD;

        } else  {
            System.out.println("Beställningen måste vara klar innan den kan hämtas.");
        }        
    }
}

abstract class Produkt  {
    // Uppgiften kräver att varje produkt har namn och pris
    private String nameOfProduct;
    private int priceOfProduct;

    Produkt(String nameOfProduct, int priceOfProduct)   {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
    }

    // Getter - hämta namnet på produkten
    String getNameOfProduct()   {
        return nameOfProduct;
    }

    // Setter - ändra namnet på produkten
    void setNameOfProduct(String newNameOfProduct)  {
        this.nameOfProduct = newNameOfProduct;
    }

    // Getter - hämta priset på produkten
    int getPriceOfProduct() {
        return priceOfProduct;
    }

    // Setter - ändra priset på produkten
    void setPriceOfProduct(int newPriceOfProduct)   {
        this.priceOfProduct = newPriceOfProduct;
    }

    abstract void describeProduct();
}

class Kaffe extends Produkt implements Tillagbar {

    Kaffe() {
        super("Kaffe", 25);
    }

    @Override
    void describeProduct()  {
        System.out.println(getNameOfProduct() + " kostar " + getPriceOfProduct() + " kronor.");
    }

    @Override 
    public void tillagar()  {
        System.out.println("Brygger kaffe!");
    }
}

class Macka extends Produkt implements Tillagbar {

    Macka() {
        super("Macka", 45);
    }

    @Override
    void describeProduct()  {
        System.out.println(getNameOfProduct() + " kostar " + getPriceOfProduct() + " kronor.");
    }

    @Override 
    public void tillagar()  {
        System.out.println("Brer en macka!");
    }
}

class Flaskvatten extends Produkt   {

    Flaskvatten()   {
        super("Flaskvatten", 30);
    }

    @Override
    void describeProduct()  {
        System.out.println(getNameOfProduct() + " kostar " + getPriceOfProduct() + " kronor.");
    }
}

interface Tillagbar {
    void tillagar();
}

enum OrderStatus    {
    NY,
    KLAR,
    HAMTAD
}