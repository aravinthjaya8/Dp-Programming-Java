package com.dp;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Frog {

    public static void main(String[] args) {

        int arr[] = {15,5 ,30, 5,30, 25};

        System.out.println(dpMethod( arr));
    }

    public static int frogJump(int n, int arr[]) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // One jump
        int first = frogJump(n - 1, arr) + abs(arr[n] - arr[n - 1]);

        // Two jumps
        int second = Integer.MAX_VALUE;

        if (n > 1) {
            second = frogJump(n - 2, arr)
                    + abs(arr[n] - arr[n - 2]);
        }

        // Minimum energy
        return min(first, second);
    }
    public static int minCost(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return recursive(n-1,arr,dp);
    }

    public static int recursive(int n, int[] arr, int[] dp) {
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        else{
            int jumpOne=recursive(n-1,arr,dp)+abs(arr[n-1]-arr[n]);
            int jumpTow=Integer.MAX_VALUE;
            if(n>1){
                jumpTow=recursive(n-2,arr,dp)+abs(arr[n-2]-arr[n]);
            }
            return dp[n]=min(jumpOne,jumpTow);
        }

    }
    public static int dpMethod(int arr[]){
        int n=arr.length;
        int dp[]=new int [n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int jumpTwo=Integer.MAX_VALUE;
            int jumpOne=dp[i-1]+abs(arr[i]-arr[i-1]);
            if(i>1){
                jumpTwo=dp[i-2]+abs(arr[i]-arr[i-2]);
            }
            dp[i]=min(jumpOne,jumpTwo);
        }
        return dp[n-1];
    }
}