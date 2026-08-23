class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                leftQ++;
            } else {
                leftSum += ch - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                rightQ++;
            } else {
                rightSum += ch - '0';
            }
        }

        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        
        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;

        return sumDiff * 2 != qDiff * 9;
    }
}