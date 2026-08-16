class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        int cnt0 = cnt[0];
        int cnt1 = cnt[1];
        int cnt2 = cnt[2];

        // Case 1: cnt0 is even
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }

        // Case 2: cnt0 is odd
        return Math.abs(cnt1 - cnt2) > 2;
        
        
    }
}