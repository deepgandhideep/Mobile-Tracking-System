
import javax.management.Query;
import java.lang.*;
import java.io.*;
import java.util.*;
public class RoutingMapTree {
	Exchange root;
	ExchangeList all;
	public RoutingMapTree()
	{
		root=new Exchange(0);
		all=new ExchangeList();
		all.push(root);
	}
	public Exchange findPhone(MobilePhone a)
	{
		return a.Base;
	}

	public Exchange lowestRouter(Exchange a,Exchange b)
	{
		if(a==b)
			return a;
		else {
			ExchangeList deep = new ExchangeList();
			ExchangeList an = new ExchangeList();
			while (a != root) {

				deep.push(a);
				a = a.parent;
			}
			deep.push(a);
			while (b != root) {

				an.push(b);
				b = b.parent;
			}
			an.push(b);
			int f = 0;
			while (deep.getExchange(f) == an.getExchange(f)) {
				f++;
			}
			f--;
			return deep.getExchange(f);
		}


	}
	public ExchangeList routeCall(MobilePhone a,MobilePhone b)
	{
		ExchangeList g=new ExchangeList();
		ExchangeList d=new ExchangeList();
		Exchange h=lowestRouter(findPhone(a),findPhone(b));

		Exchange p=findPhone(a);
		Exchange v=findPhone(b);

		while(p.idd != h.idd)
		{
			g.push(p);
			p = p.parent;
		}
		g.push(h);

		g.reverse();
		while(v.idd != h.idd)
		{
			d.push(v);
			v = v.parent;
		}
		int w=g.getCount();
		node z=g.head;
		for(int l=0;l<(w-1);l++)
		{
			z=z.next;
		}
		z.next=d.head;

              	return g;
	}
	public void  movePhone(MobilePhone a,Exchange b)
	{
		 switchOff(a);
         a.phonelocation=b;
         switchOn(a,b);

	}

	public Exchange containsExchange(int a,Exchange root)
	{

		int v=all.getCount();
		for(int n=0;n<v;n++)
		{
			if(a == all.getExchange(n).idd)
			{
				return all.getExchange(n);
			}

		}
		return null;


	}
	public void  switchOn(MobilePhone a,Exchange b)
	{
     if(a.stat==false)
	 {
	 	a.switchOn();
	 	a.Base=b;
	 	a.phonelocation=b;

	 	while(b != root) {

			b.phoneset.insertMobilePhone(a);
			b=b.parent;
		}
		 b.phoneset.insertMobilePhone(a);

	 }

	}
	public void switchOff(MobilePhone a)
	{
         if(a.stat==true)
		 {
		 	a.switchOff();
		 	Exchange ccc=a.phonelocation;

		 	while (ccc != root) {
				ccc.phoneset.desertMobilePhone(a);
				ccc=ccc.parent;
			}
			ccc.phoneset.desertMobilePhone(a);

		 }
	}
	public String performAction(String actionMessage)
	{
		try {
			String s1 = actionMessage;
			String[] words = s1.split(" ");
			if ("addExchange".equals(words[0])) {
				try {
					int a = Integer.parseInt(words[1]);
					int b = Integer.parseInt(words[2]);
					Exchange c = new Exchange(b);
					all.push(c);
					if (containsExchange(a, root) == null) {
						throw new Exception();
					}
					containsExchange(a, root).addchild(c);
					return "";
				} catch (Exception e) {
					System.out.println("No Exchange with Identifier a");
				}
				int a = Integer.parseInt(words[1]);
				return actionMessage + ":" + containsExchange(a, root).phoneset.printall();

			} else if (words[0].equals("switchOnMobile")) {
				int a = Integer.parseInt(words[1]);
				int b = Integer.parseInt(words[2]);
				try {
					MobilePhone q = root.phoneset.findmobile(a);
					if (q == null) {
						MobilePhone w = new MobilePhone(a);
						if (containsExchange(b, root) == null) {
							throw new Exception();
						}
						this.switchOn(w, containsExchange(b, root));

					} else {
						this.switchOn(q, containsExchange(b, root));
					}

					return "";

				} catch (Exception e) {
					System.out.println("Error-No Exchange with identifier b");
				}
			} else if (words[0].equals("queryNthChild")) {
				try {
					int a = Integer.parseInt(words[1]);
					int b = Integer.parseInt(words[2]);
					if (containsExchange(a, root).child(b) == null) {
						throw new Exception();
					}
					int c = containsExchange(a, root).child(b).idd;

					return (actionMessage + ": " + c);
				} catch (Exception e) {
					System.out.println("Error-No b child of Exchange a");
				}


			} else if (words[0].equals("queryMobilePhoneSet")) {
				try {
					int a = Integer.parseInt(words[1]);
					if (containsExchange(a, root).phoneset == null || containsExchange(a, root) == null) {
						throw new Exception();
					}
					return actionMessage + ":" + containsExchange(a, root).phoneset.printall();
				} catch (Exception e) {
					System.out.println("Null");
				}

			} else if (words[0].equals("findPhone")) {
				int a = Integer.parseInt(words[1]);
				try {

					MobilePhone c = root.phoneset.findmobile(a);

					Exchange d = findPhone(c);
					if (c == null) {
						throw new Exception();
					}
					int q = d.idd;

				
					return ("queryFindPhone" + " " + a + ":" + " " + String.valueOf(q));

				} catch (Exception e) {
				return ("queryFindPhone" + " " + a + ":" + " " + "Error - No mobile phone with identifier " + a + " found in the network");
				}
			} else if (words[0].equals("lowestRouter")) {
				try {
					int a = Integer.parseInt(words[1]);
					int b = Integer.parseInt(words[2]);
					if(containsExchange(a,root)== null || containsExchange(b,root)== null)
					{
						throw new Exception();
					}
					return ("queryLowestRouter" + " " + a + " " + b + ":" + " " + String.valueOf(lowestRouter(containsExchange(a, root), containsExchange(b, root)).idd));
				}
				catch(Exception e)
				{
					System.out.println("given Exchange not present");
				}

			} else if (words[0].equals("findCallPath")) {
				int v = 0;
				int a = Integer.parseInt(words[1]);
				int b = Integer.parseInt(words[2]);
				try {
					if (root.phoneset.findmobile(a) == null) {
						v = a;
					}
					if (root.phoneset.findmobile(b) == null) {
						v = b;
					}


					if (root.phoneset.findmobile(a) == null || root.phoneset.findmobile(b) == null) {
						throw new Exception();
					}

					ExchangeList j = routeCall(root.phoneset.findmobile(a), root.phoneset.findmobile(b));
					return ("queryFindCallPath" + " " + a + " " + b + ":" + " " + j.printalll());
				} catch (Exception e) {
					return ("queryFindCallPath " + a + " " + b + ":" + " " + "Error - Mobile phone with identifier " + v + " is currently switched off");
				}

			} else if (words[0].equals(("movePhone"))) {
				String l = new String();
				try {
					int a = Integer.parseInt(words[1]);
					int b = Integer.parseInt(words[2]);

					MobilePhone f = root.phoneset.findmobile(a);
					Exchange z = containsExchange(b, root);
					if (root.phoneset.findmobile(a) == null) {
						l = "mobile phone" + a + " not found";
						throw new Exception();

					}
					if (containsExchange(b, root) == null) {
						l = "Exchange " + b + " not found";
						throw new Exception();

					}
					movePhone(f, z);
					return "";
				} catch (Exception e) {
					return (l);
				}
			} else if (words[0].equals("switchOffMobile")) {
				try {

					int a = Integer.parseInt(words[1]);
					if (root.phoneset.findmobile(a) == null) {
						throw new Exception();
					}
					switchOff(root.phoneset.findmobile(a));
					return "";

				} catch (Exception e) {
					System.out.println("Error: No mobilephone with identifier a");
				}


			} else  {
                 throw new Exception();
			}
		}
		catch(Exception e){
			System.out.println("inconsistent action");
		}
		return "";

	}

	}
	
	
	

