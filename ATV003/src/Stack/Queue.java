package Stack;

public class Queue {

	private int start; // indicador do inicio da fila
	private int end; // indicador do fim da fila
	private int counter; // contador de elementos na fila
	private int capacity; // capacidade maxima da fila
	private Object[] itemArray; // armazenador de objetos

	public Queue() {
		/**Por se tratar de uma fila estatica nesse construtor 
		 * colocamos a capacidade de nossa fila
		 */
		this(100);
		
	
	}
	

	public Queue(int maxCapacidade) {
		/** Nesse Construtor inicializamos
		 *  nossas v�riaveis em 0, para poder come�ar a movimentar a fila
		 * 
		 */
		start = 0;
		end = 0;
		counter = 0;
		capacity = maxCapacidade;
		itemArray = new Object[capacity];

	}

	public boolean isEmpty() {
		/**
		 * M�todo utilizado para verificar se a fila est� vazia. Se for o caso, 
		 * ser� retornado true, caso contr�rio, ser� retornado false.
		 */
		return (counter == 0);
	}

	public int size() {
		/**
		 * Metodo para se obter o tamanho da fila
		 */
		return (counter);
	}

	public void enqueue(Object newItem) {
		/**
		 * M�todo para enfileirar, nele um elemento � acrescentado
		 * Caso a fila j� esteja cheia, colocamos uma mensagem de erro
		 *Caso contrario o n�emro continua a ser acrescentado
		 */
		if (counter == capacity) {
			System.out.println("Error: Queue capacity has been exceeded!");
		} else {
			itemArray[end] = newItem;
			end = (end + 1) % capacity;
			counter++;
		}
	}

	public Object dequeue() {
		
		 /** M�todo para desenfileirar, nele o elemento da primeira posi��o � retirado e � retornando uma referencia
		 * Caso a fila n�o possuir nenhum elemtno e dado a mensagem de erro
		 * Caso o contrario os elementos v�o sendo retirado. Sempre o d� primeira posi��o
		 */
		Object x = null;
		if (isEmpty()) {
			System.out.println("Error: Queue empty!");
		} else {
			x = itemArray[start];
			start = (start + 1) % capacity;
			counter--;
		}
		return (x);
	}

	public Object peekStart() {
		/**Nesse metodo olhamos na primeira posi��o, para retornarmos o primeiro elemento da fila
		 * Caso a fila estiver vazia, a mensagem de erro � aplicada
		 */
		Object x = null;
		if (isEmpty()) {
			System.out.println("Error: Queue empty!");
		} else {
			x = itemArray[start];
		}
		return (x);
	}

	public Object peekEnd() {
		/**Nesse metodo olhamos na �ltima posi��o, para retornarmos o �ltimo elemento da fila
		 * Caso a fila estiver vazia, a mensagem de erro � aplicada
		 */
		Object x = null;
		if (isEmpty()) {
			System.out.println("Error: Queue empty!");
		} else {
			if (end == 0) {
				x = itemArray[capacity - 1];
			} else {
				x = itemArray[end - 1];
			}
		}
		return (x);
	}

	public String toString() {
		/**
		 * Este m�todo serve para representar textualmente esta fila
		 */
		String queueComplet = "";
		if (isEmpty()) {
			queueComplet = null;
		} else {
			int j = start;
			for (int i = 0; i < counter; i++) {
				queueComplet = queueComplet + "\n" + itemArray[j];
				j = (j + 1) % capacity;
			}
		}
		return (queueComplet);
	}

}
