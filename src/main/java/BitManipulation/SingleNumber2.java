package BitManipulation;

import java.util.Arrays;

public class SingleNumber2 {
    public static void main(String[] args) {
        int ans = singleNumberII(new int[]{5, 5, 5, 2, 4, 4, 4});
//        System.out.println(STR."ans = \{ans}");
    }

    private static int singleNumberII(int[] nums) {
        int[] freq = new int[32];

        for (int n : nums) {
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (bit != 0) {
                    freq[i]++;
                }
                if (freq[i] >= 3) {
                    freq[i] = 0;
                }
            }
        }


        System.out.println(Arrays.toString(freq));


        return -1;
    }
}
