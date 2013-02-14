import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item>
{
	private int N;		//Size of the stack
	private Item[] array;		//The array we keep our items in
	
	public RandomQueue() // create an empty random queue
	{
		N = 0;
		array = (Item[]) new Object[2];
	}
	
	public boolean isEmpty() // is it empty?
	{
		return N==0;
	}
	
	public int size() // return the number of elements
	{
		return N;
	}
	
	public void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
        
		for (int i = 0; i < N; i++) 
		{
            temp[i] = array[i];
        }
		
        array = temp;
	}
			
	public void enqueue(Item item) // add an item
	{
		if(N == array.length) 
			resize(2*array.length);
		
		array[N] = item;
		
		N++;
	}
	

	public Item sample() // return (but do not remove) a random item
	{
		if(isEmpty())
			throw new RuntimeException("Stack underflow error");
		
		return array[StdRandom.uniform(N)];
	}
	
	public Item dequeue() // remove and return a random item
	{
		if(isEmpty())
			throw new RuntimeException("Stack underflow error");
		
		int rand = StdRandom.uniform(N);
		Item item = array[rand];
		array[rand] = array[N-1];
		array[N-1] = null;
		
		N--;
		
		if (N > 0 && N == array.length/4) 
			resize(N/2);
		
		return item;
	}
	
	public Iterator<Item> iterator() // return an iterator over the items in random order
	{
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item>
	{
		private int i;
		private Item[] iteratorArray;
		
		public RandomQueueIterator()
		{
			iteratorArray = array.clone();
			i = N;
		}
		
		public boolean hasNext()
		{
			return i > 0;
		}
		
		public void remove() {
            throw new UnsupportedOperationException();
        }
		
		public Item next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
		
			int rand = StdRandom.uniform(i);
			Item item = iteratorArray[rand];
			iteratorArray[rand] = iteratorArray[i-1];
			iteratorArray[i-1] = null;
			
			i--;
			
			return item;
		}
		
	}
	
	public static void main(String args[])
	{
		// Build a queue containing the Integers 1,2,...,6:
		RandomQueue<Integer> Q= new RandomQueue<Integer>();
		for (int i = 1; i < 7; ++i) Q.enqueue(i); // autoboxing! cool!
	 
		// Print 30 die rolls to standard output
		StdOut.print("Some die rolls: ");
		for (int i = 1; i < 30; ++i) StdOut.print(Q.sample() +" ");
		StdOut.println();

		// Let's be more serious: do they really behave like die rolls?
		int[] rolls= new int [10000];
		for (int i = 0; i < 10000; ++i)
		  rolls[i] = Q.sample(); // autounboxing! Also cool!
		StdOut.printf("Mean (should be around 3.5): %5.4f\n", StdStats.mean(rolls));
		StdOut.printf("Standard deviation (should be around 1.7): %5.4f\n",
			  StdStats.stddev(rolls));
		
		// Let's look at the iterator. First, we make a queue of colours:
		
		RandomQueue<String> C= new RandomQueue<String>();
		C.enqueue("red"); C.enqueue("blue"); C.enqueue("green"); C.enqueue("yellow"); 

		Iterator I= C.iterator();
		Iterator J= C.iterator();

		StdOut.print("Two colours from first shuffle: ");
		StdOut.print(I.next()+" ");
		StdOut.print(I.next()+" ");
		
		StdOut.print("\nEntire second shuffle: ");
		while (J.hasNext()) StdOut.print(J.next()+" ");

		StdOut.print("\nRemaining two colours from first shuffle: ");
		StdOut.print(I.next()+" ");
		StdOut.println(I.next());
		
	}
}