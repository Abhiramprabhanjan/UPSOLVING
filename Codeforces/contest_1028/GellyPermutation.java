// package UPSOLVING.Codeforces.contest_1028;
import java.util.*;
public class GellyPermutation 
{
    static int mod= 998244353;
    static int size=100000+1;
    static long bin[]=new long[size];

    public static void pow()
    {
        bin[0]=1;
        for(int i=1;i<size;i++)
         bin[i]=(bin[i-1]*2)%mod;

    }

    public static void main(String[] args) 
    {
        pow();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            long a[]=new long[n];
            long b[]=new long[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextLong();

            for(int i=0;i<n;i++)
            b[i]=sc.nextLong();

            int posa[]=new int[n];
            int posb[]=new int[n];
            for(int i=0;i<n;i++)
            {
                posa[(int)a[i]]=i;
                posb[(int)b[i]]=i;
            }

            long maxa=0;
            long maxb=0;
            List<Long> ans=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                maxa=Math.max(maxa,a[i]);
                maxb=Math.max(maxb,b[i]);
                
                long x=maxa;
                long y=maxb;

                long aval=a[i-posb[(int)y]];
                long bval=b[i-posa[(int)x]];
                long val=0;

                if(x>y || (x==y && bval>= aval))
                {
                     val= (bin[(int)x]+ bin[(int)bval])%mod;
                }
                else
                {
                    val=(bin[(int ) y]+bin[(int )aval])%mod;
                }
                ans.add(val);


            }

            for(long ele:ans)
            System.out.print(ele+" ");
            System.out.println();

        }


        
    }

}
