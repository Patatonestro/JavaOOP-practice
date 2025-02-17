package supermarket.products;

public class Beverage extends Grocery{
    private SugarLevel sugarLevel;

    public SugarLevel getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(SugarLevel sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public Beverage(String name, Double price, Double discount, SugarLevel sugarLevel) {
        super(name, price, discount);
        this.sugarLevel = sugarLevel;
    }

    public String display() {
        return (super.display()+"SugarLevel: "+sugarLevel);
    }
}
