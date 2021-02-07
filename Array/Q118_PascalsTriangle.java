/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-02-07 12:56:01
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-02-07 20:36:25
 * @FilePath: /Leetcode/Array/Q118_PascalsTriangle.java
 */
package Array;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalsTriangle {
    public static void main(String[] args) {

        Q118_PascalsTriangle q118_PascalsTriangle = new Q118_PascalsTriangle();
        q118_PascalsTriangle.new MyAnswer();
    }

    class MyAnswer {
        MyAnswer() {
            System.out.println(generate(5).toString());

        }

        /**
         * @description: Runtime: 0 ms, faster than 100.00% of Java online submissions
         *               for Pascal's Triangle.
         * 
         *               Memory Usage: 36.6 MB, less than 95.02% of Java online
         *               submissions for Pascal's Triangle.
         * 
         * @param {int} numRows
         * @return
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (numRows < 1)
                return res;

            ArrayList<Integer> lastRow = new ArrayList<Integer>();

            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> currentRow = new ArrayList<Integer>();
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        currentRow.add(1);
                        continue;
                    }
                    currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                res.add(currentRow);
                lastRow = currentRow;
            }

            return res;

        };

    }
}
