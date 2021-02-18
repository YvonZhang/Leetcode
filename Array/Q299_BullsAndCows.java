/*
 * @Author: Yuang Zhang 
 * @email: yuang.zhang.chn@gmail.com
 * @github: https://github.com/YvonZhang
 * @Description: 
 * @Date: 2021-01-31 17:35:11
 * @LastEditors: Yuang Zhang
 * @LastEditTime: 2021-02-18 15:00:58
 * @FilePath: /Leetcode/Array/Q299_BullsAndCows.java
 */
package Array;

public class Q299_BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        // String secret = "1122";
        // String guess = "0001";

        // String secret = "1123";
        // String guess = "0111";
        // String secret = "0";
        // String guess = "1";
        // String secret = "1";
        // String guess = "1";

        Q299_BullsAndCows q299_BullsAndCows = new Q299_BullsAndCows();
        // q299_BullsAndCows.new MyAnswer(secret, guess);
        // q299_BullsAndCows.new MyAnswer2(secret, guess);
        q299_BullsAndCows.new LcAnswer0(secret, guess);

    }

    /**
     * @description: Runtime: 21 ms, faster than 5.14% of Java online submissions
     *               for Bulls and Cows.
     *               <p>
     *               Memory Usage:39.4 MB, less than 28.29% of Java online
     *               submissions for Bulls and Cows.
     * 
     * @param secret
     * @param guess
     * @return
     */
    class MyAnswer {
        MyAnswer(String secret, String guess) {
            System.out.println(getHint(secret, guess));
        }

        public String getHint(String secret, String guess) {
            if (secret == null || secret == "" || guess == null || guess == "") {
                return "0A0B";
            }

            int countBulls = 0; // count of bulls, digits & position both are right
            int countCows = 0; // count of cows, digits is right, position is wrong

            int[] secretArr = strToArr(secret);
            int[] guessArr = strToArr(guess);

            for (int i = 0; i < secretArr.length; i++) {
                if (guessArr[i] < 0)
                    continue;

                // is Bull
                if (secretArr[i] == guessArr[i]) {
                    countBulls++;
                    secretArr[i] = -1;
                    continue;
                }

                // is Cow
                for (int j = 0; j < secretArr.length; j++) {
                    if (secretArr[j] == guessArr[i] && secretArr[j] != guessArr[j]) {
                        countCows++;
                        secretArr[j] = -1;
                        break;
                    }
                }
            }

            return countBulls + "A" + countCows + "B";
        }

        private int[] strToArr(String str) {
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = Integer.parseInt(str.substring(i, i + 1));
            }
            return arr;
        }
    }

    /**
     * @description: Runtime: 6 ms, faster than 59.95% of Java online submissions
     *               for Bulls and Cows.
     *               <p>
     *               Memory Usage: 39.4 MB, less than 28.29% of Java online
     *               submissions for Bulls and Cows.
     * 
     * @param {*}
     * @return {*}
     */
    class MyAnswer2 { // use a counter for each digits, pick the less side and add up.
        MyAnswer2(String secret, String guess) {
            System.out.println(getHint(secret, guess));
        }

        public String getHint(String secret, String guess) {
            if (secret == null || secret == "" || guess == null || guess == "") {
                return "0A0B";
            }

            int countBulls = 0; // count of bulls, digits & position both are right
            int countCows = 0; // count of cows, digits is right, position is wrong

            int[] secretArr = strToArr(secret);
            int[] guessArr = strToArr(guess);

            int[] digitCounterSecretArr = new int[10];
            int[] digitCounterGuessArr = new int[10];

            for (int i = 0; i < secretArr.length; i++) {
                if (guessArr[i] < 0)
                    continue;

                // is Bull
                if (secretArr[i] == guessArr[i]) {
                    countBulls++;
                    continue;
                } else {
                    digitCounterSecretArr[secretArr[i]]++;
                    digitCounterGuessArr[guessArr[i]]++;
                }
            }

            for (int i = 0; i < 10; i++) {
                countCows += Math.min(digitCounterSecretArr[i], digitCounterGuessArr[i]);
            }

            return countBulls + "A" + countCows + "B";
        }

        private int[] strToArr(String str) {
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = Integer.parseInt(str.substring(i, i + 1));
            }
            return arr;
        }
    }

    class LcAnswer0 { // use a counter for each digits, pick the less side and add up.
        LcAnswer0(String secret, String guess) {
            System.out.println(getHint0(secret, guess));
        }
    }

    public String getHint0(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g)
                bulls++;
            else {
                if (numbers[s] < 0)
                    cows++;
                if (numbers[g] > 0)
                    cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    // A slightly more concise version:
    public String getHint1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0)
                    cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0)
                    cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
