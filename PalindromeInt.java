import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        int originalNum = num; // Store the original number for comparison
        int reversedNum = 0;
        int remainder;

        // Reverse the number
        while (num != 0) {
            remainder = num % 10; // Get the last digit
            reversedNum = reversedNum * 10 + remainder; // Build the reversed number
            num /= 10; // Remove the last digit from the original number
        }

        // Check if the original number and the reversed number are equal
        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is a Palindrome Number.");
        } else {
            System.out.println(originalNum + " is not a Palindrome Number.");
        }
    }
}
