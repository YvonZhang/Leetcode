package Array;
/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-30 11:28:02
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-30 18:11:24
 * @FilePath: /Leetcode/Array/Q189_RotateArray.java
 */

import java.util.Arrays;

public class Q189_RotateArray {
    public static void main(String[] args) {
        // int[] nums = { 1, 1, 1, 1, 1, 1, 7 };
        int[] nums = { 1, 2 };
        int k = 3;
        // int[] nums = { -1, -100, 3, 99 };
        // int[] nums = { -1 };
        // int k = 2;
        // int[] nums = { 1, 2 };
        // int k = 0;

        Q189_RotateArray q189_RotateArray = new Q189_RotateArray();
        // q189_RotateArray.new MyAnswer(nums, k);
        // Try to come up as many solutions as you can, there are at least 3 different
        // ways to solve this problem.
        // Could you do it in-place with O(1) extra space?

        // q189_RotateArray.new LcAnswer4(nums, k);
        q189_RotateArray.new LcAnswer3(nums, k);

    }

    // Runtime:
    // 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
    // Memory Usage:
    // 39.1 MB, less than 96.40% of Java online submissions for Rotate Array.
    class MyAnswer {
        MyAnswer(int[] nums, int k) {
            rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }

        public void rotate(int[] nums, int k) {
            // important
            // if (k > nums.length) {
            k = k % nums.length;
            // }

            int[] head = Arrays.copyOfRange(nums, 0, nums.length - k);
            int[] tail = Arrays.copyOfRange(nums, nums.length - k, nums.length);

            System.arraycopy(tail, 0, nums, 0, tail.length);
            System.arraycopy(head, 0, nums, tail.length, head.length);
        }

    }

    /**
     * @description: Approach 4: Using Reverse Algorithm
     * 
     *               This approach is based on the fact that when we rotate the
     *               array k times, k elements from the back end of the array come
     *               to the front and the rest of the elements from the front shift
     *               backwards.
     * 
     *               In this approach, we firstly reverse all the elements of the
     *               array. Then, reversing the first k elements followed by
     *               reversing the rest n-k elements gives us the required result.
     * 
     *               Let n = 7 and k=3.
     * 
     *               Original List : 1 2 3 4 5 6 7
     * 
     *               After reversing all numbers : 7 6 5 4 3 2 1
     * 
     *               After reversing first k numbers : 5 6 7 4 3 2 1
     * 
     *               After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     * 
     *               Runtime Result:
     * 
     *               Runtime: 0 ms, faster than 100.00% of Java online submissions
     *               for Rotate Array.
     * 
     *               Memory Usage: 39.3 MB, less than 83.35% of Java online
     *               submissions for Rotate Array.
     * 
     * @param nums
     * @param k
     * @return
     */
    class LcAnswer4 {
        LcAnswer4(int[] nums, int k) {
            rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }

        public void rotate(int[] nums, int k) {
            if (nums.length <= 1) {
                return;
            }

            k = k % nums.length;

            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);

        }

        private void reverse(int[] arr, int start, int end) {
            for (; start < end; start++, end--) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
        }

        // another method
        public void LcReverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    class LcAnswer3 {
        LcAnswer3(int[] nums, int k) {
            rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }

        public void rotate(int[] nums, int k) {

            k = k % nums.length;
            if (nums.length < 2 || k < 1) {
                return;
            }

            // 1 2 3 4 5 6 7
            // 1 2 3 1 5 6 7
            // 1 2 3 1 5 6 4
            // 1 2 7 1 5 6 4
            // 1 6 7 1 5 3 4
            // 1 6 7 1 2 3 4
            // 5 6 7 1 2 3 4

            int count = 0;
            for (int i = 0; count < nums.length - 1; i++) {
                int nextIndex = i + k;
                int currentNum = nums[i];

                // have to use index rather than value to determine the index is back to
                // original point, in case of the duplex value.
                while (nextIndex != i) {
                    // swap
                    int tmp = nums[nextIndex];
                    nums[nextIndex] = currentNum;
                    currentNum = tmp;

                    nextIndex = (nextIndex + k) % nums.length;
                    count++;
                }

                // finish the last swap
                nums[nextIndex] = currentNum;
                count++;
            }
        }

        // Approach 3: Using Cyclic Replacements
        public void lcRotate(int[] nums, int k) {
            k = k % nums.length;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }
        }
    }

    // Approach 2: Using Extra Array
    class LcAnswer2 {
        LcAnswer2(int[] nums, int k) {
            rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }

        public void rotate(int[] nums, int k) {
            int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                a[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = a[i];
            }
        }
    }
}