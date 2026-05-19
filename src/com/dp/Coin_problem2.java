package com.dp;
// minimum number of coins to find the amount
public class Coin_problem2 {
    static void main(String[] args) {
        int [] coins={1,3,5};
        int amount=9;
        int dp[][]=new int[coins.length][amount+1];
//        1st colum
        for(int i=0;i<coins.length;i++){
            dp[i][0]=0;
        }
//        1st column
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){
                dp[0][j]=j/coins[0];
            }
            else{
                dp[0][j]=amount+1;
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Integer.min(dp[i-1][j],1+dp[i][j-coins[i]]);
                }
            }
        }
        int ans=dp[coins.length-1][amount];
        if(ans==amount+1){
            System.out.println("Not Possible");
        }
        System.out.println(ans);
    }
}

