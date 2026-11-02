public class DagensSiffror {

    // Del 4 – Dagens siffror

        // 1. Dela in dagen i tre pass: förmiddag, lunch och eftermiddag. Använd en
        // int[] med tre platser för att räkna hur många order som registrerats under
        // varje pass.

        // 2. Fråga vilket pass ordern hör till när ni registrerar den. Öka rätt plats i
        // arrayen.

        // 3. Använd en enhanced loop för att räkna totalt antal beställningar från
        // arrayen.

        // 4. Räkna ut dagens omsättning från bekräftade beställningar och deras
        // genomsnittliga ordervärde. Om inga beställningar finns, visa 0 kr i stället
        // för att dividera med noll.

    // Visa åtminstone: antal beställningar, omsättning och antal per pass. Extra:
    // antal per produkt, unika produkter och sorterade kundnamn.

    class dayValues{
        enum daysPasses {
            MORNING,
            LUNCH,
            EVENING,
        }
        
        static int[] ordersPerPass = {0,0,0};
        static int[] moneyPerPass = {0,0,0};

        static int openingTime = 0;
        static int closingTime = 2;

    }

    public static void main(String[] args) {

        registerOrder(dayValues.daysPasses.MORNING, 45, 3);
        registerOrder(dayValues.daysPasses.MORNING, 30, 2);
        registerOrder(dayValues.daysPasses.MORNING, 15, 1);
        
        registerOrder(dayValues.daysPasses.EVENING, 10, 1);
        registerOrder(dayValues.daysPasses.EVENING, 20, 2);
        registerOrder(dayValues.daysPasses.EVENING, 30, 3);

        showDaysStats();
    }

    public static void registerOrder(dayValues.daysPasses daysPass, int price, int ammount){

        int time = -1;
        
        switch (daysPass) {
            case dayValues.daysPasses.MORNING:
                time = 0;
                break;

            case dayValues.daysPasses.LUNCH:
                time = 1;
                break;

            case dayValues.daysPasses.EVENING:
                time = 2;
                break;
        
            default:
                time = -1;
                break;
        }

        if (time < dayValues.openingTime || time > dayValues.closingTime){
            System.out.println("not open at that time");
        } else {
            dayValues.ordersPerPass[time] += ammount;
            dayValues.moneyPerPass[time] += price;
        }
        

    }

    static void showDaysStats(){
        int ordersPerDay = 0; 
        int moneyPerDay = 0; 
        int[] averagePerPass = {0,0,0};

        System.out.println("ORDERS");
        // int c = 0;
        for (int i = 0; i < dayValues.closingTime+1; i++) {

            moneyPerDay += dayValues.moneyPerPass[i];
            ordersPerDay += dayValues.ordersPerPass[i];

            try{
                averagePerPass[i] = Math.round(dayValues.moneyPerPass[i]/dayValues.ordersPerPass[i]);
            } catch (Exception e) {
                averagePerPass[i] = 0;
            }



            System.out.println("Pass: " + dayValues.daysPasses.values()[i]);
            System.out.println(dayValues.moneyPerPass[i] + "kr / " + dayValues.ordersPerPass[i] + " orders ~ " + averagePerPass[i] + "kr/per");
            
        }
        int averagePerDay = 0;

        for (int j : averagePerPass) {
            averagePerDay += Math.round(j/averagePerPass.length);
        }

        System.out.println("day TOTAL");
        System.out.println(moneyPerDay + "kr / " + ordersPerDay + " orders ~ " + averagePerDay + "kr/per");

    }

}
