
public class MobilePhoneSet {
 public Myset cc=new Myset();
    public void insertMobilePhone(MobilePhone a)
    {
    	cc.Insert(a);
    }
    public void desertMobilePhone(MobilePhone b)
    {
    	cc.Delete(b);
    }
    public String printall()
    {
        String h=new String();
        int c = cc.getcount();

        int i;
        for ( i = c; i >1; i--) {
            MobilePhone g = (MobilePhone) cc.getith(i);



            h = h + g.id;
            h = h + ",";
            h = h + " ";


        }
        MobilePhone g = (MobilePhone) cc.getith(i);



        return " "+h+g.id;



    }

        public MobilePhone findmobile(int a)
        {

            int d=cc.getcount();

            for(int i=1;i<(d+1);i++)
            {

             if(((MobilePhone)cc.getith(i)).id==a)
             {
                 return ((MobilePhone)cc.getith(i));
             }
            }
            return null;
        }
    }
