/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-29 18:02:34
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-01-30 11:14:17
 * @FilePath: /Leetcode/Array/Q277_findTheCelebrity.java
 */
package Array;

public class Q277_FindTheCelebrity {
    /*
     * The knows API is defined in the parent class Relation. Boolean knows(int
     * a,int b);
     */
    public Boolean knows(int a, int b) {
        int[][] graph = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        // int[][] graph = { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // int[][] graph = { { 1, 0 }, { 0, 1 } };
        return graph[a][b] == 1;
    }

    public static void main(String[] args) {

        int n = 3;
        Q277_FindTheCelebrity q277_findTheCelebrity = new Q277_FindTheCelebrity();

        // q277_findTheCelebrity.new MyAnswer(n);
        q277_findTheCelebrity.new OptimizedAnswer(n);
    }

    // 执行用时：
    // 993 ms, 在所有 Java 提交中击败了5.45%的用户
    // 内存消耗：
    // 38.9 MB, 在所有 Java 提交中击败了34.60%的用户
    class MyAnswer {
        MyAnswer(int n) {
            System.out.println(findCelebrity(n));
        }

        public int findCelebrity(int n) {
            if (n < 1) {
                return -1;
            }
            for (int i = 0; i < n; i++) { // for each person.
                boolean isCelebrity = true;

                for (int j = 0; j < n; j++) { // for each person they know.
                    if (i == j) { // it's meaningless that they know themselves.
                        continue;
                    }
                    boolean jKnowI = knows(j, i);
                    boolean iKnowJ = knows(i, j);
                    isCelebrity = isCelebrity && jKnowI && !iKnowJ;
                }

                if (isCelebrity) {
                    return i;
                }
            }
            return -1;
        }

    }

    // 执行用时：
    // 26 ms , 在所有 Java 提交中击败了 94.91% 的用户
    // 内存消耗：
    // 38.7 MB , 在所有 Java 提交中击败了80.23% 的用户
    /**
     * @description: key point: knows(i,j) can always determine either i or j is/is
     *               not a celebrity:
     * 
     *               (knows(i,j) == true)=> i know j => i is not celebrity
     * 
     *               (knows(i,j) == false) => i don't know j => j is not celebrity
     * 
     * @param n
     * @return n
     */
    class OptimizedAnswer {
        OptimizedAnswer(int n) {
            System.out.println(findCelebrity(n));
        }

        public int findCelebrity(int n) {
            if (n < 1) {
                return -1;
            }

            int i = 0, j = 1;
            // Find a candidate by one pass (make sure the others are not candidate)
            while (i < n && j < n) {
                // * (knows(i,j) == true)=> i know j => i is not celebrity, j is a candidate
                // *
                // * (knows(i,j) == false) => i don't know j => j is not celebrity, i is a
                // candidate
                if (knows(i, j)) {
                    i = j;
                }
                j++;
            }

            // DON'T NEED TWO PASSES
            // for (int a = 0; a < n; a++) {
            // if (!knows(a, i)) {
            // return -1;
            // }
            // }
            // for (int a = 0; a < n; a++) {
            // i != a could be replaced by if(i == a){continue;}
            // if (knows(i, a) && i != a) {
            // return -1;
            // }
            // }

            // Make sure a candidate is a celebrity by one pass
            for (int a = 0; a < n; a++) {
                if (knows(i, a) && i != a || !knows(a, i)) {
                    return -1;
                }
            }
            return i;
        }
    }
}
