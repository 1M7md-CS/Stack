public class InfixToPostfix {

	public static String transformation(String input) {
		if (!ParenthesesChecker.isBalanced(input)) {
			throw new IllegalArgumentException("String is not balanced");
		}

		Stack<Character> stack = new Stack<>(input.length());
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == ' ') continue;

			if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
				builder.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {

				while (!stack.isEmpty() && stack.getTop() != '(') {
					builder.append(stack.getTop());
					stack.pop();
				}

				if (!stack.isEmpty()){
					stack.pop();
				}
			}else {
				while ( !stack.isEmpty() && priority(ch) <= priority(stack.getTop())){
					builder.append(stack.getTop());
					stack.pop();
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()){
			builder.append(stack.getTop());
			stack.pop();
		}

		return builder.toString();
	}


	private static int priority(char ch) {
		return switch (ch) {
			case '+', '-' -> 1;
			case '*', '/' -> 2;
			case '^' -> 3;
			default -> 0;
		};
	}
}
