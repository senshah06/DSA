//WAP to check if the string is palindrome
//if not then rearrange the chars to make it a palindrome

import java.util.HashMap;
import java.util.Map;

public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "yourstring"; // Replace with your input string
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome: " + input);
        } else {
            String palindrome = rearrangeToPalindrome(input);
            if (palindrome != null) {
                System.out.println("Rearranged to palindrome: " + palindrome);
            } else {
                System.out.println("Cannot rearrange to form a palindrome.");
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String rearrangeToPalindrome(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            return null; // Cannot form a palindrome
        }

        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();
        char middleChar = 0;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count / 2; i++) {
                firstHalf.append(c);
                secondHalf.insert(0, c);
            }
            if (count % 2 != 0) {
                middleChar = c;
            }
        }

        return firstHalf.toString() + (middleChar != 0 ? middleChar : "") + secondHalf.toString();
    }
}
