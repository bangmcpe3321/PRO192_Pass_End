import java.util.List;                              
import java.util.Comparator;
import java.util.Collections;

public class MyCape implements ICape {

    @Override
    public int f1(List<Cape> t) {
        int count=0;
        int dem=0;
        for (int i=0;i<t.size();i++)
        {
            count+=t.get(i).getColor();
        }
        float tbc;
        tbc=count/t.size();
        for (int i=0;i<t.size();i++)
        {
            if (t.get(i).getColor()>tbc)
            {
                dem++;
            }
        }
        return dem;
    }

    @Override
    public void f2(List<Cape> t) {
         int count=0;
        int dem=0;
        for (int i=0;i<t.size();i++)
        {
            count+=t.get(i).getColor();
        }
        float tbc;
        tbc=count/t.size();
        for (int i=0;i<t.size();i++)
        {
            if (t.get(i).getColor()>tbc)
            {
                t.remove(i);
                break;
            }
        }
        
    }

    @Override
//    public void f3(List<Cape> t) {
//       int[] d=new int[100]; 
//       String s;
//       int n=0, dem=0;
//       for (int i=0;i<t.size();i++)
//       {
//           s = t.get(i).getTailor();
//           n=s.length();
//           d[dem]= (int) s.charAt(n-1)-'0';
//           dem++;         
//       }
//      for (int i=0;i<dem;i++)
//       {
//           for (int j=i+1;j<dem;j++)
//           {
//               if (d[i]<d[j])
//               {
//                   Collections.swap(t, i, j);
//                   int x = d[i];
//                   d[i] = d[j];
//                   d[j] = x;
//               }
//           }
//       }
//      
//    }
    public void f3(List<Cape> t) {
      
      Collections.sort(t, new Comparator<Cape>() {
           @Override
          public int compare(Cape o1, Cape o2) {
              char x1 = o1.getTailor().charAt(o1.getTailor().length()-1);
              char x2 = o2.getTailor().charAt(o2.getTailor().length()-1);
              int h1 = (int) x1-'0';
              int h2 = (int) x2-'0';
               
              return -(h1-h2);

          }
        });
      
    }
}