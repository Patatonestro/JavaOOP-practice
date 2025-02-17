package supermarket.products;

public class Dairy extends Grocery{
    private Fat fat;

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }


    public Dairy(String name, Double price, Double discount,Fat fat){
        super(name, price, discount);
        this.fat=fat;
    }
    public String display(){
        return (super.display()+"Fat:"+fat);
    }
}
