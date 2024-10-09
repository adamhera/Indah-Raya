public class Queue extends LinkedList
{
	public Queue() { } // constructor
	public void enqueue( Object elem)
	{
		insertAtBack (elem);
	}
	public Object dequeue()
	{
		return removeFromFront();
	}
	public Object getFront()
	{
		return getFirst();
	}

} // end Queue