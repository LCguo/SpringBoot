package com.mine.springboot.module.test.service.impl;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.mine.springboot.module.test.service.ITestService;
import com.mine.springboot.module.test.service.entity.User;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceImplTest {

    @Autowired
    ITestService testService;
    @Test
    void testRedis() {
        System.out.print(testService.testReturnString());
    }

    @Test
    void testReturnString() {
/*        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(7);
        set.add(1);
        System.out.print(set.toString());*/
        Set<Integer> set = new LinkedHashSet<>();
        set.add(4);
        set.add(5);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(7);
        set.add(1);
        System.out.print(set.toString());
    }

    @Test
    void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", 123);
        map.put("3", 123);
        map.put("4", 123);
        map.put("2", 123);
        map.put("15", 123);
        map.put("14", 123);
        map.put("1423", 123);
        map.put("1324", 123);
        map.put("131", 123);
        map.put("12", 123);
        map.put("11", 123);
        map.put("1", 123);
    }

    @Test
    void testThread() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(true) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "is running");
                    try{
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    void printhello() {
        System.out.print("hello");
    }

    @Test
    void testClass() {
        try {
            Class clazz = Class.forName("com.mine.springboot.module.test.service.entity.User");
/*            Method[] methods = clazz.getDeclaredMethods();
            for(Method method:methods) {
                System.out.println(method.toString());
            }
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for(Constructor constructor:constructors) {
                System.out.println(constructor.toString());
            }*/
            User user = (User)clazz.newInstance();
            user.setUsername("123");
            user.setPassword("456");
            System.out.print(user.toString());
            Constructor constructor = clazz.getDeclaredConstructor(java.lang.String.class, java.lang.String.class);
            User user2 = (User)constructor.newInstance("789","111");
            System.out.print(user2.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFanxingE() {
        String[] s = new String[10];
        s[0] = "123";
        s[1] = "adsda";
        s[2] = "4213";
        printArray(s);

        Integer[] i = new Integer[10];
        i[0] = 123;
        i[1] = 31321;
        i[2] = 545;
        i[3] = 123;
        printArray(i);

    }
    public static <E> void printArray(E[] inputArray) {
        for(E e:inputArray) {
            System.out.printf("%s\n", e);
        }
    }
    @Test
    void testFanxingT() {
        Box<Integer> b = new Box<>();
        b.setT(1);
        Box<Character> c = new Box<>();
        c.setT('1');

        System.out.println(b.getT());
        System.out.println(c.getT());
    }
    @Data
    public class Box<T> {
        private T t;
    }

    class MyValue {
        private List<Observer> observers
                = new ArrayList<Observer>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }

        public void attach(Observer observer){
            observers.add(observer);
        }

        public void notifyAllObservers(){
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }
    abstract class Observer {
        protected MyValue subject;
        public abstract void update();
    }
    class PrinterObserver extends Observer{
        public PrinterObserver(MyValue subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Printer: " + subject.getState() );
        }
    }
    class EmailObserver extends Observer{

        public EmailObserver(MyValue subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Email: "+ subject.getState() );
        }
    }
    class FileObserver extends Observer{

        public FileObserver(MyValue subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("File: " + subject.getState());
        }
    }
    @Test
    public void main() {
        MyValue subject = new MyValue();

        new FileObserver(subject);
        new EmailObserver(subject);
        new PrinterObserver(subject);

        subject.setState(15);

        subject.setState(10);
    }
}