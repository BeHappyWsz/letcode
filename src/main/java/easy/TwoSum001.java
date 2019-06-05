package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * @description: 第一题
 * @author: WSZ
 * @create: 2019-06-05 14:53
 **/
public class TwoSum001 {

    class Solution {
        public int[] twoSum(int[] nums, int target){
            HashMap map = new HashMap();
            for(int i=0; i<nums.length; i++){
                int temp = target - nums[i];
                if(map.containsKey(temp)){
                    return new int[]{(int)map.get(temp), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }

    int[] data = new int[5];
    @Before
    public void initData(){
        Random random = new Random();
        for(int i=0; i< 5; i++){
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testCase(){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(data, 8)));

    }
}