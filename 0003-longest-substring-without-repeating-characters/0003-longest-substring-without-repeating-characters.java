import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            // Shrink window if duplicate character is found
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to set
            set.add(s.charAt(right));
            
            // Calculate current unique substring length
            int currentLen = right - left + 1;
            ans = Math.max(ans, currentLen);
        }
        
        return ans;
    }
}