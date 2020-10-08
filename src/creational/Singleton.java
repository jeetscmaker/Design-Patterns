package creational;

/**
 * A singleton is such a class for which there will be one and only
 * one object created in the given JVM.
 */
public class Singleton {
    private static Singleton instance;

    /* private constructor to stop initialization from outside. */
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("The singleton object is: " + this.hashCode());
    }
}
