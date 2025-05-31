package UPSOLVING.Codeforces.contest_1028;

import java.util.*;
 public class Gelly
{
    public static void main(String[] args) 
    {
        // System.out.println("enter tc");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();

            

            if(Math.min(b,d)<=Math.min(a,c))
            System.out.println("Gellyfish");
            else
            System.out.println("Flower");


        }
        
    }

    
}
