import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
	private T[] items;
	private int N = 0;
	private int first = 0, last = 0;
	
	/*
	 * default constructor that calls a parametarized constructor of size 2
	 */
	public Queue() {
		this(2);
	}
	
	/*
	 * initializes the array to a default size of 2 if not specified otherwise
	 */
	public Queue(int size) {
		items = (T[]) new Object[size];
	}
	
	/*
	 * inserts an item at the end of the queue
	 */
	public void enqueue(T item) {
		if (N == items.length) resize(2*N);
		
		items[last++] = item;
		if (last == items.length) last = 0;	// wraparound if at the end of array
		N++;
	}
	
	/*
	 * removes and returns an item from the front of the queue least recently added to the queue
	 * throws java.util.NoSuchElementException if queue is empty
	 */
	public T dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Empty queue");
		T item = items[first];
		items[first++] = null;	// make it unreachable to allow for garbage collection
		
		if (first == items.length) first = 0;
	
		N--;
		
		if (N > 0 && N == items.length / 4) resize(items.length / 2);	// if items use up just a quarter of space, reduce the size of queue
		
		return item;
	}
	
	/*
	 * returns an item from the front of the queue least recently added to the queue
	 * throws java.util.NoSuchElementException if queue is empty
	 */
	public T peek() {
		if (isEmpty()) throw new NoSuchElementException("Empty queue");
		
		return items[first];
	}
	
	/*
	 * returns true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/*
	 * returns the numeber of elements in the queue
	 */
	public int size() {
		return N;
	}
	
	/*
	 * resizes the array
	 */
	private void resize(int size) {
		T[] tmp = (T[]) new Object[size];
		int cap = N;

		for (int i = 0; i < cap; i++) {
			tmp[i] = this.dequeue();
		}
		
		first = 0;
		last = N = cap;
		items = tmp;
	}
	
	/*
	 * returns an iterator to the queue that iterates in FIFO order
	 */
	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<T> {
		private int cnt = N, firstIt = first, i = 0;

		@Override
		public boolean hasNext() {
			return cnt > 0;
		}

		@Override
		public T next() {
			cnt--;
			if (firstIt < items.length) return items[firstIt++];
			else return items[i++];
		}
		
	}
}
