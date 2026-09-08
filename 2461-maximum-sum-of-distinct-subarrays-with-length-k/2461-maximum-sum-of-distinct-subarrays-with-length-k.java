import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the element is already in the set, shrink the window from the left
            // until the duplicate is removed
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add the current element to the set and window sum
            set.add(nums[right]);
            currentSum += nums[right];

            // If the window size reaches k, check if it's the maximum sum
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Slide the left boundary forward to maintain a maximum window length of k
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}