package view;

import controller.EmptyStackException;
import model.DynamicStack;

public class Main {
	public static void main(String args[]) throws EmptyStackException{
		DynamicStack<String> pilha = new DynamicStack();
		String expressao = "((([]))())";
		carregaPilha(pilha, expressao);
		System.out.println(pilhaVerifica(pilha, expressao));
		
	}
	public static DynamicStack carregaPilha(DynamicStack<String> pilha, String expressao)throws EmptyStackException {
		for(int i=0;i<expressao.length();i++) {
			pilha.push(Character.toString(expressao.charAt(i)));
		}
		return pilha;
	}
	public static String pilhaVerifica(DynamicStack<String> pilha, String expressao) throws EmptyStackException {
		DynamicStack<String> aux = new DynamicStack();
		while(!pilha.isEmpty()) {
			aux.push(pilha.pop());
			if(!pilha.isEmpty() && pilhaInverso(pilha.showTop(), aux.showTop())) {
				return "Expressão invalida";
			} //falta pequenos ajustes no algoritimo
		}
		
		while(!aux.isEmpty()) {
			pilha.push(aux.pop());
		}
		
		if(pilha.showTop().equals("(")|| pilha.showTop().equals("[")) {
			return "Expressão invalida"; 
			
		}else if(pilha.showTop().equals(")")|| pilha.showTop().equals("]")) {
			String auxiliar = pilha.showTop();
			String auxiliarDois = valorRever(auxiliar); 
			int auxUm = 0;
			int auxDois = 0;
			while(!pilha.isEmpty()) {
				aux.push(pilha.pop());
				if(aux.showTop().equals(auxiliar)) {
					auxUm++;
				}else if(aux.showTop().equals(auxiliarDois)) {
					auxDois++;
				}
			}
			if(auxUm != auxDois) {
				return "Expressão invalida";
			}
		}
		
		return "Expressão verdadeira";
	}
	public static boolean pilhaInverso(String topMain, String topAux) {
		switch(topAux) {
		case ")" : 
			if(topMain.equals("[")) {
				return true;
			}
			return false;
		case "]" : 
			if(topMain.equals("(")) {
				return true;
			}
			return false;
		case "[" : 
			if(topMain.equals(")")) {
				return true;
			}
			return false;
		case "(" : 
			if(topMain.equals("]")) {
				return true;
			}
		
			return false;
		default : return true;
		}
	}
	public static boolean pilhaFecha(String topMain, String topAux) {
		switch(topAux) {
		case ")" : 
			if(topMain.equals("(")) {
				return true;
			}
			return false;
		case "]" : 
			if(topMain.equals("[")) {
				return true;
			}
			return false;
		default : return true;
		}
	}
	public static String valorRever(String aux) {
		if(aux.equals(")")) {
			return "(";
		}else if(aux.equals("]")) {
			return "[";
		}else if(aux.equals("(")) {
			return ")";
		}else {
			return "]";
		}
	}
}
