import java.util.Stack;

public class ParenthesisChecker {

    public static boolean checkParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') 
                    || (c == '}' && top != '{') 
                    || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "(the[is]{valid})";
        String test2 = "(the[is]{valid))";
        String test3 = "{the(is[valid])}";
        String test4 = "(this](is}{valid)";

        System.out.println(test1 + " is balanced: " + checkParentheses(test1));
        System.out.println(test2 + " is balanced: " + checkParentheses(test2));
        Systemino.out.println(test3 + " is balanced: " + checkParentheses(test3));
        System.out.println(test4 + " is balanced: " + checkParentheses(test4));
    }
}
