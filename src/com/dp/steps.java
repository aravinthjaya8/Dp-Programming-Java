package com.dp;

public class steps {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public  static int step1(int val){
        if(val==0||val==1){
            return 1;
        }
        int left=step1(val-1);
        int right=step1(val-2);
        return left+right;
    }
    public static int climbStairs(int n){
        int arr[]=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
