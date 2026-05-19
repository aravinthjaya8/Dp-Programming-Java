package com.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class fib {
    static int count=0;
    static int []mem;
    public static void main(String[] args) {
        int number=20;
        mem=new int[number+1];
        Arrays.fill(mem,-1);
        System.out.println(Findfib(number)+" Count : "+count);
    }
    public static int Findfib(int val){
        count++;
        if(val==1){
            mem[val]=1;
            return 1;
        }
        if(val==0){
            mem[val]=0;
            return 0;
        }
         int res=Findfib(val-1)+Findfib(val-2);
        mem[val]=res;
        return res;
    }
}
