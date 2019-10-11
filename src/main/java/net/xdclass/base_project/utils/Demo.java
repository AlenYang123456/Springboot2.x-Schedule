package net.xdclass.base_project.utils;

/**
 * @Author: 杨强
 * @Date: 2019/10/7 21:17
 * @Version 1.0
 * @Discription
 */
class Demo {
    private static volatile Demo ourInstance = null;

    public static Demo getInstance() {
        if (ourInstance == null) {
            synchronized (Object.class) {
                if (ourInstance == null) {
                    ourInstance = new Demo();
                    return ourInstance;
                }
            }
        }
        return ourInstance;
    }

    private Demo() {
    }
}

class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Demo instance = Demo.getInstance();
                System.out.println(instance);
            }).start();
        }

    }
}
