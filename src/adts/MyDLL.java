package adts;

import intfs.DoublyLinkedListIntf;

public class MyDLL<T> implements DoublyLinkedListIntf<T>{

	/**
	 * Abstraction of a node in the Doubly Linked List (DLL) ADT.
	 *
	 * Example Usage: A Node in an integer DLL has the following fields:
	 * 		int data;
	 * 		Node<Integer> next, prev;
	 * 
	 * @param <E> type of the data.
	 */
	public class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(E data_) {
			data = data_;
		}
	}

	/**
	 *	The first node of the list.
	 *	NOTE: Made public for testing purposes.
	 */
	public Node<T> first;

	// CHANGES START BELOW THIS LINE
	
	
	
	

	// CHANGES END ABOVE THIS LINE

}
