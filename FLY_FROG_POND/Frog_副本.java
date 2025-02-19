public class Frog{
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    
    private static String species="Rare Pepe";
    
    private static final int DEFAULT_AGE=5;
    private static final double DEFAULT_TONGUE=5;
    
    public Frog(String name,double ageInYears){
        this(name,(int)(12*ageInYears),DEFAULT_TONGUE);
        }
    
    public Frog(String name,int age,double tongueSpeed){
        this.name=name;
        this.age=age;
        this.tongueSpeed=tongueSpeed;
        this.isFroglet=(age>1)&&(age<7);
        }
    
    public Frog(String name){
        this(name,DEFAULT_AGE,DEFAULT_TONGUE);
    }


    public void grow(int addMonth){
        for (int i=1; i<=addMonth;i++){
                age+=1;
                if (age<=12){
                        tongueSpeed+=1;
                        }
                else if (age<=30){
                }else{
                        tongueSpeed-=1;
                        }
        }
        tongueSpeed=(tongueSpeed<5)?5:tongueSpeed;
        isFroglet=(age>1)&&(age<7);
        }

    public void grow(){
        grow(1);
        }
    
    public void eat(Fly prey){
        if (!prey.isDead()){
                  if(tongueSpeed>=prey.getSpeed()){
                          if (prey.getMass()>=(0.5*age)){
                                  grow();
                                 }
                          prey.setMass(0);
                          }else{
                              prey.grow(1);
                              }
                    }
        
        }
    @Override
    public String toString(){
        if(isFroglet){
                return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", this.name,this.age,this.tongueSpeed);
            } else {
                return String.format("My name is %s and I’m a rare frog.I’m %d months old and my tongue has a speed of %.2f.", this.name,this.age,this.tongueSpeed);
            }
                }
    public static String getSpecies(){
        return species;
        }
    public static void setSpecies(String newSpecies){
            species=newSpecies;
        }
        }