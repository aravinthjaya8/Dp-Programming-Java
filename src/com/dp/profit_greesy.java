package com.dp;

public class profit_greesy {
    static void main(String[] args) {
        int values[]={60,100,120};
        int weight[]={10,20,30};
        int capacity=50;
        double maxValue=getMaxValue(values,weight,capacity);
        System.out.println(maxValue);
    }

     static double getMaxValue(int[] values, int[] weight, int capacity) {
        double profit=0;
        double []ratio=new double[values.length];
        for(int i=0;i<values.length;i++){
            ratio[i]=(double)values[i]/weight[i];
        }
         for (int i = 0; i <ratio.length-1; i++) {
             for (int j=0;j<ratio.length-i-1;j++){
                 if(ratio[j]<ratio[j+1]){
                     double temp=ratio[j];
                     ratio[j]=ratio[j+1];
                     ratio[j+1]=temp;

                     int temp1=values[j];
                     values[j]=values[j+1];
                     values[j+1]=temp1;

                      temp1=weight[j];
                     weight[j]=weight[j+1];
                     weight[j+1]=temp1;

                 }
             }
         }
         int i=0;
         while (capacity!=0&&i<values.length){
             if(weight[i]<=capacity){
                 profit+=values[i];
                 capacity-=weight[i];
             }
             else{
                 profit+= ((double)capacity/weight[i])*values[i];
                 capacity=0;
             }
             i++;
         }
        return profit;
    }
}
