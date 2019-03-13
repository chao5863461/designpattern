package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

import sun.print.resources.serviceui_it;

import java.io.Serializable;

/**
 * 懒汉单例，线程不安全，由于类加载时不会实例化，因此比恶汉单例节约内存空间
 */
public class LazySingleton implements Serializable {

    private static LazySingleton lazy = null;

    private LazySingleton(){
        //解决反射破坏实例
        if(lazy!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //加锁保证线程安全，但是锁住整个方法，会导致多线程下，很多线程阻塞，影响性能
    public static synchronized LazySingleton getInstance(){
        //判空，保证唯一实例,假如已经有实例了
        if(null == lazy){
            lazy = new LazySingleton();
     }
        return lazy;
    }

    //重写ReadResolve

    public Object readResolve(){
        return lazy;
    }

}
