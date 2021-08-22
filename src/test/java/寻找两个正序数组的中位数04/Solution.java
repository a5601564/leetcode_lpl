package 寻找两个正序数组的中位数04;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    String data = "";

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>() ;

        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Integer[] integers = (Integer[]) list.toArray();
        Arrays.sort(integers);

        return 0;
    }

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