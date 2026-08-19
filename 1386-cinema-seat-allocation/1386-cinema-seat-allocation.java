import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                int currentMask = rowMasks.getOrDefault(row, 0);
                rowMasks.put(row, currentMask | (1 << (col - 2)));
            }
        }

       
        int leftMask = 15;    
        int rightMask = 240;  
        int middleMask = 60;  

        int maxGroups = (n - rowMasks.size()) * 2;

        for (int mask : rowMasks.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;

            if (leftFree && rightFree) {
                maxGroups += 2;
            } else if (leftFree || rightFree || (mask & middleMask) == 0) {
                maxGroups += 1;
            }
        }

        return maxGroups;
        
    }
}