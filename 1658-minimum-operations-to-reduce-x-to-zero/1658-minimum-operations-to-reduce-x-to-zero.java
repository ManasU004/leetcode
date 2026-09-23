class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is 0, we must take all elements
        if (target == 0) return nums.length;
        // If target is negative, x is greater than sum of all elements
        if (target < 0) return -1;

        int left = 0;
        int currentSum = 0;
        int maxLen = -1;

        // Two-pointer / Sliding Window to find longest subarray with sum == target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}