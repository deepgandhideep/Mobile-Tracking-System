
public class MobilePhone {
	int id;
	boolean stat =false;
	Exchange phonelocation;
	Exchange Base;
	MobilePhone(int d)
	{
		 id=d;
	}
	public int Number()
	{
		return id;
	}
	public boolean status()
	{
		if(stat==true)
			return true;
		else
			return false;
		
	}
	public void switchOn()
	{

			stat=true;		
	}
	public void switchOff()
	{
			stat=false;
	}
	public Exchange location() throws Exception 
	{
		try {
			if (stat == false)
			{throw new Exception();
			}
			else
				return phonelocation;
		}
		catch(Exception e)
		{
			System.out.println("this Phone is switched off");
		}
		
		return null;
	}
	

}
