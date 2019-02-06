package sample;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
public class atm_collection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int t=0,n;
        
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();          
         map.put(2000,20);
         map.put(500,20);
         map.put(100,20);
         map.put(50,20);
         int bal = 0;
         for(Map.Entry<Integer,Integer> m:map.entrySet())
         {
            bal+=m.getKey()*m.getValue();      
         }
         System.out.println("Balance:"+bal);
         
      do { 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount:");
        int amt=sc.nextInt();
        
        if(amt>bal || amt%50!=0)
            System.out.println("Cant withdraw");
        else
        {
             for(Map.Entry<Integer, Integer> m:map.descendingMap().entrySet())
             {
                n=amt/m.getKey();
                if(n>m.getValue()) 
                    {
                    
                        amt=amt-(n*(int)m.getKey())+(n-(int)m.getValue())*(int)m.getKey();
                        System.out.println("withdraw "+m.getKey()+"s   "+ m.getValue()+"notes      0 remaining");
                        m.setValue(0);
                        
                    }
                else
                    {
                        amt=amt-(n*(int)m.getKey());
                        System.out.println("withdraw "+m.getKey()+"s   "+n+" notes  "+(m.getValue()-n)+" remaining");
                        m.setValue(m.getValue() - n);
                    }
                }
             bal = 0;
             for(Map.Entry<Integer,Integer> m:map.entrySet())
             {
                bal+=m.getKey()*m.getValue();    
                
             }
             System.out.println("Balance:"+bal);
        }
    }while(bal!=0);
    }
}
