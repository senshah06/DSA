import java.util.HashMap;

class Solution {
    public boolean canForm(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        

        // Count character frequencies in str1
        for (char c : str1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Check if str2 can be formed
        for (char c : str2.toCharArray()) {
            if (freqMap.containsKey(c) && freqMap.get(c) > 0) {
                freqMap.put(c, freqMap.get(c) - 1);
            } else {
                return false; // Character not found or count is zero
            }
        }

        return true; // All characters of str2 found in str1
    }
}
