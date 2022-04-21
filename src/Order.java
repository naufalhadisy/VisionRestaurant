//Order Class//
public abstract class Order {
    String orderNum;
    double current;
    double balance;
 
//Order Default Constructor//
    Order()
    {
        orderNum = "";
        current = 0.00;
        balance = 0.00;
    }
    
//Order Constructor//
    Order(String orderNum, double current, double balance) {

        this.orderNum = orderNum;
        this.balance = balance;
        this.current = current;
    }

//Order Method//
    public String getOrderNum()
    {
        return orderNum;
    }

    public void currentPayment (double crtPayment)
    {
        System.out.println("My Balance = RM " + balance);
        System.out.println("Current Payment = RM " + crtPayment);

        current += crtPayment;
    }

}