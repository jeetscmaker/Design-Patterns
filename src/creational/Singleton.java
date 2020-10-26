package creational;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * A singleton is such a class for which there will be one and only
 * one object created in the given JVM.
 */
public class Singleton implements Serializable, Cloneable {
	/**
	 * default serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	private static volatile Singleton instance;

    /* private constructor to stop initialization from outside. */
    private Singleton() {
        if (instance != null){
            throw new RuntimeException("Cannot create, please use getInstance()");
        }
        // proceed with instance creation
        System.out.println("Creating instance...");
    }

    /* Double check locking to provide single thread access at a time. */
    public static Singleton getInstance() {
        if (instance == null) { // first null check.
            synchronized (Singleton.class){
                if (instance ==  null){ // second null check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /* Cloning not allowed, so two objects cannot be different. */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /* It does not allow deserialization to create a new object */
    private Object readResolve() throws ObjectStreamException {
        System.out.println("... Read Resolve before deserialization...");
        return instance;
    }

    public static void print(String name, Singleton singleton) {
        System.out.println(String.format("Object : %s, Hashcode : %d", name, singleton.hashCode()));
    }
}
