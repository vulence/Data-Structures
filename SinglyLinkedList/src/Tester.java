
public class Tester {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println("Middle is: " + list.findMiddle());
		System.out.println(list.remove(6) + "\n");
		list.add(6);
		
		for (int i : list) System.out.println(i);
	}

}
