package Exerc01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	
public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O Pequeno Príncipe");
		livros.push("Don Quixote");
		livros.push("O Hobbit");
		
		for(String livro: livros) {
			System.out.println(livro);
			
		}
		
		System.out.println();
		System.out.println(livros.peek());
		
		System.out.println();
		System.out.println(livros.element());
		
		System.out.println(livros.remove());
		System.out.println(livros.poll());
		System.out.println(livros.pop());
		
		
		livros.size();
		livros.clear();
		livros.contains("O Hobbit");
		livros.isEmpty();
		livros.push(null);
}

}
