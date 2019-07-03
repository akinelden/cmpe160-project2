package adts;

import intfs.PriorityQueueIntf;

import java.util.LinkedList;

public class MyPQ<T extends Comparable<T>> implements PriorityQueueIntf<T> {


	/**
	 * data added to the stack must be stored in <code>list</code>
	 */
	LinkedList<T> list = new LinkedList<T>();

	// CHANGES START BELOW THIS LINE

	public MyPQ(){}

	/**
	 * Adds an item into the queue.
	 * @param item item to be added.
	 * @return true if successful; false otherwise.
	 */
	public boolean offer(T item){
		int count = list.size();
		int i;
		try{
			for(i=count-1; i>=0; i--){
				if(item.compareTo(list.get(i)) < 0){
					break;
				}
			}
			list.add(i+1, item);
			return true;
		} catch(Exception e){
			System.out.println("Exception occurred while offering item to PQ : " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * Retrieves and removes an item from the queue.
	 * @return the item at the front
	 */
	public T poll(){
		T first = peek();
		if(first!=null){
			list.removeFirst();
		}
		return first;
	}
	
	/**
	 * Retrieves the item at the front.
	 * @return	the item at the front.
	 */
	public T peek(){
		if(list.size()==0){
			return null;
		}
		return list.getFirst();
	}
	
	/**
	 * Returns the number of items in the queue.
	 * @return  the number of items in the queue.
	 */
	public int count(){
		return list.size();
	}
	
	
	
	
	// CHANGES END ABOVE THIS LINE
	
}
