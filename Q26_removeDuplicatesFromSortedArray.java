
/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-29 11:33:53
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-29 12:00:39
 * @FilePath: /Java/Leetcode/Q26_removeDuplicatesFromSortedArray.java
 */
import java.util.Arrays;

public class Q26_removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // int[] nums = { 1, 1, 2 };
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        Q26_removeDuplicatesFromSortedArray q26_removeDuplicatesFromSortedArray = new Q26_removeDuplicatesFromSortedArray();
        q26_removeDuplicatesFromSortedArray.new MyAnswer(nums);
        // q26_removeDuplicatesFromSortedArray.new LcAnswer1(nums);
    }

    // Runtime: 10 ms, faster than 7.69% of Java online submissions for Remove
    // Duplicates from Sorted Array.
    // Memory Usage: 45.2 MB, less than 6.05% of Java online submissions for Remove
    // Duplicates from Sorted Array.

    class MyAnswer {
        MyAnswer(int[] nums) {
            System.out.println(removeDuplicates(nums));
        }

        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }

            int n = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    n++;
                    nums[n] = nums[i];
                }
            }

            System.out.println(Arrays.toString(nums));
            return n + 1;
        }
    }

    /**
     * @description: Approach 1: Two Pointers Algorithm
     * 
     *               Since the array is already sorted, we can keep two pointers i
     *               and j, where i is the slow-runner while j is the fast-runner.
     *               As long as nums[i] = nums[j], we increment j to skip the
     *               duplicate.
     * 
     *               When we encounter nums[j] != nums[i], the duplicate run has
     *               ended so we must copy its value to nums[i + 1]. ii is then
     *               incremented and we repeat the same process again until jj
     *               reaches the end of array.
     * 
     * 
     *               Time complexity : O(n). Assume that n is the length of array.
     *               Each of i and j traverses at most n steps.
     * 
     *               Space complexity : O(1).
     * @param nums
     * @return n
     */
    class LcAnswer1 {
        LcAnswer1(int[] nums) {
            System.out.println(removeDuplicates(nums));
        }

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0)
                return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }

            System.out.println(Arrays.toString(nums));
            return i + 1;
        }
    }

}
