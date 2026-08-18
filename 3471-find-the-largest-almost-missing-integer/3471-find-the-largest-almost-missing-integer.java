import java.util.*;
class Solution {
    public int largestInteger(int[] nums, int k) {int n = nums.length;
        Map<Integer, Integer> subarrayCount = new HashMap<>();

        // Generate all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueInSubarray = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueInSubarray.add(nums[j]);
            }
            // Count in how many distinct k-length subarrays each element appears
            for (int num : uniqueInSubarray) {
                subarrayCount.put(num, subarrayCount.getOrDefault(num, 0) + 1);
            }
        }

        // Find the maximum number that appears in EXACTLY 1 subarray
        int maxVal = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                maxVal = Math.max(maxVal, entry.getKey());
            }
        }

        return maxVal;
        
    }
}