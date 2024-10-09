public class ListNode
{
	Object data;
	ListNode next;

	ListNode( Object obj )
	{
		this( obj, null );
	}

	ListNode( Object obj, ListNode nextNode )
	{
		data = obj;
		next = nextNode;
	}

	Object getObject() { return data; }
	ListNode getNext() { return next; }
}