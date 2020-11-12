package Stack;

public class Stack003 {
	/** 
	 * Vetor de String que armazenar� os elementos. 
	 * Se uma posi��o estiver nula, esta posi��o ser� encarada como uma posi��o 
	 * vazia na pilha. Sendo assim, nunca poder� existir uma posi��o vazia  
	 * seguida de uma posi��o n�o-vazia(diferente de null), pois isso indicaria  
	 * que, de alguma forma, removemos algum elemento da pilha que n�o o do topo. 
	 */  
	private String[] elements;  
	/** 
	 * inteiro que indicar� quantos elementos N�O NULOS existem dentro de  
	 * elements. Note por exemplo que: 
	 * -Se size for igual a n, o topo da pilha est� na posi��o (n - 1) de elements por exemplo
	 * -Se size for igual a 26, o topo da pilha est� na posi��o 25 de elements 
	 * Resumindo, podemos assumir QUASE sempre que o topo da pilha � a posi��o  
	 * (size - 1) de elements. 
	 * O "quase" se deve ao caso de quando nossa pilha � vazia. Nesse caso,  
	 * size � igual a 0. Se fossemos seguir a regra acima indistintamente,  
	 * acabar�amos assumindo que neste caso o topo da pilha est� na posi��o -1  
	 * de elements, o que � um erro... Trata-se ent�o de uma exce��o, a qual  
	 * deveremos estar atentos para fazer bobagem! 
	 * Para fins did�ticos, criaremos um m�todo privado que retorna a posi��o  
	 * exata do topo da pilha, e sempre utilizaremos este m�todo para termos tal 
	 * informa��o. 
	 */  
	private int size;  
	
	/** 
	 * Construtor que indicara a capacidade 
	 */  
	public Stack003(int capacity) {  
		/* 
		* Utilizamos o m�todo abs da classe Math s� pra evitar que se tente  
		* criar uma pilha "devedora"... 
		*/  
		elements = new String[Math.abs(capacity)];  
		size = 0;  
	}  
	  
 
	public String push(String element) {  
		/** 
		 * Esse m�todo � �tilizado para acrescentar elementos na pilha e os elementos inseridos v�o sempre ir para o topo
		 * Se o elemento for null, vamos lan�ar uma exce��o, informando que nossa  
		 * pilha n�o aceita null como elemento v�lido. 
		 * Se a pilha estiver cheia, retornamos null para indicar que n�o foi  
		 * poss�vel insirir elemento. 
		 * Se o elemento for inserido com sucesso, retornamos o pr�prio elemento,  
		 * indicando assim o sucesso da opera��o 
		 */ 
		if(element == null)  
			throw new IllegalArgumentException("O elemento n�o pode ser nulo!");   
		if(size == elements.length)  
			return null;  
		 
		size++;  
		elements[getTopPosition()] = element;  
		return element;  
	}  
	  
	
	public String peek() {  
		/** 
		 * Esse m�todo � utilizado para obter o primeiro elemento da primeira posi��o   
		 * -Se a pilha estiver vazia, retornamos null para indicar que a pilha  
		 * est� vazia. 
		 * -Se houver ao menos um elemento na pilha, o elemento que est� no topo  
		 * ser� retornado, indicando o sucesso da opera��o 
		 */  
		if(isEmpty())  
			return null;  
		 
		return elements[getTopPosition()];  
	}  
	  
	
	public String pop() {
		/** 
		 * M�todo utilizado para retirar("destacar") um elemento desta pilha. Este  
		 * elemento sempre ser� aquele que se encontra no topo desta pilha. 
		 * -Se a pilha estiver vazia, retornamos null para indicar que a pilha  
		 * est� vazia. 
		 * -Se houver ao menos um elemento na pilha, o elemento que est� no topo  
		 * ser� retornado, indicando o sucesso da opera��o 
		 */  
		String result = peek();  
		/*Se havia um elemento no topo da pilha...*/  
		if(result != null) {  
			elements[getTopPosition()] = null;  
			size--;  
		}  
		return result;  
	}  
	  
	
	public void clear() {  
		/** 
		 * M�todo utilizado para limpar todo o conte�do da pilha. 
		 */  
		for(int i = 0; i < size; i++)  
			elements[i] = null;  
		size = 0;  
	}  
	  
	 
	public int getSize() {  
		/**
		 * M�todo utilizado para se obter o tamanho (n�mero de elementos) da pilha 
		 */  
		return size;  
	}  
	  
	
	public int getCapacity() {  
		/** 
		 * M�todo utilizado para se obter a capacidade da pilha 
		 */  
		return elements.length;  
	}
	
	
	public boolean isEmpty() {
		/**
		 * M�todo utilizado para verificar se a pilha est� vazia. Se for o caso, 
		 * ser� retornado true, caso contr�rio, ser� retornado false.
		 */
		return size <= 0;
	}
	  
	
	private int getTopPosition() {
		/** 
		 * Este m�todo tem uma finalidade estritamente did�tica, visando facilitar o  
		 * entendimento do c�digo desta classe. 
		 * Este m�todo retorna um inteiro que representa a posi��o de elements onde  
		 * se encontra o �ltimo elemento inserido nesta pilha (O topo da pilha) 
		 */ 
		if (isEmpty())
			return 0;
		return size - 1;  
	}
	
	
	public String toString() {  
		/** 
		 * Este m�todo serve para representar textualmente esta pilha 
		 * @see java.lang.Object#toString() 
		 */  
		StringBuilder sb = new StringBuilder("[");  
		for(int i = 0; i < size; i++) {  
			sb.append(elements[i]);  
			if(i < size - 1)  
			  sb.append(" | ");  
		}  
		sb.append(">");  
		 
		return sb.toString();  
	}  

}
