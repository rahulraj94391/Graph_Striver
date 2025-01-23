package LC_Questions.LC1267CountServersThatCommunicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] colFreq = new int[n];
        int[] rowFreq = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowFreq[i]++;
                    colFreq[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowFreq[i] > 1 || colFreq[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }


    @Test
    void testCase1() {
        int actual = countServers(new int[][]{{1, 0}, {0, 1}});
        Assertions.assertEquals(0, actual);
    }

    @Test
    void testCase2() {
        int actual = countServers(new int[][]{{1, 0}, {1, 1}});
        Assertions.assertEquals(3, actual);
    }


    @Test
    void testCase3() {
        int actual = countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}});
        Assertions.assertEquals(4, actual);
    }

    @Test
    void testCase4() {
        int actual = countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 1}});
        Assertions.assertEquals(4, actual);
    }

    @Test
    void testCase5() {
        int actual = countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}});
        Assertions.assertEquals(3, actual);
    }
}