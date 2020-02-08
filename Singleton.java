//实现Singleton模式

//可行的解法1：双重检测机制（加同步锁前后两次判断实例是否已存在）
public class Singleton {
    private Singleton(){}

    private static Singleton instance=null;
    //静态工厂方法：getInstance方法称为工厂方法，生成对象的方法
    public static Singleton getInstance(){
        if(instance==null){
            //加上同步锁和双重检验机制
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}

//【推荐解法1】：在类创建的同时就实例化Singleton(饿汉模式)
/*
public class Singleton1 {
    private Singleton1() {}
    private static final Singleton1 instance = new Singleton1();
    //静态工厂方法
    public static Singleton1 getInstance() {
        return instance;
    }
}


//【推荐解法2】：静态内部类（实现按需创建实例）
/*
public class Singleton2 {
    private static class SingletonHolder {
        private static final Singleton2 instance = new Singleton2();
    }
    private Singleton2 (){}
    public static final Singleton2 getInstance() {
        //第一次调用getInstance，涉及到了SingletonHolder的引用，
        //静态内部类的实例才会真正装载
        return SingletonHolder.instance;
    }
}
*/