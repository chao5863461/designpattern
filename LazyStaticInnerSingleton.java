package com.gupaoedu.vip3.pattern.singleton.LazySingleton;

/**
 * 使用静态内部类，当外部调用实例化方法时，静态类进行实例化
 *
 *
 */
public class LazyStaticInnerSingleton{

    private LazyStaticInnerSingleton (){
        if(LazyHolder.LAZY!=null){
            throw new RuntimeException("不允许多例");
        }
    }

    public static LazyStaticInnerSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    public static class LazyHolder{
        //当调用getInstance时，才进行实例化，使用final防止变量被覆盖
        private static final LazyStaticInnerSingleton LAZY = new LazyStaticInnerSingleton();
    }
}
