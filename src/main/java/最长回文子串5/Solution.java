package 最长回文子串5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    String data;
    Set<String> set = new HashSet<>();
    int length = 1;
    int spreadLen = 1;
    int markBeginLeft = 1;
    int markBeginRight = 1 ;
    
    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        

        for (int i = 1; i < chars.length; i++) {
            spread(i,i,chars);
        }

        int len = length / 2 ;

        char b[] = Arrays.copyOfRange(chars, markBeginLeft - len, markBeginRight + len  + 1);// 截取索引2（包括）到索引6（不包括）的元素
        System.out.println(Arrays.toString(b));

        return null;
    }
    
    public void spread(int left_i,int right_i,char[] chars){
        // 防止越界
        if (! (left_i - spreadLen > -1  &&  right_i + spreadLen < chars.length) )
            return;

        String left = chars[left_i - spreadLen] + "";
        String right = chars[right_i + spreadLen] + "";

        if (left.equals(right)){

            if (2 * spreadLen + 1 > length){
                length = 2 * spreadLen + 1;
                markBeginLeft = left_i;
            }
            spreadLen ++;

        }
    }




    public void createData (){
        this.data = "babad";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createData();
        String s = solution.longestPalindrome(solution.data);

        System.out.println(s);
    }
}