package BitManipulation;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = generateSubsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    private static ArrayList<ArrayList<Integer>> generateSubsets(int[] nums) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int num = 0; num < 1 << n; num++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((num >> j & 1) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
