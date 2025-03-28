package main.java.BitManipulation;

import java.util.List;

public class Bit {
    public static void main(String[] args) {
        System.out.println("sss");
    }
}


class Solution {
    private int majority = -1;
    private int majorityCount = -1;



    public int minimumIndex(List<Integer> nums) {
        return -1;
    }


}

class MergeSort {
    public void sort(int[] nums) {
        divide(nums, 0, nums.length - 1);
    }

    private void divide(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) / 2);
        divide(nums, low, mid);
        divide(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int n = high - low + 1;
        int[] temp = new int[n];

        int left = low;
        int right = mid + 1;
        int pointer = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[pointer] = nums[left];
                pointer++;
                left++;
            } else {
                temp[pointer] = nums[right];
                pointer++;
                right++;
            }
        }

        while (left <= mid) {
            temp[pointer] = nums[left];
            pointer++;
            left++;
        }

        while (right <= high) {
            temp[pointer] = nums[right];
            pointer++;
            right++;
        }

        if (high + 1 - low >= 0) {
            System.arraycopy(temp, 0, nums, low, high + 1 - low);
        }
    }
}

// leetcode node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// gfg node
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}


