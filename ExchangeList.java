class node
{
	Exchange data;
	node next;
	public node(Exchange e)
	{
		data=e;
		next=null;
	}
	
	
	}
public class ExchangeList {
	 node head=null;

	public int getCount()
	{
		node temp = head;
		int count = 0;
		while (temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	void push(Exchange new_data)
	{
        /* 1 & 2: Allocate the Node &
                 Put in the data*/

		node new_node = new node(new_data);
		if(head==null)
		{
             head=new_node;
             return;
		}

		/* 3. Make next of new Node as head */

		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
		/* 4. Move the head to point to new Node */

	}
	public Exchange  getExchange(int i)
	{
		node temp=head;
		int c=this.getCount();
		for(int n=c;n>(c-i);i--)
		{
			temp=temp.next;
		}
		return temp.data;
	}


	public void reverse() {
		node prev = null;
		node current = head;
		node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head= prev;

	}
	public String printalll()
	{
		String h=new String();
		int y=getCount();
		int q=0;
		for(q=0;q<(y-1);q++)
		{
			Exchange f=this.getExchange(q);

			h = h + f.idd;
			h = h + ",";
			h = h + " ";

		}
		Exchange f=this.getExchange(q);

		h = h + f.idd;






		return h;

	}

}




	
	
	
	
	
	
	
	


