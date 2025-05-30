package UPSOLVING.leetcode.biweekly_contest_157;

import java.util.*;

public class MaxSubstrings {
    public static int maxsubstrings(String word) {
        int len = word.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char start = word.charAt(i);
            for (int j = i + 3; j < len; j++) {
                char end = word.charAt(j);
                if (start == end) {
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    adj.add(li);
                    break;
                }
            }
        }
        adj.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));

        int count = 0;
        int lasttime = -1;
        for (List<Integer> li : adj) {
            int initial = li.get(0);
            int end = li.get(1);
            if (initial > lasttime) {
                count++;
                lasttime = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String word = sc.nextLine();
        int result = maxsubstrings(word);
        System.out.println("Max substrings: " + result);
        sc.close();
    }
}