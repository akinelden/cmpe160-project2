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
	
	// TODO: make private
	public Node<T> last;
	private int size;

	public MyDLL(){
		first = null;
		last = null;
		size = 0;
	}

	private Node<T> createNode(T item){
		Node<T> newNode = new Node<>(item);
		newNode.prev = null;
		newNode.next = null;
		return newNode;
	}

	private boolean checkIndex(int index){
		if(index >= size || index < 0){
			return false;
		}
		return true;
	}

	/**
	 * Appends an item to the end of the queue.
	 * @param item item to be appended.
	 */
	public void add(T item){
		Node<T> itemNode = createNode(item);
		if(size == 0){
			first = itemNode;
		}
		else{
			last.next = itemNode;
		}
		itemNode.prev = last;
		last = itemNode;
		size++;
	}
	
	/**
	 * Inserts an item to the specified location.
	 * @param item	item to be inserted.
	 * @param index	location that item will be inserted.
	 * @return	true if successful; false otherwise.
	 */
	public boolean add(T item, int index){
		if(!checkIndex(index) & index!=size){
			return false;
		}
		if(index == size){
			add(item);
			return true;
		}
		Node<T> itemNode = createNode(item);
		Node<T> tempNext = getNode(index);
		Node<T> tempPrev = tempNext.prev;
		tempNext.prev = itemNode;
		itemNode.next = tempNext;
		itemNode.prev = tempPrev;
		if(index!=0){
			tempPrev.next = itemNode;
		}
		else{
			first = itemNode;
		}
		size++;
		return true;
	}
	
	/**
	 * Retrieves and removes the item at specified location.
	 * @param index	the location of removal.
	 * @return	removed item.
	 */
	public T remove(int index){
		Node<T> temp = getNode(index);
		if(temp == null){
			return null;
		}
		Node<T> tempPrev = temp.prev;
		Node<T> tempNext = temp.next;
		if(tempPrev!=null){
			tempPrev.next = tempNext;
		}
		else{
			first = temp.next;
		}
	
		if(tempNext!=null){
			tempNext.prev = tempPrev;
		}
		else{
			last = temp.prev;
		}
		size--;
		return temp.data;
	}

	/**
	 * Retrieves the node at specified location
	 * @param index the location of the node
	 * @return the node at the specified location
	 */
	private Node<T> getNode(int index){
		if(!checkIndex(index)){
			return null;
		}
		Node<T> temp;
		if(index <= size/2){
			temp = first;
			for(int i=0; i<index; i++){
				temp = temp.next;
			}
		}
		else{
			temp = last;
			for(int i=size-1; i>index; i--){
				temp = temp.prev;
			}
		}
		return temp;
	}
	
	/**
	 * Retrieves the item at specified location.
	 * @param index the location of the item to be retrieved.
	 * @return the item at the specified location.
	 */
	public T get(int index){
		Node<T> temp = getNode(index);
		if(temp==null){ 
			return null; 
		}
		return temp.data;
	}
	
	public int getSize(){	return size; }
	

	// CHANGES END ABOVE THIS LINE

}
