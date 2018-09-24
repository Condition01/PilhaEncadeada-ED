package controller;

public class Node <E> {
	
		private E element;
		private Node next; 
	
		public Node(E c, Node n){
			element = c;
			next = n;
		}
		

		public Node(E element) {
			this(element, null);
		}
		

		public E getElement(){
			return element; 
		}
		
	
		public Node getNext(){
			return next; 
		}
		

		public void setElement(E newElem){
			element = newElem;
		}
		

		public void setNext(Node newNext){
			next = newNext;
		}
		
}
