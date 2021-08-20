package 两数之和;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 6611 👎 0


import java.util.ArrayList;
import java.util.List;

/**
Definition for singly-linked list.
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
 */
public class Solution {

    public ListNode dataA;
    public ListNode dataB;

    Solution(){
        createData();
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String first = "";
        String second = "";
        do {
            first = l1.val + first;
            l1 = l1.next;
        }while (isHasNext(l1) );

        do {
            second = l2.val + second;
            l2 =l2.next;
        }while (isHasNext(l2) );

        int target = Integer.parseInt(first) + Integer.parseInt(second);

        System.out.println(target);

        String targetStr = target + "";

        char[] chars = targetStr.toCharArray();

        List<ListNode> listNodeList = new ArrayList<>();
        ListNode parentNode = null;
        for (int i = chars.length - 1; i >= 0; i--) {
            char currentChar = chars[i];
            int val = Integer.parseInt(currentChar+"");


            ListNode currentNode = new ListNode(val);
            if (parentNode != null){
                parentNode.next = currentNode;
            }

            parentNode = currentNode;
            listNodeList.add(currentNode);
        }

        return listNodeList.get(0);
    }

    public boolean isHasNext(ListNode listNode){
        return listNode.next != null;
    }

    public void createData (){
        ListNode firstA = new ListNode(2);
        ListNode firstB = new ListNode(4);
        ListNode firstC = new ListNode(3);

        ListNode secondA = new ListNode(5);
        ListNode secondB = new ListNode(6);
        ListNode secondC = new ListNode(4);

        firstA.next = firstB.next = firstC;
        secondA.next = secondB.next = secondC;

        dataA = firstA;
        dataB = secondA;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addTwoNumbers(solution.dataA,solution.dataB);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


