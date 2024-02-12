package com.myblog.myblog1;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Predicate;

public class TestClass1 {


    public static void main(String[] args) {
        Predicate<Integer> val=y->y%2==0;
        boolean result = val.test(10);
        System.out.println(result);
    }
}
