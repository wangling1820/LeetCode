## 动态规划
- [1025. Divisor Game](https://leetcode.com/problems/divisor-game/)
    - 使用dp数组记录能够获胜的数字,然后从2到N遍历数组,对数组元素进行处理,其中初始化dp[0]=dp[1]=false.
```java
class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false;
        for (int i=2; i<=N; ++i){
            for(int j=i-1; j>0; --j){
                if (i % j == 0){
                    if (!dp[i-j]){
                        dp [i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }
}
```