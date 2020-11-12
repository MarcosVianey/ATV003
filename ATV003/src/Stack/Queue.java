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
		 *  nossas váriaveis em 0, para poder começar a movimentar a fila
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
		 * Método utilizado para verificar se a fila está vazia. Se for o caso, 
		 * será retornado true, caso contrário, será retornado false.
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
		 * Método para enfileirar, nele um elemento é acrescentado
		 * Caso a fila já esteja cheia, colocamos uma mensagem de erro
		 *Caso contrario o núemro continua a ser acrescentado
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
		
		 /** Método para desenfileirar, nele o elemento da primeira posição é retirado e é retornando uma referencia
		 * Caso a fila não possuir nenhum elemtno e dado a mensagem de erro
		 * Caso o contrario os elementos vão sendo retirado. Sempre o dá primeira posição
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
		/**Nesse metodo olhamos na primeira posição, para retornarmos o primeiro elemento da fila
		 * Caso a fila estiver vazia, a mensagem de erro é aplicada
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
		/**Nesse metodo olhamos na última posição, para retornarmos o último elemento da fila
		 * Caso a fila estiver vazia, a mensagem de erro é aplicada
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
		 * Este método serve para representar textualmente esta fila
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
