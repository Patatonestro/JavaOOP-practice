public interface Impostor {
    public abstract void sabotage(Player p);
    public abstract void freeze(Player p);
}
/*Impostor.java

This file defines an interface with the name Impostor.
Impostors will be able to mess with Players through sabotage and freeze tagging them.

Methods
freeze(Player p)
Abstract method that takes in a Player object and does not return anything
        (Note: any class that implements Impostor must provide a method definition for this method)
sabotage(Player p)
Abstract method that takes in a Player object and does not return anything
        (Note: any class that implements Impostor must provide a method definition for this method)*/

