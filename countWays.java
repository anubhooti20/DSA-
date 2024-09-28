/*import java.util.*;
public class countWays {
    public static int way(int n,int[] ans){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ans[n]!=-1){
            return ans[n];
        }
        ans = way(n-1,ans) + way(n-2,ans);
        return ans[n];
    }
    public static void main(String args[]){
        int n=5;
        int ans[]=new int[n+1];
        Arrays.fill(ans,-1);
        System.out.println(way(n, ans));
    }
}*/

import java.util.*;

public class countWays {
    public static int way(int n, int[] ans) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ans[n] != -1) {
            return ans[n];
        }
        ans[n] = way(n - 1, ans) + way(n - 2, ans);
        return ans[n];
    }
    public static int countWaysTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;

        //tabulation loop
        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i]=dp[i-1] + 0;
            }else{
                dp[i]=dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;
        int ans[] = new int[n + 1];
        Arrays.fill(ans, -1);
        System.out.println(way(n, ans));
        System.out.println(countWaysTab(n));
    }
}
