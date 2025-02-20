/*
This Java file is a driver, meaning it will run the simulation. You can also use it to test your code.
Here are some basic tests to get you started with Amidst Us. These tests are my no means comprehensive,
so be sure to create your own!

This is just to show an example of object implementation to see how objects interact with each other.
Feel free to play around with different values and method callings, especially using toString to check
the values after every step! This will NOT be turned in.
*/

public class Gameplay {
    public static void main(String[] args) {
        /*Create a BlueAstronaut with the following fields:

        name = “Bob”, susLevel = 20, numTasks = 6, taskSpeed = 30
        Create a BlueAstronaut with the following fields:

        name = “Heath”, susLevel = 30, numTasks = 3, taskSpeed = 21
        Create a BlueAstronaut with the following fields:

        name = “Albert”, susLevel = 44, numTasks = 2, taskSpeed = 0
        Create a BlueAstronaut with the following fields:

        name = “Angel”, susLevel = 0, numTasks = 1, taskSpeed = 0
        */
        BlueAstronaut one = new BlueAstronaut("Bob",20,6,30);
        BlueAstronaut two = new BlueAstronaut("Heath",30,3,21);
        BlueAstronaut three = new BlueAstronaut("Albert",44,2,0);
        BlueAstronaut four = new BlueAstronaut("Angel",0,1,0);
        /*
        Create a RedAstronaut with the following fields:
        name = “Liam”, susLevel = 19, skill = "experienced"*/
        RedAstronaut five = new RedAstronaut("Liam",19, "experienced");
      /*  Create a RedAstronaut with the following fields:

        name = “Suspicious Person”, susLevel = 100, skill = "expert"*/
        RedAstronaut six = new RedAstronaut("Suspicious Person",100,"expert");

       /* Have the objects do the following:

        Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:
        Bob should have: susLevel = 30, frozen = false*/
        five.sabotage(one);
        System.out.println(one.toString());
       /* Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
        Nothing should happen*/
        five.freeze(six);
        System.out.println(six.toString());
/*        Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
        Liam should have: susLevel = 19
        Albert is now frozen*/
        five.freeze(three);
        System.out.println(five.toString());
        System.out.println(three.toString());
      /*  Have BlueAstronaut Albert call an emergency meeting:
        Nothing should happen since he is frozen*/
        /*Have RedAstronaut Suspicious Person call an emergency meeting:
        This will result in a tie between Bob and Heath, so nothing should happen*/
        six.emergencyMeeting();
        System.out.println(one.toString());
        System.out.println(two.toString());
       /* Have BlueAstronaut Bob call an emergency meeting:
        Suspicious Person should have: frozen = true*/
        one.emergencyMeeting();
        System.out.println(six.toString());
     /*   Have BlueAstronaut Heath complete tasks:
        Heath should have: numTasks = 1
        Have BlueAstronaut Heath complete tasks:
        “I have completed all my tasks” should be printed to console
        Heath should have: numTasks = 0, susLevel = 15
        Have BlueAstronaut Heath complete tasks:
        Nothing should happen*/
        two.CompleteTask();
        System.out.println(two.toString());
        two.CompleteTask();
        System.out.println(two.toString());
        two.CompleteTask();
        System.out.println(two.toString());
    /*
    Play yourself I am tireeeed:(
    Have RedAstronaut Liam freeze Angel:
    Angel should have: frozen = false
    Liam should have: susLevel = 38
    Have RedAstronaut Liam sabotage Bob twice:
    Bob should have: susLevel = 46 (30 -> 37 -> 46)
    Have RedAstronaut Liam freeze Bob:
    Bob should have: frozen = true
    Now there are two options going forward

    Have BlueAstronaut Angel call emergency meeting:
    Liam should have: frozen = true
            “Crewmates win!” should be printed to console
            Or

    Have RedAstronaut Liam call sabotage on Heath 5 times:
    Heath should have: susLevel = 41 (15->18->22->27->33->41)
    Have RedAstronaut Liam freeze Heath:
    Heath should have: frozen = true
            “Impostors win!” should be printed to console*/
    }

}

