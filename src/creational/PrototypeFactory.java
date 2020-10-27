package creational;

import java.util.HashMap;
import java.util.Map;

/**
 * The fundamental idea behind Prototype design pattern is returning a new copy
 * of the object everytime. It can be thought of just opposite of what Singleton
 * does. A Singleton returns a unique object always, a Prototype returns a copy
 * or clone of the original object.
 */

interface Person {
    Person clone();
}

class Tom implements Person {
    private final String NAME = "Tom";

    @Override
    public Person clone() {
        return new Tom();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Robert implements Person {
    private final String NAME = "Robert";

    @Override
    public Person clone() {
        return new Robert();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Harry implements Person {
    private final String NAME = "Harry";

    @Override
    public Person clone() {
        return new Harry();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Factory {
    private static final Map<String, Person> prototypes = new HashMap<>();

    static {
        prototypes.put("tom", new Tom());
        prototypes.put("robert", new Robert());
        prototypes.put("harry", new Harry());
    }

    public static Person getPrototype(String type) {
        try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}

public class PrototypeFactory {
    public static void main(String[] args) {
        /* The different values of hashcode prove that the two prototypes are different.
         * In case of singleton, hashcode will give same value for a given class's instances.
         * */
        Person typeTom = Factory.getPrototype("tom");
        Person typeTom2 = Factory.getPrototype("tom");
        System.out.println("Tom1: " + typeTom.hashCode() + ", " + "Tom2: " + typeTom2.hashCode());

        Person typeRobert = Factory.getPrototype("robert");
        Person typeRobert2 = Factory.getPrototype("robert");
        System.out.println("Robert1: " + typeRobert.hashCode() + ", " + "Robert2: " + typeRobert2.hashCode());

        Person typeHarry = Factory.getPrototype("harry");
        Person typeHarry2 = Factory.getPrototype("harry");
        System.out.println("Harry1: " + typeHarry.hashCode() + ", " + "Harry2: " + typeHarry2.hashCode());
    }
}
