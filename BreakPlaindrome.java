public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";

        char[] chars = palindrome.toCharArray();
        int len = chars.length;

        // Try changing the first non-'a' character in the first half
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // If all are 'a', change the last character to 'b'
        chars[len - 1] = 'b';
        return new String(chars);
    }

    public static void main(String[] args) {
        BreakPalindrome bp = new BreakPalindrome();
        System.out.println(bp.breakPalindrome("abba")); // Output: "aaba"
    }
}
