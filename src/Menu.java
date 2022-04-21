// Menu enum class	
public enum Menu {
    //enum list
    MENU1("ROTI CANAI", 2.00),
    MENU2("NASI LEMAK", 5.00),
    MENU3("NASI GORENG", 5.50),
    MENU4("CHICKEN CHOP", 7.50),
    MENU5("MILO AIS", 2.00),
    MENU6("TEA O ICE", 1.50),
    MENU7("MINERAL WATER", 1.00);

    // Menu attributes
    String menuName;
    double price;

    // Menu constructor
    Menu (String m, double p) {
        this.menuName = m;
        this.price = p;
    }

    // Menu methods
    public String getMenuName() {
        return menuName;
    }

    public double getPrice() {
        return price;
    }
}