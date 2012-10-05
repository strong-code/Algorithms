/*
 * A simple circular linked list implementation using a private subclass for the Node object
 */

public class CircularLinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	//Create an empty list object
	public CircularLinkedList() {
		head = tail = new Node();
		length = 0;
	}
	
	//Create a list object and fill it with items
	public CircularLinkedList(Object[] items) {
		head = tail = new Node();
		length = 0;
		for (int i = 0; i < items.length; i++) {
			this.add(items[i]);
		}
	}
	
	//Remove all items from list
	public void clear() {
		head.setNext(null);
		tail = head;
		length = 0;
	}
	
	//Add an object to the end of the list
	public void add(Object n) {
		tail.setNext(new Node(n, null));
		tail = tail.next;
		tail.next = head;
		length++;
	}
	
	//Add an object at a specified position in the list
	public void add(Object n, int position) {
		if (position == this.length) {
			add(n);
		}
		if (position > length+1 || position < 0) {
			System.out.println("Index is not in the list!");
		}
		//Use a temporary node starting at head until we are where we want to be inserted
		Node tmp = head;
		for (int i = 0; i < position; i++) {
			tmp = tmp.next;
		}
		//Now add a new node at the next link of the list
		tmp.next = new Node(n, tmp.next);
		length++;
	}
	
	//Remove the object at a specified position in the list
	public void remove(int position) {
		if (position > length+1 || position < 0) {
			System.out.println("Index is not in the list!");
		}
		//Use a temporary node starting at head until we are where we want to be deleted
		Node tmp = head;
		for (int i = 0; i < position; i++) {
			tmp = tmp.next;
		}
		//Now simply point over the node to be deleted, and the garbage collector will remove it
		tmp.next = tmp.next.next;
		length--;
	}
	
	//returns an object at the specified position in the list
	public Node get(int index) {
		if (index < 0) {
			return null;
		}
		//Cheat a bit on iterations we have to perform
		if (index > length) {
			index = index%length;
		}
		//Use a temporary node starting at head until we find the node we want to return
		Node tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		return tmp;
	}
	
	//Prints out all elements in the list
	public void printList() {
		Node tmp = head;
		for (int i = 0; i < length; i++) {
			System.out.println(tmp);
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		Object[] nums = {2, 3, 4};
		CircularLinkedList c = new CircularLinkedList(nums);
		c.printList();
		System.out.println();
	}
	
	private class Node {
		private Object element;
		private Node next;
		
		Node(Object elem, Node nextElem) {
			element = elem;
			next = nextElem;
		}
		
		Node() { }
		
		void setNext(Node nextelem) {
			next = nextelem;
		}
				
	}

}
