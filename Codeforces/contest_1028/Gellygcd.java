import java.util.*;
 public class Gellygcd
{
    static int maxn=5000+1;
    static int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }


    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

           int g=0;
           for(int i=0;i<n;i++)
           g=gcd(g,arr[i]);

           int gcount=0;
           for(int i=0;i<n;i++)
           {
             if(arr[i]==g)
             gcount++;
           }

           if(gcount>0)
           System.out.println(n-gcount);

           else
           {

            Queue<Integer> q=new LinkedList<>();
            boolean visited[]=new boolean[maxn];
            int dp[]=new int[maxn];

            for(int i=0;i<n;i++)
            {
                q.add(arr[i]);
                visited[arr[i]]=true;
                dp[arr[i]]=0;
            }

            while(!q.isEmpty())
            {
                int temp=q.poll();
                for(int ele:arr)
                {
                    
                        int val=gcd(temp,ele);
                       if(!visited[val])
                       {
                          q.add(val);
                          visited[val]=true;
                          dp[val]=dp[temp]+1;
                       }
                        
                    
                }
            }

            System.out.println(n-1 +dp[g]);
           }


        }

            
        
    }
    
}
