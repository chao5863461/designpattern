package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableSingleTest {

    /**
     * 序列化破坏单例，当类中有构造方法时，在ois中会进行实例化，
     * 实例化以后会检查类中是否存在readResolve方法，如果存在，则覆盖实例化的对象为单例模式
     * 中实例的结果
     * @param args
     */
    public static void main(String[] args) {
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = null;

        try{
            FileOutputStream fos = new FileOutputStream("seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lazy1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lazy2 = (LazySingleton) ois.readObject();
            System.out.println(lazy1==lazy2);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
