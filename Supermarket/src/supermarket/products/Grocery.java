package supermarket.products;

import java.util.ArrayList;

public class Grocery {
    private String name;
    private Double price;
    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grocery(String name, Double price, Double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    public double getActualPrice() {
        return price-(price * discount);
    }
    public String display() {
        return "Name: " + name + ", Price: " + price + ", Discount: " + discount;
    }
    public static void main (String[] args) {
        ArrayList<Grocery> cart = new ArrayList<Grocery>();
        Grocery toast = new Grocery("Toast", 15.0, 0.2);
        cart.add(toast);
        System.out.println(toast.display());
        System.out.println(toast.getActualPrice());
        Beverage coke = new Beverage("Coke", 3.0, 0.0,SugarLevel.ZERO);
        cart.add(coke);
        System.out.println(coke.display());
    }
}
