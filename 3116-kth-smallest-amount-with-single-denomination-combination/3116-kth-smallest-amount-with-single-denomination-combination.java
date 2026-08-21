import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        
        long low = 1;
        long high = minCoin * (long) k;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countMultiples(coins, mid) >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }

        return result;
    }

    private long countMultiples(int[] coins, long x) {
        int n = coins.length;
        long count = 0;

        int totalSubsets = 1 << n;
        for (int mask = 1; mask < totalSubsets; mask++) {
            long lcmVal = 1;
            int bitsCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitsCount++;
                    lcmVal = lcm(lcmVal, coins[i]);
                    if (lcmVal > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) continue;

            if (bitsCount % 2 != 0) {
                count += x / lcmVal;
            } else {
                count -= x / lcmVal;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}