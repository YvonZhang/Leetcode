/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-02-14 21:48:51
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-02-15 10:55:47
 * @FilePath: /Leetcode/Array/Q119_PascalsTriangleII.java
 */
package Array;

import java.util.List;
import java.util.ArrayList;

public class Q119_PascalsTriangleII {
    public static void main(String[] args) {

        Q119_PascalsTriangleII q119_PascalsTriangleII = new Q119_PascalsTriangleII();
        q119_PascalsTriangleII.new MyAnswer();
    }

    class MyAnswer {
        MyAnswer() {
            System.out.println(getRow(3).toString());
        }

        /**
         * @description: Runtime: 1 ms, faster than 77.16% of Java online submissions
         *               for Pascal's Triangle II.
         * 
         *               Memory Usage: 36.8 MB, less than 62.57% of Java online
         *               submissions for Pascal's Triangle II.
         * @param {int rowIndex}
         * @return
         */
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<Integer>();
            if (rowIndex < 0) {
                return res;
            }

            for (int i = 0; i < rowIndex + 1; i++) {
                res.add(1);
                for (int j = i - 1; j > 0; j--) {
                    res.set(j, res.get(j) + res.get(j - 1));
                }
            }
            return res;
        }
    }

}
