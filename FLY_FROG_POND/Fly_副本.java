public class Fly{
    private double mass;
    private double speed;
    public Fly(double initMass,double initSpeed){
        this.mass=initMass;
        this.speed=initSpeed;
        }
    public Fly(double initMass){
        this(initMass,10.0);
        }
    public Fly() {
        this(5.0);
    }
    public double getMass(){
        return this.mass;
        }
    public void setMass(double mass){
        if (mass >= 0) { // 验证质量是否为正数
           this.mass = mass;
       }
        }
    public double getSpeed(){
        return this.speed;
    }
    public void setSpeed(double speed){
        if (speed >= 0) { // 验证速度是否为非负数
           this.speed = speed;
       }
    }
    @Override
    public String toString() {
        if (this.mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", this.speed);
        } else {
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
        }
    }
    public void grow(int addMass){
            this.mass+=addMass;
            if (this.mass<20){
                this.speed+=addMass;
                    }else{
                 this.speed-=0.5*(this.mass-20);       
        }
        }
    public boolean isDead(){  
        return this.mass==0;
        }
        }