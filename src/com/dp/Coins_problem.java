package com.dp;

public class Coins_problem {
    static void main(String[] args) {
//        int []coins={1,2,5,10};
        int []coins={2,3,5};
        int amount=5;
        int [][]dp=new int[coins.length][amount+1];
//        1st colum
        for(int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
//        1st row
            for(int j=1;j<=amount;j++){
                if(j%coins[0]==0){
                    dp[0][j]=1;
                }
                else{
                    dp[0][j]=0;
                }
            }
            for(int i=1;i<coins.length;i++){
                for(int j=1;j<=amount;j++){
                    if(j<coins[i]){
                        dp[i][j]=dp[i-1][j];
                    }
                    else{
                        dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                    }
                }
            }
        System.out.println(dp[coins.length-1][amount]);

    }
}
