public class Pond{
    public static void main(String[] args) {
        Frog peepo = new Frog ("Peepo");
        Frog pepe = new Frog ("Pepe", 10, 15);
        Frog peepaw = new Frog ("Peepaw", 4.6);
        Frog anyName = new Frog ("Any Name"
        , 10, 10);
        // Fly instances
        Fly oneMass = new Fly(1, 3);
        Fly sixMass = new Fly(6);
        Fly flyAny = new Fly(10, 10);
        // step 1
        Frog.setSpecies ("1331 Frogs");
        // step 2
        System.out.println(peepo);
        // // step 3
        peepo.eat(sixMass);
        // // step 4
        System.out.println(sixMass);
        // // step 5
        peepo.grow(8);
        // // step 6
        peepo.eat (sixMass);
        // // step 7
        System.out.println(sixMass);
        // // step 8
        System.out.println(peepo);
        // // step 9
        // System.out.println(anyName);
        // // step 10
        // peepaw.grow (4);
        // // step 11
        // System.out.println(peepaw);
        // // step 12
        // System.out.println(pepe);
}
}
