package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

public class LazyDubboLockSingleton {

    //加入volitile，防止指令重排
    private static volatile LazyDubboLockSingleton lazy = null;

    private LazyDubboLockSingleton(){
        if(lazy!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static LazyDubboLockSingleton getInstance(){
        //防止多线程阻塞。如果有线程已经获得对象锁，实例化了，其他线程直接返回实例化的对象
        if(lazy == null){
            synchronized (LazyDubboLockSingleton.class){
                if(lazy == null){
                    lazy = new LazyDubboLockSingleton();
                    /**
                     * 存在指令重排问题
                     * 1.给对象分配内存空间
                     * 2.初始化对象
                     * 3.将lazy和内存空间绑定在一起
                     *
                     * 多线程环境下存在指令重排，当Thread1实例化时，由于指令重排导致2和3执行顺序颠倒，先执行了3，
                     * 此时Thread2刚好进入到第一个判空，由于lazy已经和内存空间绑定一起，因此Thread2直接返回lazy，
                     * 而Thread1还没有给lazy初始化对象，此时Thread2返回的lazy会报错
                     */
                }
            }
        }
        return lazy;
    }
}
