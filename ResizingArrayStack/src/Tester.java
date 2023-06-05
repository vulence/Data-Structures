public class Tester {
	/*
	 * unit tests the stack data type
	 */
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		s.push("Hello");
		s.push("World");
		s.push("test");
		s.push("stack");
		
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
		s.push("Hello");
		s.push("world");
	}
}