import java.util.Arrays;
import java.util.Comparator;

class BlueAstronaut extends Player implements Crewmate{
/*
This file defines a BlueAstronaut, which is a Player and should have all attributes of one.
 Have BlueAstronaut implement the Crewmate interface.

Variables
All variables must be not allowed to be directly modified outside the class in which they
 are declared, unless otherwise stated in the description of the variable.
 Hint: there is a specific visibility modifier that can do this!

The Blue class must have these variables.
Do NOT redeclare any instance variables created in the Player class

numTasks - the number of tasks that needs to be completed as an integer number
taskSpeed - the speed at which the astronaut is completing each task as a positive,
 nonzero integer number */
    private int numTasks;
    private int taskSpeed;
/*    Constructors
    A constructor that takes in the name, susLevel, numTasks, and taskSpeed and
    sets all fields accordingly.
    It must accept the variables in the specified order.
    A constructor that takes in just a name and assigns the following default
    values:
    susLevel: 15
    numTasks: 6
    taskSpeed: 10*/
    public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    public BlueAstronaut (String name) {
        this(name, 15, 6, 10);
    }
/*    Methods

    Do not create any other methods than those specified. Any extra methods will result in
    point deductions. All methods must have the proper visibility to be used where it is
    specified they are used.

    emergencyMeeting()
    A Player that is frozen cannot call an emergency meeting.
    Holds a meeting and votes out (freezes) the most suspicious individual of the Player
    objects, only considering Players that are not frozen
    The player that has the highest susLevel will be accused of being the impostor and will
    be voted off (This could be them!)
    If two players have the same highest susLevel, no player will be voted off.
            Hint: think of an easy way to do this without having to iterate through the entire
    array. Check the Java API for Arrays for a method you can use.
    Make sure to change the frozen variable of the player to true when voting off players
            (don’t call freeze!)
    At the end of the vote, check if the game is over using the provided method in Player.java

    Does not return anything*/
    @Override
    public void emergencyMeeting(){
        if (this.isFrozen()){
            System.out.println("You are frozen!Cannot call meeting");
            return;
        }else{
            Player[] meetings = Player.getPlayers();
            Arrays.sort(meetings,Comparator.comparingInt(Player::getSusLevel).reversed());
            Player mostSus=null;
            int maxSusLevel=-1;
            int count=0;
            for (Player p : meetings) {
                if (!p.isFrozen()&&p!=this){
                    if (maxSusLevel==-1){
                        maxSusLevel=p.getSusLevel();
                        mostSus=p;
                        count=1;
                }else if(p.getSusLevel()==maxSusLevel){
                        count++;
                }else{
                   break;
                    }
                }
            }
            if(count>1){
                System.out.println("Tie!No one out");
                return;
            } else if(count==1){
                mostSus.setFrozen(true);
            }
            gameOver();
        }
    }

/*    completeTask()
    A BlueAstronaut that is frozen cannot complete tasks.
    If taskSpeed is greater than 20, subtract 2 from numTasks. Otherwise, subtract 1 from numTasks.
    If numTasks falls below 0, set it to 0
    After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time),
    Print out “I have completed all my tasks”
    Then reduce BlueAstronaut’s susLevel by 50% (round down)
    Does not return anything.*/
    @Override
    public void CompleteTask(){
        if (isFrozen() || numTasks == 0){
            if(!isFrozen()){
                setSusLevel((int)0.5*getSusLevel());
            }
            return;
        }

        if (taskSpeed>20){
            numTasks-=2;
        }else{
            numTasks-=1;
        }
        if (numTasks<0){
            numTasks=0;
        }
        if (numTasks==0){
            System.out.println("I have completed all my tasks!");
            setSusLevel((int)0.5*getSusLevel());
        }

    }
/*  equals(Object o)
      Two BlueAstronauts are equal if they both have the same name, frozen, susLevel,
  numTasks, and taskSpeed
      Returns a boolean*/
    public boolean equals(Object o){
        if (o instanceof BlueAstronaut){
            BlueAstronaut b = (BlueAstronaut)o;
            return this.compareTo(b)==0 &&
                this.getName().equals(b.getName())&&
                this.getNumTasks()==b.getNumTasks()&&
                this.getTaskSpeed()==b.getTaskSpeed()&&
                this.isFrozen()==b.isFrozen();
        }
        return false;
    }
/*
    toString() - returns a String describing BlueAstronaut as follows:
            "My name is [name], and I have a suslevel of [susLevel]. I am currently (frozen / not
            frozen). I have [numTasks] left over.”
    If susLevel is greater than 15, return the String in all capital letters.
            (Note: replace the values in brackets [] with the actual value)
    You must use the toString() method from the Player class to receive full credit.
*/
    public String toString(){
        String lessthan15 = super.toString()+"I have "+numTasks+" left over.";
        if (getSusLevel()>15){
            return lessthan15.toUpperCase();
        }
        else{
            return lessthan15;
        }
    }

    //Getters and Setters as necessary.
    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
    public int getNumTasks() {
        return numTasks;
    }
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }
}







