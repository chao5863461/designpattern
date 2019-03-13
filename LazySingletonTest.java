package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

import com.gupaoedu.vip3.pattern.Thread.Executor;

public class LazySingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Executor());
        Thread t2 = new Thread(new Executor());
        t1.start();
        t2.start();
    }
}
