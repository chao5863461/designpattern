package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

import com.gupaoedu.vip3.pattern.singleton.HungerSingleton.HungerSingleton;

import java.lang.reflect.Constructor;

public class ReflexSingleTest {

    public static void main(String[] args) {

        try {

            Constructor<HungerSingleton> c = HungerSingleton.class.getDeclaredConstructor(null);
            c.setAccessible(true);//强吻，设置权限可以访问私有变量
            HungerSingleton lazy = c.newInstance();

            HungerSingleton lazy2 =  HungerSingleton.getInstance();


            System.out.println(lazy);

            System.out.println(lazy2);

            System.out.println(lazy==lazy2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
