package adts;

import java.util.ArrayList;

import intfs.StackIntf;

public class MyStack<T> implements StackIntf<T> {
	
	/**
	 * data added to the stack must be stored in <code>list</code>
	 */
	ArrayList<T> list = new ArrayList<T>();
	
	// CHANGES START BELOW THIS LINE
	
	/**
	 * Appends the item to the end of the list.
	 * @param item item to be added to the list.
	 * @return added item.
	 */
	public T push(T item){
		list.add(item);
		return item;
	}
	
	/**
	 * Retrieves and removes the item at the end of the list.
	 * @return the item to be removed.
	 */
	public T pop(){
		if(list.size() == 0){
			return null;
		}
		T last = list.get(list.size()-1);
		list.remove(list.size()-1);
		return last;
	}
	
	/**
	 * Retrieves the item at the end of the list.
	 * @return the item at the end of the list.
	 */
	public T peek(){
		if(list.size() == 0){
			return null;
		}
		return list.get(list.size()-1);
	}
	
	/**
	 * Checks if the stack is empty.
	 * @return true if the stack is empty; false, otherwise.
	 */
	public boolean isEmpty(){
		return list.size()==0;
	}
	
	/**
	 * Returns the number of elements in the stack.
	 * @return the number of elements.
	 */
	public int count(){
		return list.size();
	}
	
	
	
	
	// CHANGES END ABOVE THIS LINE
}
