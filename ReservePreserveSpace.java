public class ReversePreserveSpaces {
    public static String reversePreserveSpaces(String str) {
        char[] input = str.toCharArray();
        char[] result = new char[input.length];

        // Mark spaces in result
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                result[i] = ' ';
            }
        }

        // Fill characters in reverse order skipping spaces
        int j = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != ' ') {
                while (result[j] == ' ') {
                    j--;
                }
                result[j] = input[i];
                j--;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reversePreserveSpaces("a b c d")); // Output: "d c b a"
    }
}
