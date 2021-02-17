/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-02-15 23:19:07
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-02-17 22:31:40
 * @FilePath: /Leetcode/Array/Q229_MajorityElementII.java
 */
package Array;

import java.util.ArrayList;
import java.util.List;

public class Q229_MajorityElementII {
    public static void main(String[] args) {

        // int[] nums = { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 3 };
        // int[] nums = { 1, 1, 2, 2, 7, 7, 8, 8, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9,
        // 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3,
        // 9, 3, 9, 3, 9, 3 };
        int[] nums = { 2, 1, 1, 3, 1, 4, 5, 6 };
        // int[] nums = { 1 };
        // int[] nums = { 1, 2 };

        Q229_MajorityElementII q229_MajorityElementII = new Q229_MajorityElementII();
        q229_MajorityElementII.new MyAnswer(nums);
    }

    class MyAnswer {
        MyAnswer(int[] nums) {
            System.out.println(majorityElement(nums).toString());
        }

        /**
         * @description: https://assets.leetcode.com/users/andriy111/image_1584562040.png
         * 
         *               Runtime: 3 ms, faster than 53.92% of Java online submissions
         *               for Majority Element II.
         * 
         *               Memory Usage: 42.8 MB, less than 58.37% of Java online
         *               submissions for Majority Element II.
         * 
         * @param {int[]} nums
         * @return {*}
         */
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<Integer>();

            if (nums == null)
                return res;

            int countA = 0, countB = 0;
            Integer candidateA = null, candidateB = null;

            for (int i : nums) {
                if (countA == 0 && (candidateB == null || candidateB != i))
                    candidateA = i;
                if (countB == 0 && candidateA != i)
                    candidateB = i;

                if (candidateA == i)
                    countA++;
                if (candidateB != null && candidateB != candidateA && candidateB == i)
                    countB++;
                if (candidateB != null && candidateA != i && candidateB != i) {
                    countA--;
                    countB--;
                }
            }

            int validateA = 0, validateB = 0;
            for (int i : nums) {
                if (candidateA == i) {
                    validateA++;
                }
                if (candidateB != null && candidateB == i) {
                    validateB++;
                }
            }

            if (validateA > nums.length / 3)
                res.add(candidateA);
            if (candidateB != null && candidateB != candidateA && validateB > (float) nums.length / 3)
                res.add(candidateB);
            return res;
        }
    }
}