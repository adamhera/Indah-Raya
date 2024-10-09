public class LinkedList
{
	private ListNode firstNode;
	private ListNode lastNode;
	private ListNode currNode; // use to traverse the list
	private String name; // name used for list

	//DEFAULT  CONSTRUCTOR
	public LinkedList()
	{
		this( "list" );
	}

	//NORMAL CONSTRUCTOR
	public LinkedList(String s)
	{
		name = s;
		firstNode = lastNode = currNode = null;
	}

	// Check whether the list is empty, return true if the list is empty
	public boolean isEmpty()
	{
		return (firstNode == null);
	}

	//Insert an object at the front of list
	public void insertAtFront (Object insertItem )
	{
		if ( isEmpty() )
			firstNode = lastNode = new ListNode (insertItem);
		else
			firstNode = new ListNode (insertItem,firstNode );
	}

	// Return the first element in the list
	public Object getFirst()
	{
		if (isEmpty())
		return null;
		else
		{
			currNode = firstNode;
			return currNode.data;
		}
	}

	/*
	Return element of the next node pointed by currNode.
	Use together with getFirst to traverse the list*/

	public Object getNext()
	{
		if (currNode != lastNode)
		{
			currNode = currNode.next;
			return currNode.data;
		}
		else
			return null;
	}

	/*
	Insert an object at the end of the list
	If list is empty, firstNode and lastNode will refer to
	the same Object. Otherwise, lastNode refers to new node.*/

	public void insertAtBack( Object insertItem )
	{
		if ( isEmpty() )
			firstNode = lastNode = new ListNode(insertItem);
		else
			lastNode = lastNode.next = new ListNode(insertItem);
	}

	// Remove the first node from the List.
	public Object removeFromFront()throws EmptyListException
	{
		Object removeItem = null;
		if ( isEmpty() )
		throw new EmptyListException(name);
		removeItem = firstNode.data;
		if ( firstNode.equals (lastNode))
		{
			firstNode = lastNode = null;
		}
		else
			firstNode = firstNode.next;
		return removeItem;
	}

	// Remove the last node from the list.
	public Object removeFromBack( )throws EmptyListException
	{
		Object removeItem = null;
		if ( isEmpty() )
			throw new EmptyListException(name);
		removeItem = lastNode.data;
		if ( firstNode.equals( lastNode ) )
		{
			firstNode = lastNode = null;
		}
		else
		{
			ListNode current = firstNode;
			while ( current.next != lastNode )
				current = current.next;
			lastNode = current;
			current.next = null;
		}
			return removeItem;
	}

	// class to handle the exception
	class EmptyListException extends RuntimeException
	{
		public EmptyListException( String name )
		{
			super( "The " + name + " is empty" );
		}
	}
}