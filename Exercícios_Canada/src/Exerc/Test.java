package Exerc;

public class Test {
	
	public static void main(String[] args) {
		
		      Fila<String> q = new Fila<String>();
		      while (!StdIn.isEmpty()) {
		         String item = StdIn.readString();
		         if (!item.equals("-")) q.enqueue(item);
		         else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		      }
		      StdOut.println("(" + q.size() + " left on queue)");
		   }

		
	}


