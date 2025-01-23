package LC_Questions.LC2017_GridGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] prefix = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            prefix[i] = sum;
        }

        long[] suffix = new long[n];
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += grid[1][i];
            suffix[i] = sum;
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, Math.max(prefix[n - 1] - prefix[i], suffix[0] - suffix[i]));
        }

        return res;
    }


    @Test
    public void testCase1() {
        int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        Assertions.assertEquals(4, gridGame(grid));
    }

    @Test
    public void testCase2() {
        int[][] grid = {{3, 3, 1}, {8, 5, 2}};
        Assertions.assertEquals(4, gridGame(grid));
    }

    @Test
    public void testCase3() {
        int[][] grid = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        Assertions.assertEquals(7, gridGame(grid));
    }

    @Test
    public void testCase4() {
        int[][] grid = {{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}};
        Assertions.assertEquals(63, gridGame(grid));
    }

    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return STR."Pair(\{r},\{c})";
        }
    }
}
