/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-30 18:31:04
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-31 17:01:07
 * @FilePath: /Leetcode/Array/Q41_FirstMissingPositive.java
 */
package Array;

public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int[] nums = { 1, 1 };
        // int[] nums = { 1, 2, 0 };
        // int[] nums = { 1, 2, 4, 5, 7, 8, 3 };
        int[] nums = { 3, 4, -1, 1 };
        // int[] nums = { 7, 8, 9, 11, 12 };
        // int[] nums = { 6, 7, 11, 13, 14, 1, 2, 3, 4, 5 };

        Q41_FirstMissingPositive q41_FirstMissingPositive = new Q41_FirstMissingPositive();
        q41_FirstMissingPositive.new MyAnswer(nums);
    }

    // Runtime:
    // 0 ms, faster than 100.00% of Java online submissions for First Missing
    // Positive.
    // Memory Usage:
    // 36.5 MB, less than 93.21% of Java online submissions for First Missing
    // Positive.
    class MyAnswer {
        MyAnswer(int[] nums) {
            System.out.println(firstMissingPositive(nums));
        }

        public int firstMissingPositive(int[] nums) {
            if (nums.length < 1) {
                return 1;
            }

            // use array as a hash table.
            for (int i = 0; i < nums.length; i++) {
                // needs to fully consider all condition
                while (nums[i] != i + 1 && 0 < nums[i] && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                    // swap
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                    // WARNING: when using in-place algorithm, order would be very important.
                    // i.e
                    // it could not be:
                    //
                    // int tmp = nums[i];
                    // nums[i] = nums[nums[i] - 1] ;
                    // nums[nums[i] - 1] = tmp;
                    //
                    // in line 2, nums[i] has been changed. Then we cannot use the same nums[i] in
                    // line 3
                    // tmp would work.

                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

    }
}