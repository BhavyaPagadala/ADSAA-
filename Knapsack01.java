//program to implement 0/1 knapsack using java
import java.util.Scanner;
public class Knapsack01 {
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i=0;i<=n;i++) {
            for(int w=0;w<=capacity;w++) {
                if (i==0||w==0) {
                    dp[i][w]=0;
                } 
                else if (weights[i-1]<=w) {
                    dp[i][w] = Math.max(
                            values[i-1]+dp[i-1][w-weights[i-1]],
                            dp[i-1][w]);
                } 
                else {
                    dp[i][w]=dp[i-1][w];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n=sc.nextInt();
        int[] values=new int[n];
        int[] weights=new int[n];
        System.out.println("Enter profits of items:");
        for(int i=0;i<n;i++) {
            values[i] = sc.nextInt();
        }
        System.out.println("Enter weights of items:");
        for(int i=0;i<n;i++) {
            weights[i] = sc.nextInt();
        }
        System.out.print("Enter capacity of knapsack: ");
        int capacity=sc.nextInt();
        int result = knapsack(weights,values,capacity,n);
        System.out.println("Maximum value that can be obtained = " + result);
    }
}
