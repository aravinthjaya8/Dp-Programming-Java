package com.dp;
public class subsetSum {
    static int subset(int []set,int sum){
        int [][]dp=new int[set.length][sum+1];
        for(int i=0;i<set.length;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<=sum;j++){
            if(j==set[0]){
                dp[0][j]=1;
            }
            else {
                dp[0][j]=0;
            }
        }
        for(int i=1;i<set.length;i++){
            for(int j=1;j<=sum;j++){
                if(j<set[i]){
                    dp[i][j]=dp[i-1][j];
                }
                else if(dp[i-1][j]==1){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j-set[i]];
                }
            }
        }
        return dp[set.length-1][sum];
    }
    static void main(String[] args) {
        int []set={2,3,5,7,10};
        int sum=14;
        System.out.println(subset(set,sum));
    }
}
