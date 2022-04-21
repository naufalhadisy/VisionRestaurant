 //OrderList Class
public class OrderList extends Order {
    //OrderList Attributes
    String menuName;
    double price;
    int quantity;

    //OrderList Constructor
    OrderList (String mN, double p, int q)
    {
        menuName = mN;
        price = p;
        quantity = q;
    }

    //OrderList Method//
    public String getMenuName() {
        return menuName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}