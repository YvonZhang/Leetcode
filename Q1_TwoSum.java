
/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-27 18:18:56
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-30 11:14:02
 * @FilePath: /Leetcode/Q1_twoSum.java
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 5, 6 };
        int target = 10;

        Q1_TwoSum q1_twoSum = new Q1_TwoSum();
        q1_twoSum.new MyAnswer(nums, target);
        q1_twoSum.new LcAnswer2(nums, target);
        q1_twoSum.new LcAnswer3(nums, target);
    }
    // Runtime: 5 ms, faster than 17.15% of Java online submissions for Two Sum.
    // Memory Usage: 42.2 MB, less than 5.75% of Java online submissions for Two
    // Sum.
    // }

    class MyAnswer {
        MyAnswer(int[] nums, int target) {
            System.out.println(Arrays.toString(twoSum(nums, target)));
        }

        public int[] twoSum(int[] nums, int target) {
            // before starting
            if (nums == null || nums.length < 2) {
                return new int[] { -1, -1 };
            }

            Map<Integer, Integer> numMap = new HashMap<>();
            int i = 0;
            // important to set a default value!
            int[] res = { -1, -1 };

            for (int n : nums) {
                // in case of the "put" method overwrite the original record.
                if (numMap.get(target - n) != null && n == target / 2) {
                    int[] result = { numMap.get(n), i };
                    // return new int[] {}
                    return result;
                }
                numMap.put(n, i);
                i++;
            }

            for (int n : nums) {
                if (numMap.get(target - n) != null && numMap.get(n) != numMap.get(target - n)) {
                    int[] result = { numMap.get(n), numMap.get(target - n) };
                    // return new int[] {}
                    return result;
                }
            }
            return null;
        }

    }

    // Approach 2: Two-pass Hash Table
    // To improve our run time complexity, we need a more efficient way to check if
    // the complement exists in the array. If the complement exists, we need to look
    // up its index. What is the best way to maintain a mapping of each element in
    // the array to its index? A hash table.

    // We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for
    // speed. A hash table is built exactly for this purpose, it supports fast look
    // up in near constant time. I say "near" because if a collision occurred, a
    // look up could degenerate to O(n)O(n) time. But look up in hash table should
    // be amortized O(1)O(1) time as long as the hash function was chosen carefully.

    // A simple implementation uses two iterations. In the first iteration, we add
    // each element's value and its index to the table. Then, in the second
    // iteration we check if each element's complement (target -
    // nums[i]target−nums[i]) exists in the table. Beware that the complement must
    // not be nums[i]nums[i] itself!

    // Complexity Analysis:

    // Time complexity : O(n)O(n). We traverse the list containing nn elements
    // exactly twice. Since the hash table reduces the look up time to O(1)O(1), the
    // time complexity is O(n)O(n).

    // Space complexity : O(n)O(n). The extra space required depends on the number
    // of items stored in the hash table, which stores exactly nn elements.

    class LcAnswer2 {
        LcAnswer2(int[] nums, int target) {
            System.out.println(Arrays.toString(twoSum(nums, target)));
        }

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    // Approach 3: One-pass Hash Table
    // It turns out we can do it in one-pass. While we iterate and inserting
    // elements into the table, we also look back to check if current element's
    // complement already exists in the table. If it exists, we have found a
    // solution and return immediately.

    // Complexity Analysis:

    // Time complexity : O(n)O(n). We traverse the list containing nn elements only
    // once. Each look up in the table costs only O(1)O(1) time.

    // Space complexity : O(n)O(n). The extra space required depends on the number
    // of items stored in the hash table, which stores at most nn elements.

    class LcAnswer3 {
        LcAnswer3(int[] nums, int target) {
            System.out.println(Arrays.toString(twoSum(nums, target)));
        }

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

    }

}