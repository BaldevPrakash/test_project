package DSA_Package;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, 1 };
        int target = -2;

        // Call the twoSum function and print the result
        if (twoSumHashSet(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
    
    /// Naive or brute force approach...
    /// Time Complexity O(N^2) , space complexity O(1)
    public static boolean twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /// Using Sorting and binary search...
    /// Time Complexity O(N log(N)) and space complexity O(1)...
    public static boolean twoSumBinarySearch(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int res = BinarySearch(nums , nums[i]);
            if(res != -1){
                return true;
            }
        }
        return false;
    }
    public static int BinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /// Optimum Solution is to use Hash Set to find whether there exist..
    public static boolean twoSumHashSet(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }



}
