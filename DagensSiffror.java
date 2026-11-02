public class DagensSiffror {

    // TASK DESCRIPTION: //

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

    // contains the main values for this file, used sorta like the globaly used
    // variables. //
    class dayValues {
        // because the task description gave us names for the 3 states i get the feeling
        // we should set them by name (enum) instead of number (int) as it is later
        // translated to
        enum dayShifts {
            MORNING,
            LUNCH,
            EVENING,
        }

        // keeps track of the ammount of orders/their total cost for each shift
        // individualy
        static int[] ordersPerShift = { 0, 0, 0 };
        static int[] moneyPerShift = { 0, 0, 0 };

        static int openingTime = 0;
        static int closingTime = 2;

    }

    public static void main(String[] args) {

        registerOrder(dayValues.dayShifts.MORNING, 45, 3);
        registerOrder(dayValues.dayShifts.MORNING, 30, 2);
        registerOrder(dayValues.dayShifts.MORNING, 15, 1);

        registerOrder(dayValues.dayShifts.EVENING, 10, 1);
        registerOrder(dayValues.dayShifts.EVENING, 20, 2);
        registerOrder(dayValues.dayShifts.EVENING, 30, 3);

        showDaysStats();
    }

    public static void registerOrder(dayValues.dayShifts dayShift, int price, int ammount) {

        // System.out.println(dayShift + " " + price + " * " + ammount);

        // time starts as a value that wont get through and is then set to something
        // correct based on what dayShift it is
        int time = -1;

        switch (dayShift) {
            case dayValues.dayShifts.MORNING:
                time = 0;
                break;

            case dayValues.dayShifts.LUNCH:
                time = 1;
                break;

            case dayValues.dayShifts.EVENING:
                time = 2;
                break;

            default:
                time = -1;
                break;
        }

        // if time is outside of available hours rejects that registration
        if (time < dayValues.openingTime || time > dayValues.closingTime) {
            System.out.println("not open at that time");
        } else {
            // else adds how many purchases and how much they costed combined
            dayValues.ordersPerShift[time] += ammount;
            dayValues.moneyPerShift[time] += price;
        }

    }

    // collects shift stats and compiles them to get the values of the whole day
    // combined
    static void showDaysStats() {
        int ordersPerDay = 0;
        int moneyPerDay = 0;
        int[] shiftsAverageMoneyPerOrder = { 0, 0, 0 };

        System.out.println("ORDERS");
        // goes through all shifts and appends their values to the total (day)
        for (int i = 0; i < dayValues.closingTime + 1; i++) {

            moneyPerDay += dayValues.moneyPerShift[i];
            ordersPerDay += dayValues.ordersPerShift[i];

            // makes sure we never try to divide by zero
            try {
                shiftsAverageMoneyPerOrder[i] = Math.round(dayValues.moneyPerShift[i] / dayValues.ordersPerShift[i]);
            } catch (Exception e) {
                shiftsAverageMoneyPerOrder[i] = 0;
            }

            // prints out the individual shifts values
            System.out.println("Shift: " + dayValues.dayShifts.values()[i]);
            System.out.println(dayValues.moneyPerShift[i] + "kr / " + dayValues.ordersPerShift[i] + " orders ~ "
                    + shiftsAverageMoneyPerOrder[i] + "kr/per");

        }

        int daysAverageMoneyPerOrder = 0;
        // adds the average of the shift divided by the ammount of shifts to the total,
        // does this for all shifts to get the total (day) average
        for (int j : shiftsAverageMoneyPerOrder) {
            daysAverageMoneyPerOrder += Math.round(j / shiftsAverageMoneyPerOrder.length);
        }

        // prints out the total values for the entire day
        System.out.println("day TOTAL");
        System.out.println(moneyPerDay + "kr / " + ordersPerDay + " orders ~ " + daysAverageMoneyPerOrder + "kr/per");

    }

}
