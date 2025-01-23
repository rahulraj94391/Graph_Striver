package LC_Questions.LC1765_MapofHighestPeak;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // DIRS - TOP, RIGHT. BOTTOM, LEFT
    int[][] DIRS = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        boolean[][] added = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    added[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {

            // pop pair
            Pair pair = q.poll();
            int x = pair.row;
            int y = pair.col;
            int val = pair.val;

            // mark answer
            res[x][y] = val;

            for (int[] dir : DIRS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // check bound add child in queue if child is not added.
                if (isNotAdded(newX, newY, added)) {
                    q.add(new Pair(newX, newY, val + 1));
                    added[newX][newY] = true;
                }
            }
        }
        return res;
    }

    private boolean isNotAdded(int row, int col, boolean[][] added) {
        return (row >= 0 && row < added.length) && (col >= 0 && col < added[0].length) && !added[row][col];
    }

    private static class Pair {
        int row, col, val;

        public Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}