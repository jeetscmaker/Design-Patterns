package creational;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import static creational.Singleton.print;

public class TestSingleton {
    @SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        print("s1", s1);
        print("s2", s2);

        // Reflection breaks singleton.
        Class clazz = Class.forName("creational.Singleton");
        Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        Singleton s3 = ctor.newInstance();
        print("s3", s3);

        //serialization and deserialization scenario.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/sample/a.ser"));
        oos.writeObject(s2);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/sample/a.ser"));
        Singleton s4 = (Singleton) ois.readObject();
        print("s4", s4);
    }
}

