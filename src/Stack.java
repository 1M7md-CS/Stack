public class Stack<T> {

	private int top;
	private final Object[] arr;

	Stack(int size) {

		if (size <= 0) {
			throw new IllegalArgumentException("Stack size must be greater than 0");
		}

		this.top = -1;
		this.arr = new Object[size];
	}

	public void push(T Element) {

		if (isFull()) {
			throw new IllegalStateException("Stack is Full");
		}

		top++;
		arr[top] = Element;
	}

	public void pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is Empty");
		}
		top--;
	}

	public T popAndReturn() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is Empty");
		}

		@SuppressWarnings("unchecked")
		T Element = (T) arr[top];
		top--;
		return Element;
	}

	public T getTop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is Empty");
		}
		@SuppressWarnings("unchecked") T Element = (T) arr[top];
		return Element;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("[]");
			return;
		}
		System.out.print("[ ");
		int top = this.top;
		for (int i = top; i >= 0; i--) {

			System.out.print(arr[i]);
			if (i > 0) {
				System.out.print(", ");
			}
		}

		System.out.println(" ]");
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public int capacity(){
		return arr.length;
	}


}