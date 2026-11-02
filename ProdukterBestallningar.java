public class ProdukterBestallningar {
    public static void main(String[] args)  {
        
    }
}

class Bestallning   {
    private int orderNumber;
    private String customerName;
    private Produkt product;
    private OrderStatus status;
    int orderStatusId = 0;

    // Skapar konstruktor
    Bestallning(int orderNumber, String customerName, Produkt product)  {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.product = product;
        // this.status = status;
    }

    // get the enum Orderstatus value status by integer orderStatusId 
    OrderStatus orderStatusHandler(boolean increment){
        // if (increment) {orderStatusId++;}
        status = OrderStatus.values()[orderStatusId];
        return status;
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

    // Setter - ändra orderstatus
    void setOrderStatus(OrderStatus newStatus)    {
        this.status = newStatus;
    }    
}

abstract class Produkt  {
    abstract void describeProduct();
    

    // Produkt()
}

class Kaffe extends Produkt implements Tillagbar {

    @Override
    void describeProduct()  {
        System.out.println("Jag dricker kaffe!");
    }

    public void tillagar()  {
        System.out.println("Brygger kaffe!");
    }
}

class Macka extends Produkt implements Tillagbar {

    @Override
    void describeProduct()  {
        System.out.println("Jag äter en macka!");
    }

    public void tillagar()  {
        System.out.println("Brer en macka!");
    }
}

class Flaskvatten extends Produkt   {

    @Override
    void describeProduct()  {
        System.out.println("Jag dricker flaskvatten!");
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