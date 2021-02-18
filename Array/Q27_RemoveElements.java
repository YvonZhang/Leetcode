package Array;

/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-28 16:15:34
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-02-18 15:00:48
 * @FilePath: /Leetcode/Array/Q27_RemoveElements.java
 */

import java.util.Arrays;

public class Q27_RemoveElements {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        // int[] nums = { 1, 3, 3, 3 };
        // int[] nums = { 1 };
        // int[] nums = { 3 };
        int val = 3;
        // int[] nums = { 1, 3, 3, 1, 1, 2, 3, 1, 4, 2, 2, 3, 1, 1 };
        // int val = 1;

        Q27_RemoveElements q27_removeElements = new Q27_RemoveElements();
        // q27_removeElements.new MyAnswer(nums, val);
        // q27_removeElements.new LcAnswer2(nums, val);
        q27_removeElements.new YtAnswer(nums, val);

    }

    /**
     * @description: Runtime: 3 ms, faster than 6.72% of Java online submissions for
     *               Remove Element. Memory Usage: 39.2 MB, less than 6.78% of Java
     *               online submissions for Remove Element.
     * 
     * @param nums
     * @param val
     * @return
     */
    class MyAnswer {
        MyAnswer(int[] nums, int val) {
            System.out.println(removeElement(nums, val));
        }

        public int removeElement(int[] nums, int val) {
            int res = 0;
            if (nums == null || nums.length < 1) {
                return res;
            }

            int frontIndex = 0, backIndex = nums.length - 1;

            for (frontIndex = 0; frontIndex <= backIndex; frontIndex++) {
                // find the last available number
                while (true) {
                    if (nums[backIndex] != val || backIndex == frontIndex) {
                        break;
                    }
                    backIndex--;
                }
                if (nums[frontIndex] == val && frontIndex != backIndex) {
                    // swap
                    int tmp = nums[frontIndex];
                    nums[frontIndex] = nums[backIndex];
                    nums[backIndex] = tmp;
                }
            }
            System.out.println(Arrays.toString(nums));

            // for the condition like {1} , 1
            if (nums[frontIndex - 1] != val) {
                frontIndex++;
            }

            return res = frontIndex - 1;
        }
    }

    /**
     * @description: Approach 2: Two Pointers - when elements to remove are rare
     *               Intuition
     * 
     *               Now consider cases where the array contains few elements to
     *               remove. For example, nums = [1,2,3,5,4], val = 4,
     *               nums=[1,2,3,5,4],val=4. The previous algorithm will do
     *               unnecessary copy operation of the first four elements. Another
     *               example is nums = [4,1,2,3,5], val = 4nums=[4,1,2,3,5],val=4.
     *               It seems unnecessary to move elements [1,2,3,5][1,2,3,5] one
     *               step left as the problem description mentions that the order of
     *               elements could be changed.
     * 
     *               Algorithm
     * 
     *               When we encounter nums[i] = valnums[i]=val, we can swap the
     *               current element out with the last element and dispose the last
     *               one. This essentially reduces the array's size by 1.
     * 
     *               Note that the last element that was swapped in could be the
     *               value you want to remove itself. But don't worry, in the next
     *               iteration we will still check this element.
     * @param nums
     * @param val
     * @return
     */
    class LcAnswer2 {
        LcAnswer2(int[] nums, int val) {
            System.out.println(removeElement(nums, val));
        }

        public int removeElement(int[] nums, int val) {
            int i = 0;
            int n = nums.length;
            // How to not to get confused: length would always be arr.length.
            // Only index would be length - 1. do not mess up length and index.
            while (i < n) {
                if (nums[i] == val) {
                    nums[i] = nums[n - 1];
                    // reduce array size by one
                    n--;
                } else {
                    i++;
                }
            }
            return n;
        }
    }

    // kinda like two pointer Approach 1 on Leetcode by using for (int i : num)
    // instead of another pointer
    class YtAnswer {
        YtAnswer(int[] nums, int val) {
            System.out.println(removeElement(nums, val));
        }

        public int removeElement(int[] nums, int val) {
            int res = 0;
            if (nums == null || nums.length < 1) {
                return res;
            }

            int index = 0;
            for (int i : nums) {
                if (i != val) {
                    nums[index++] = i;
                }
            }
            return index;
        }
    }
}