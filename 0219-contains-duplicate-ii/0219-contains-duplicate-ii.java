import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            // 1. If element already exists within window size k, duplicate found!
            if (set.contains(nums[right])) {
                return true;
            }

            // 2. Add current element to the set
            set.add(nums[right]);

            // 3. Keep window size <= k by removing the element that falls out of range
            if (set.size() > k) {
                set.remove(nums[right - k]);
            }
        }

        return false; // No duplicates found within distance k
    }
}