package medium;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @description: 第二题
 * @author: WSZ
 * @create: 2019-06-05 15:44
 **/
public class AddTwoNumbers002 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuffer data = new StringBuffer();
            ListNode temp = this;
            while(temp != null){
                data.append(temp.val);
                temp = temp.next;
            }
            return data.reverse().toString();
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2){
            // 保存头部节点
            ListNode data = new ListNode(-1);
            // 最终遍历到结尾
            ListNode result = data;
            ListNode node1 = l1, node2 = l2;
            int addFlag = 0;
            int add1, add2, sum;
            while(node1 != null || node2 != null){
                add1 = node1 == null ? 0 : node1.val;
                add2 = node2 == null ? 0 : node2.val;
                sum = add1 + add2 + addFlag;
                result.next = new ListNode(sum % 10);
                addFlag = sum / 10;
                result = result.next;
                node1 = node1 == null ? null : node1.next;
                node2 = node2 == null ? null : node2.next;
            }
            result.next = addFlag > 0 ? new ListNode(1) : null;
            return data.next;
        }
    }

    ListNode list1 = new ListNode(5), list2 = new ListNode(6);

    @Before
    public void initData(){
        Random random = new Random();
        ListNode node1 = list1;
        for(int i=0; i<5; i++){
            node1.next = new ListNode(random.nextInt(10));
            node1 = node1.next;
        }

        ListNode node2 = list2;
        for(int i=0; i<3; i++){
            node2.next = new ListNode(random.nextInt(10));
            node2 = node2.next;
        }
    }

    @Test
    public void testCase(){
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(list1, list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(listNode);
    }
}