/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-28 17:31:02
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-31 21:37:10
 * @FilePath: /Leetcode/test.java
 */

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        int arr[] = { 128, 2556, 2556, 128 };

        System.out.print(arr[1] == arr[2]);
    }

}

/**
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2] Output: 3 Explanation: Start at
 * station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8 Travel to station 0. Your tank
 * = 8 - 2 + 1 = 7 Travel to station 1. Your tank = 7 - 3 + 2 = 6 Travel to
 * station 2. Your tank = 6 - 4 + 3 = 5 Travel to station 3. The cost is 5. Your
 * gas is just enough to travel back to station 3. Therefore, return 3 as the
 * starting index.
 * 
 * 
 * // gas 1 2 3 4 5 // cost 3 4 5 1 2 // diff -2 -2 -2 3 3
 * 
 * // frm1 -2 -4 -6 -3 0 // frm2 0 -2 -4 -1 2 // frm4 4 2 0 3 6
 * 
 * 
 **/