package model;

import controller.EmptyStackException;
import controller.Node;

public class DynamicStack <E> {
	protected  Node<E> topo ; //node topo da pilha
	protected int size; //número de nodes da pilha
	// Construtor default que cria uma pilha vazia
	
	
	public DynamicStack() {
		topo = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return topo == null;
	}
	
	public int getSize() {
		return size;
	}

	public E showTop() throws EmptyStackException {
		if (isEmpty()) {
		throw new EmptyStackException();
		}
		return topo.getElement();
	}
	
	public void push(E element) {
		Node novo = new Node(element, topo);
		topo = novo;
		size++;
	}
	
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E temp = topo.getElement();
		topo = topo.getNext(); //desencadeira o node topo
		size--;
		return temp;
	}

}
