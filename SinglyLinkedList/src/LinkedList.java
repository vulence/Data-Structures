import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
	private Node<T> head = null;
	
	public LinkedList() {}
	
	/*
	 * adds an element to the end of the list
	 */
	public void add(T item) {
		if (head == null) head = new Node<T>(item);
		else {
			Node<T> tmp = head;
			while (tmp.next != null) tmp = tmp.next;
			
			tmp.next = new Node<T>(item);
		}
	}
	
	/*
	 * adds an element to the beginning of the list
	 */
	public void addToBeginning(T item) {
		if (head == null) head = new Node<T>(item);
		else {
			Node<T> tmp = new Node<T>(item);
			tmp.next = head;
			head = tmp;
		}
	}
	
	/*
	 * removes and returns a particular element from the list - if there are multiple, returns the first occurrence,
	 * if element dosen't exist, returns null
	 */
	public T remove(T item) {
		if (head == null) return null;
		
		if (head.data == item) {
			T found = head.data;
			
			head = head.next;
			
			return found;
		}
		
		Node<T> tmp = head;
		
		while (tmp.next != null) {
			if (tmp.next.data == item) {
				T found = tmp.next.data;
				tmp.next = tmp.next.next;
				return found;
			}
			
			tmp = tmp.next;
		}
		
		return null;
	}
	
	/*
	 * returns the value of middle node of the linked list; if there are two, returns the former one
	 * if the list is empty, returns null
	 */
	public T findMiddle() {
		if (head == null) return null;
		
		Node<T> slowptr = head;
		Node<T> fastptr = head;
		
		while (fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next;
			
			if (fastptr.next != null) fastptr = fastptr.next.next;
		}
		
		return slowptr.data;
	}
	
	/*
	 * returns true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/*
	 * returns true if element with value data exists in the list, false otherwise
	 */
	public boolean find(T data) {
		Node<T> tmp = head;
		
		while (tmp != null) {
			if (tmp.data == data) return true;
			
			tmp = tmp.next;
		}
		
		return false;
	}

	/*
	 * returns an iterator to the list that iterates in FIFO order
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		private Node<T> tmp = head;

		@Override
		public boolean hasNext() {
			return tmp != null;
		}

		@Override
		public T next()	 {
			T item = tmp.data;
			tmp = tmp.next;
			return item;
		}
		
	}
	
	/*
	 * helper node class, provides added abstraction
	 * nodes are instantiated for cleaner code
	 */
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		private Node(T data) {
			this.data = data;
			this.next = null;	
		}
	}
}
