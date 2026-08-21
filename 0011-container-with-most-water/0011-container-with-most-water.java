class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, h * w);

            // Move the pointer pointing to the shorter line to potentially find a taller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}