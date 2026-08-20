import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // 1. Distribute initial elements
        list1.add(nums[0]);
        list2.add(nums[1]);

        // 2. Iterate starting from the 3rd element (index 2)
        for (int i = 2; i < nums.length; i++) {
            int last1 = list1.get(list1.size() - 1);
            int last2 = list2.get(list2.size() - 1);

            if (last1 > last2) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }

        // 3. Combine both lists into the final result array
        int[] result = new int[nums.length];
        int idx = 0;

        for (int num : list1) {
            result[idx++] = num;
        }
        for (int num : list2) {
            result[idx++] = num;
        }

        return result;
    }
}