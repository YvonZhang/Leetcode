/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-31 21:14:06
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-31 21:55:31
 * @FilePath: /Leetcode/Array/Q134_GasStation.java
 */
package Array;

public class Q134_GasStation {
    public static void main(String[] args) {
        // int[] gas = { 1, 2, 3, 4, 5 };
        // int[] cost = { 3, 4, 5, 1, 2 };
        int[] gas = { 3, 1, 1 };
        int[] cost = { 1, 2, 2 };
        // int[] gas = { 2, 3, 4 };
        // int[] cost = { 3, 4, 3 };

        Q134_GasStation q134_GasStation = new Q134_GasStation();
        q134_GasStation.new MyAnswer(gas, cost);
    }

    /**
     * @description: Runtime: 0 ms, faster than 100.00% of Java online submissions
     *               for Gas Station.
     *               <p>
     *               Memory Usage: 38.9 MB, less than 95.83% of Java online
     *               submissions for Gas Station.
     * @param gas
     * @param cost
     * @return
     */
    class MyAnswer {
        MyAnswer(int[] gas, int[] cost) {
            System.out.println(canCompleteCircuit(gas, cost));
        }

        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas == null || gas.length == 0)
                return -1;

            int s = Integer.MAX_VALUE, b = 0;
            int sIndex = 0;
            for (int i = 0; i < gas.length; i++) {
                b += gas[i] - cost[i];
                if (s > b) {
                    s = b;
                    sIndex = i;
                }
            }

            if (b < 0)
                return -1;
            else
                return (sIndex + 1) % gas.length;
        }
    }
}

// Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
// Output: 3
// Explanation:
// Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 +
// 4 = 4
// Travel to station 4. Your tank = 4 - 1 + 5 = 8
// Travel to station 0. Your tank = 8 - 2 + 1 = 7
// Travel to station 1. Your tank = 7 - 3 + 2 = 6
// Travel to station 2. Your tank = 6 - 4 + 3 = 5
// Travel to station 3. The cost is 5. Your gas is just enough to travel back to
// station 3.
// Therefore, return 3 as the starting index.

// gas: 1 2 3 4 5
// cost 3 4 5 1 2
// diff -2 -2 -2 3 3

// frm1 -2 -4 -6 -3 0
// frm2 0 -2 -4 -1 2
// frm4 4 2 0 3 6
