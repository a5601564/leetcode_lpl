package 无重复字符的最长子串03;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    String data = "";

    public int lengthOfLongestSubstring() {
        String s = data;
        System.out.println(s);
        int maxLength = 0;
        int length = s.length();

        List<String> list = new ArrayList<>();
        List<String> lastMaxList = null;

        for (int i = 0; i < length; i++) {
            String current = s.charAt(i) + "";

            if(list.indexOf(current) == -1 ){
                list.add(current);
            }else{
                if (list.size() > maxLength){
                    maxLength = list.size();
                    lastMaxList = List.copyOf(list) ;
                }
                list.clear();
            }

        }
        System.out.println(lastMaxList);
        return maxLength;
    }

    public void createData (){
        this.data = "abcabcbb";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createData();
        int i = solution.lengthOfLongestSubstring();

        System.out.println(i);
    }
}