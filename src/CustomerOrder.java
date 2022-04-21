public class CustomerOrder extends Order implements Total {
    String custName;

    CustomerOrder(String cN)
    {
        super("01", 0.00, 50.00);
        custName = cN;
    }

    @Override
    public double calcTotal()
    {
        double totalPrice = 0.0;
        if (current > balance) {
            current = 0;
        } else {
            double total = current + (current * TOTAL_TAX);
            totalPrice = total;
        }
        return totalPrice;
    }

    public void displayTotalPayment()
    {
        if (balance < calcTotal() || calcTotal() == 0)
        {
            System.out.println("\nInsufficient Balance! ");

        }

        else
        {
            System.out.println("\nTotal Payment (inc. TAX): RM " + calcTotal());
            balance -=  calcTotal();
            System.out.println("Balance After Order: RM " + balance );
        }
    }
}