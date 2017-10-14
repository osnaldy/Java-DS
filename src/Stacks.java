import java.util.Stack;

public class Stacks {

    public static boolean isBalanced(char [] parenthessis) {

        Stack s1 = new Stack();

        boolean balanced = false;

        for (int i = 0; i < parenthessis.length; i++) {

            if (parenthessis[i] == '{' || parenthessis[i] == '(' || parenthessis[i] == '[') {
                s1.push(parenthessis[i]);

            }

            if (parenthessis[i] == '}' || parenthessis[i] == ')' || parenthessis[i] == ']') {
                char temp = (char) s1.pop();

                if ((temp == '{' && parenthessis[i] == '}') || (temp == '[' && parenthessis[i] == ']') || (temp == '(' && parenthessis[i] == ')')) {
                    balanced = true;
                    return balanced;

                }
            }

        }
        return balanced;
    }

    public static void main(String[] args) {

        String s = "{{()}";

        char[] newChar = s.toCharArray();

        System.out.println(isBalanced(newChar));
    }


}
