* Assignment: RandomQueue
** Student info:
   - Group name: Induction Hypothesis
   - Name1: Jonas Kastberg Hinrichsen
   - Email1: jkas@itu.dk
   - Name2:
   - Email2:
   - Operating system: Windows 7 64 bit
   - Compiler: javac
   - Text editor / IDE: notepad++

** Assignment info:
   Mark on of the following boxes with an X
   [ X ] Yes, to the best of our knowledge, everything works as it
   should. In particular, the main method below behaves as expected.
   [ ] No, our solution does not work. (We will not get credit for this.)
   Here's what doesn't work:

   ...


   - Total hours to complete the assignment (optional): 1 hour


   Please check if true:
   [ ] Yes, we "avoid loitering" (in the course book's terminology) by
   freeing unused references

** Test client

   Below is a skeleton with a test client for your solution. I suggest
   you cut and paste that 

//*** Class skeleton starts

import java.util.Iterator;
public class RandomQueue<Item> implements Iterable<Item>
{

  // Your code goes here. 
  // Mine takes ca. 60 lines, by longest method has 5 lines.


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
   
//*** Class skeleton ends

** My output

    My output looks something like this (depending of course in
    interal random choices):

RandomQueue> java RandomQueue
Some die rolls: 2 1 3 2 4 6 4 6 1 1 2 3 1 3 6 1 3 1 4 3 5 5 3 2 4 2 6 3 2 
Mean (should be around 3.5): 3.4975
Standard deviation (should be around 1.7): 1.6929
Two colours from first shuffle: blue yellow 
Entire second shuffle: yellow green red blue 
Remaining two colours from first shuffle: red green

** Your output
   
   Please paste the output from your code below:
   
Some die rolls: 5 4 6 4 2 3 1 6 4 6 6 4 2 1 4 3 6 4 1 3 4 6 3 3 4 1 6 1 5
Mean (should be around 3.5): 3.4814
Standard deviation (should be around 1.7): 1.7146
Two colours from first shuffle: green red
Entire second shuffle: blue green yellow red 
Remaining two colours from first shuffle: yellow blue

** Help
   List whatever help (if any) that you received, including help from
   TAs or fellow students. (Such help is allowed, but we want you to
   acknowledge it.)

   A student that had algorithms last year. We discussed if there was any
   other implementation method than the resizing array

** Comments
   List any other comments here. Feel free to provide any feedback on
   how much you learned from doing the assignment, and whether you
   enjoyed doing it. In particular, tell us how this exercise could be
   improved.
 
   ...