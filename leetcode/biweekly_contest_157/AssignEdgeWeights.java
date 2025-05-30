package UPSOLVING.leetcode.biweekly_contest_157;

import java.util.*;

public class AssignEdgeWeights 
{
    static int mod = (int)(1e9 + 7);

    static long power(long base, long exp)
    {
        long result = 1;
        while (exp > 0)
        {
            if (exp % 2 == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public static int assignEdgeWeights(int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        depth[1] = 0;
        int maxdepth = 0;
        while (!q.isEmpty())
        {
            int temp = q.poll();
            for (int child : adj.get(temp))
            {
                if (!visited[child])
                {
                    q.add(child);
                    visited[child] = true;
                    depth[child] = depth[temp] + 1;
                    maxdepth = Math.max(maxdepth, depth[child]);
                }
            }
        }
        return (int) power(2, maxdepth - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int result = assignEdgeWeights(edges);
        System.out.println("Result: " + result);
        sc.close();
    }
}
