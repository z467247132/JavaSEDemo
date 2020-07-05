package com.zjj;

@FunctionalInterface
interface  Foo{
   public int add(int a,int b);
   public static int mul(int a,int b){return a*b;};
   public static int mul2(int a,int b){return a*b;};
   public default int avg(int a,int b){return a/b;};
   public default int avg2(int a,int b){return a/b;};
}

/**
 *lambda表达式练手。lambda表达式是为了解决java函数式接口声明内部类过于繁琐的问题
 * 1.拷贝小括号  写个右箭头   实现大括号
 * 2.@FunctionalInterface  只允许拥有一个抽象方法
 * 3.default  可以拥有多个
 * 4.static   可以拥有多个
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Foo foo = (int a,int b) -> {
            System.out.println("come in add mothod");
            return a+b;
        };
        System.out.println(foo.add(1, 2));
    }
}
