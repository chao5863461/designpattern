package com.gupaoedu.vip3.pattern.singleton.HungerSingleton;

/**
 * 单例模式的条件
 * 1.构造方法私有化
 * 2.公有对外访问实例化对象的方法
 * 3.静态变量私有化
 */
public class HungerSingleton {

    /**
     *     1.类加载的时候已经实例化好了，只实例化一次，因此是线程安全的
     *     2.但是不管用不用都会创建实例，对内存资源消耗大
     *     3.使用final关键词，防止反射覆盖实例的值
     */
    private static final HungerSingleton singleton = new HungerSingleton();

    private HungerSingleton (){
        if(singleton!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static HungerSingleton getInstance(){

        return singleton;
    }

}
