public class knapsack{
    public static int KnapSack(int val[],int wt[], int W,int n,int dp[][]){
        if(W==0 ||n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){ //valid
            //include
            int ans1= val[n-1]+KnapSack(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2= KnapSack(val, wt, W, n-1, dp);
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
            // return Math.max(ans1,ans2);
        }else{ //not  valid
            // return KnapSack(val, wt, W, n-1, dp);
            dp[n][W] = KnapSack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    } 
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int v = val[i - 1]; // (i-1)th item val
                    int w = wt[i - 1];   // (i-1)th item wt
                    if (w <= j) { // valid
                        int incProfit = v + dp[i - 1][j - w];
                        int excProfit = dp[i - 1][j];
                        dp[i][j] = Math.max(incProfit, excProfit);
                    } else { // invalid
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        print(dp);
        return dp[n][W];
    }
    
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        // int dp[][]=new int[val.length+1][W+1];
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }

        // System.out.println(KnapSack(val, wt, W, val.length,dp));
        System.out.println(knapsackTab(val, wt, W));
    }
}