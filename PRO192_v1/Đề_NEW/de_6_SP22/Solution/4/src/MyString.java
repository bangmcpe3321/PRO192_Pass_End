/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class MyString implements IString {

    @Override
    public int f1(String str) {
       int count=0;
       for (int i=0;i<str.length();i++)
       {
           if (str.charAt(i)>='0' && str.charAt(i)<='9' && str.charAt(i)%2!=0)
           {
               
               count=count+str.charAt(i)-'0';
           }
       }
       return count;
    }

    @Override
    public String f2(String str) {
        String words[] = str.split(" ");
        int pos=0;
        int max=words[0].length();
        for (int i=0;i<words.length;i++)
        {
            if (words[i].length()>max)
            {
                max=words[i].length();
                pos=i;
            }
        }
        for (int i=0;i<pos;i++)
        {
            System.out.print(words[i]+" ");
        }
        for (int i=pos+1;i<words.length;i++)
        {
            System.out.print(words[i]+" ");
        }
        return words[pos];
    }
    
}
