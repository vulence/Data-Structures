public class Tester {

	/*
	 * unit tests the singly linked list data type
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println("Middle is: " + list.findMiddle());
		list.addToBeginning(1);
		list.addToBeginning(2);
		System.out.println(list.find(3));
		
		for (int i : list) System.out.println(i);
	}

}
