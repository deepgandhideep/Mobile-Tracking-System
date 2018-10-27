
public class Exchange {
	int idd;
	Exchange parent;
	ExchangeList children;
	MobilePhoneSet phoneset;
     public Exchange(int d)
     {
            idd=d;
            children=new ExchangeList();
            phoneset=new MobilePhoneSet();
     }
     public Exchange parent()
     {
    	 return parent;
     }
     public int numchild()
     {
    	 return children.getCount();
     }
     public Exchange child(int i)
     {
    	 node temp=children.head;
    	 int c=this.children.getCount();
    	 if(i>=c)
    	     return null;
    	 for(int n=(c-1);n>(i);n--){
    		 temp=temp.next;
    	 }

    	 return temp.data;

     }
     public boolean isRoot()
     {
         if(this.parent==null)
         return true;
         else
            return false;

     }
     public int depth()
     {
         int f=0;
         Exchange g=this;
         while(!g.isRoot())
         {
             f++;
             g=g.parent;

         }
         return f;
     }
     public MobilePhoneSet residentSet()
     {
         return phoneset;
     }
     public RoutingMapTree subtree(int i)
     {
         node temp=children.head;
         int c=this.children.getCount();

         for(int n=(c-1);n<(c-i);n--) {
             temp = temp.next;

         }
         RoutingMapTree newtree=new RoutingMapTree();
         newtree.root=temp.data;
         return newtree;
     }
     public void addchild(Exchange b)
     {
         children.push(b);
         b.parent=this;
     }




     
     
     
	
}
