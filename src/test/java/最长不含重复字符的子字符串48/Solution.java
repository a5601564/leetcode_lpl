package 最长不含重复字符的子字符串48;

import java.util.HashSet;
import java.util.Set;

class Solution {
    String data;
    Set<String> set = new HashSet<>();
    int maxNum = -1;
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            String current = chars[i] + "";

            if (set.contains(current)){
                maxNum = Math.max( set.size() , maxNum );
                set.clear();
            }
            set.add(current);
        }

        return maxNum;
    }

    public int lengthOfLongestSubstringDP(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            String current = chars[i] + "";

            if (set.contains(current)){
                maxNum = Math.max( set.size() , maxNum );
                set.clear();
            }
            set.add(current);
        }

        return maxNum;
    }


    public void createData (){
        this.data = "pwwkew";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createData();
        int i = solution.lengthOfLongestSubstring(solution.data);

        System.out.println(i);
    }
}