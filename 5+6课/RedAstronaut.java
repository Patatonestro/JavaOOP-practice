import java.util.Arrays;
import java.util.Comparator;

/*
RedAstronaut.java

This file defines a RedAstronaut, which is a Player and should have all attributes of one.
Have RedAstronaut implement the Impostor interface.
*/
public class RedAstronaut extends Player implements Impostor{

    /*Variables
    All variables must be not allowed to be directly modified outside the class in which they
            are declared, unless otherwise stated in the description of the variable.
    Hint: there is a specific visibility modifier that can do this!

    The Red class must have these variables.
    Do NOT re-declare any of the instance variables declared in Player class:

    skill - a String that represents skill of the Red crewmate a String value of either
            inexperienced, experienced, or expert.*/
    private String skill;
/*    Constructors
    A constructor that takes in the name, susLevel, and skill and sets all fields accordingly.
    It must accept the variables in the specified order.
     Assume that the passed in parameter for skill will be one of the
     three values, although it may have different capitalization.
            Hint: There is a specified keyword in L12 to access the
            superclass’s constructor.
    A constructor that takes in just a name and assigns the following
    default values:
    susLevel: 15
    skill: experienced
    */
    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill=skill;
    }
    public RedAstronaut(String name){
        this(name, 15, "experienced");
    }
/*    Methods
    Do not create any other methods than those specified
    Any extra methods will result in point deductions. All methods must have the proper visibility to be
    used where it is specified they are used.
    emergencyMeeting()
    A Player that is frozen cannot call an emergency meeting.
    Holds a meeting and votes out (freezes) the most suspicious Player, only considering Players that are not frozen
    The player that has the highest susLevel (that is NOT the current impostor calling the meeting) will be accused of being the impostor and will be voted off
    If two players have the same highest susLevel, no player will be voted off.
            Hint: think of an easy way to do this without having to iterate through the entire array. Check the Java API for Arrays for a method you can use
    Make sure to change the frozen variable of the player to true when voting off players (don’t call the freeze method!)
    At the end of the vote, check if the game is over using the provided method in Player.java
    Does not return anything  */
    @Override
    public void emergencyMeeting(){
        if (this.isFrozen()){
            System.out.println("You are frozen!Cannot call meeting");
            return;
        }else{
            Player[] meetings = Player.getPlayers();
            Arrays.sort(meetings, Comparator.comparingInt(Player::getSusLevel).reversed());
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
                        count+=1;
                    }else{
                        break;
                    }
                }
            }
            if(count>1){
                System.out.println("Tie!No one out");
                return;
            }else if(count==1){
                mostSus.setFrozen(true);
            }
            gameOver();
        }
    }
 /*   freeze(Player p)
    Implements the method provided in the Impostor interface.
    It is not possible to freeze another Impostor, and an Impostor that is frozen cannot
     attempt to freeze. If the passed in Player is an Impostor,
     the method should end. Freezing an already frozen Player should also do nothing.
  */
/*    A freeze is successful if the RedAstronaut’s susLevel is less than the Player’s
    If the freeze is unsuccessful, the RedAstronaut’s susLevel doubles (multiply the current susLevel by 2)
    Remember to change the frozen boolean value for the Crewmate as needed.
    After the freeze attempt, check if the game is over using the provided method in Player.java
    Does not return anything*/
    @Override
    public void freeze(Player p){
        if(p instanceof Impostor||isFrozen()||p.isFrozen()){
            return;
        }
        if (this.compareTo(p)<0){
            p.setFrozen(true);
        }else{this.setSusLevel((int) 2*getSusLevel());}
        gameOver();
    }
/*    sabotage(Player p)
    It is not possible to sabotage another Impostor, and an Impostor that is frozen cannot sabotage.
            Also, sabotaging a frozen Player should do nothing.
    If the Impostor’s susLevel is under 20, through shifty maneuvers and cunning words, they are able to increase
    the Crewmate’s susLevel by 50%
    Otherwise, they can only manage to increase the Crewmate’s susLevel by 25%
            (Note: In both cases, the the Crewmate’s susLevel is rounded down to the nearest int value)
    Does not return anything*/
    public void sabotage(Player p){
        if(p instanceof Impostor||isFrozen()||p.isFrozen()){
            return;
        }
        if (getSusLevel()<20){
            p.setSusLevel((int) (1.5*p.getSusLevel()));
            }else{
            p.setSusLevel((int) (1.25*p.getSusLevel()));
        }
    }
/*    equals(Object o)
    Two Red are equal if they both have the same name, frozen, susLevel, and skill
    Returns a boolean*/
    @Override
    public boolean equals(Object o){
        if (o instanceof Impostor){
            RedAstronaut c = (RedAstronaut)o;
            return this.compareTo(c)==0 &&
                    this.getName().equals(c.getName())&&
                    this.skill.equals(c.getSkill())&&
                    this.isFrozen()== c.isFrozen();
        }
        return false;
    }
/*    toString() - returns a String describing RedAstronaut as follows:
            (Note: replace the values in brackets [] with the actual value)
            "My name is [name], and I have a suslevel of [susLevel]. I am currently (frozen / not frozen). I am an [skill] player!”
    If susLevel is greater than 15, return the String in all capital letters.
    You must use the toString() method from the Player class to receive full credit.*/
    public String toString(){
        String lessthan15 = super.toString()+"I am an "+skill+" player!";
        if (getSusLevel()>15){
            return lessthan15.toUpperCase();
        }
        else{
            return lessthan15;
        }
    }
    /*Getters and Setters as necessary.*/
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}









