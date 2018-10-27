import java.util.*;

class LinkedList
{
    Node head;
    Node tail;
    public class Node
    {
        Object data;
        Node next;
        Node(Object d)
        {
            data = d;
            next = null;
            
        }

    }// head of list
 
    /* Linked list Node*/
    
    public int getCount()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
 
    /* Function to get Union of 2 Linked Lists */
    void getUnion(Node head1, Node head2)
    {
        Node t1 = head1, t2 = head2;
 
        //insert all elements of list1 in the result
        while (t1 != null)
        {
            pushh(t1.data);
            t1 = t1.next;
        }
 
        // insert those elements of list2 that are not present
        while (t2 != null)
        {
            if (!isPresent(head, t2.data))
                pushh(t2.data);
            t2 = t2.next;
        }
    }
 
    void getIntersection(Node head1, Node head2)
    {
        Node t1 = head1;
 
        // Traverse list1 and search each element of it in list2.
        // If the element is present in list 2, then insert the
        // element to result
        while (t1 != null)
        {
            if (isPresent(head2, t1.data))
                pushh(t1.data);
            t1 = t1.next;
        }
    }
 
    /* Utility function to print list */
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
 
    void rearpush(Object new_data)
    {

    }
    /*  Inserts a node at start of linked list */
    void pushh(Object new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    void deleteNode(Object key) throws Exception
    {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key)
        {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }    
        if (temp == null) throw new Exception();
        prev.next = temp.next;
    }
    public Node returnithnode(int a)
    {
        Node temp=head;
        int c=this.getCount();
        for(int i=(c-1);i>(c-a);i--)
        {



            temp=temp.next;
        }
        return temp;
    }
 
 
    /* A utilty function that returns true if data is present
       in linked list  else return false */
    boolean isPresent (Node head, Object data)
    {
        Node t = head;
        while (t != null)
        {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }
    public boolean isEmpty() {
	    if (head == null) 
	      return true;
	    else
	      return false;
	  }
}
    
    public class Myset
    {
    	LinkedList ll=new LinkedList();
    	public boolean IsEmpty()
    	{
    		return ll.isEmpty();
    	}
    	public boolean IsMember(Object d)
    	{
    		return ll.isPresent(ll.head,d);
    	}
    	public void Insert(Object d)
    	{
    	    if(!IsMember(d))
    		this.ll.pushh(d);
    	}
    	public void Delete(Object d)
    	{
    		try {
				ll.deleteNode(d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();


			}
    		
    	}
    	public Myset Union(Myset a)
    	{
    		Myset c=new Myset();
    		c.ll.getUnion(this.ll.head,a.ll.head);
    		return c;
    		
    	}
    	public Myset Intersection(Myset a)
    	{
    		Myset d=new Myset();
    		d.ll.getIntersection(this.ll.head,a.ll.head);
    		return d;
    	}
    	public  int getcount()
        {
            return ll.getCount();
        }
        public Object getith(int a)

        {
            return ll.returnithnode(a).data;
        }
    	
    	
    	
    	}
    
    
