import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
	private T[] items;	// array of items
	private int N = 0;	// initial size of array
	
	/*
	 *  default constructor that calls a parametarized constructor of size 2
	 */
	public Stack() {
		this(2);
	}
	
	/*
	 * initializes the array to a default size of 2 if not specified otherwise
	 */
	public Stack(int size) {
		items = (T[]) new Object[size];
	}
	
	/*
	 * resizes the array
	 */
	private void resize(int size) {
		T[] tmp = (T[]) new Object[size];
		
		for (int i = 0; i < items.length; i++) tmp[i] = items[i];
		
		items = tmp;
	}
	
	/*
	 * adds item to the stack (if full, resizes it to double the size)
	 */
	public void push(T item) {
		if (N == items.length) resize(N * 2);
		
		items[N++] = item;
	}
	
	/*
	 * removes and returns the item most recently added to the stack
	 * throws java.util.NoSuchElementException if this stack is empty
	 */
	public T pop() {
		if (isEmpty()) throw new NoSuchElementException("Empty stack");
		T item = items[--N];
		items[N] = null;	// make it unreachable to allow for garbage collection
		
		if (N > 0 && N == items.length / 4) resize(items.length / 2);	// if items use up just a quarter of space, reduce the size of stack
		
		return item;
	}
	
	/*
	 * returns (without removing) the item most recently added to the stack
	 * throws java.util.NoSuchElementException if this stack is empty
	 */
	public T peek() {
		if (isEmpty()) throw new NoSuchElementException("Empty stack");
		
		return items[N - 1];
	}
	
	/*
	 * returns true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/*
	 * 	returns the number of items in the stack
	 */
	public int size() {
		return N;
	}
	
	/*
	 * returns an iterator to the stack that iterates in LIFO order
	 */
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<T> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return items[--i];
		}
	}
}
