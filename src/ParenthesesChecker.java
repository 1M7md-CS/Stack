public class ParenthesesChecker {
	public static boolean isBalanced(String input) {

		Stack<Character> stack = new Stack<>(input.length());

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {

				stack.push(input.charAt(i));

			} else if (ch == ')' || ch == '}' || ch == ']') {

				if (stack.isEmpty()) {

					return false;
				}

				if (!(pair(stack.getTop(), ch))) {
					return false;
				}

				stack.pop();
			}
		}

		return stack.isEmpty();
	}


	private static boolean pair(char open, char close) {
		if (open == '(' && close == ')') return true;
		if (open == '{' && close == '}') return true;
		if (open == '[' && close == ']') return true;

		return false;
	}
}
