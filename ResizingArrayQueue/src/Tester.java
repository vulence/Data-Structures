
public class Tester {

	public static void main(String[] args) {
		Queue<Integer>q = new Queue<Integer>();
		
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		
		for (int i : q) System.out.println(i);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(5);

	}

}
