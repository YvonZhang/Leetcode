package Array;

/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-29 15:13:48
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-29 18:00:05
 * @FilePath: /Leetcode/Array/Q80_removeDuplicatesFromSortedArrayII.java
 */
import java.util.Arrays;

public class Q80_removeDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        // int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] nums = { 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3 };

        Q80_removeDuplicatesFromSortedArrayII q80_removeDuplicatesFromSortedArrayII = new Q80_removeDuplicatesFromSortedArrayII();
        q80_removeDuplicatesFromSortedArrayII.new MyAnswer(nums);

    }

    // Runtime: 4 ms, faster than 7.70% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    // Memory Usage: 39.1 MB, less than 75.57% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    class MyAnswer {
        MyAnswer(int[] nums) {
            System.out.println(removeDuplicates(nums));
        }

        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int n = 0;
            for (int i : nums) {
                // if (n < 2 || i > nums[n - 2]) {
                if (n < 2 || i != nums[n - 1] || i != nums[n - 2]) {
                    nums[n++] = i;
                }
            }
            System.out.println(Arrays.toString(nums));
            return n;
        }
    }
}
