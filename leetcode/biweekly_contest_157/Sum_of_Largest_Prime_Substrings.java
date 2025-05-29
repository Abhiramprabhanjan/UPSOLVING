package UPSOLVING.leetcode.biweekly_contest_157;

import java.util.*;


public class Sum_of_Largest_Prime_Substrings
{

    public static boolean  isprime(long n)
    {
        if(n<2)
        return false;

        if(n==2)
        return true;

        if(n%2==0)
        return false;

        for(int i=3;i*i<=n;i++)
        {
            if(n%i==0)
            return false;
        }
        return true;
       

    }

    
    public static long sumOfLargestPrimes(String str)
    {
        Set<Long> primes=new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            for(int j=i+1;j<str.length();j++)
            {
                String sub=str.substring(i,j);
                long val=Long.parseLong(sub);
                primes.add(val);
            }
        }

        long sum=0;
        List<Long> ans=new ArrayList<>();
        for(long ele:primes)
        {
            if(isprime(ele))
            ans.add(ele);
        }

        Collections.sort(ans,Collections.reverseOrder());
        int size=Math.min(ans.size(),3);
        for(int i=0;i<size;i++)
        sum+=ans.get(i);
        
        return sum;



    
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        long ans=sumOfLargestPrimes(str);
        System.out.println(ans);


       





        

        






        
    }
    

    
}
