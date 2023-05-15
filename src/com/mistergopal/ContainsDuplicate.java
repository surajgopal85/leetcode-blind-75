package com.mistergopal;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean solution(int[] nums) {
        // problem, return true if nums contains any duplicate values, false if all uniques
        // O(n)
        // solution: sort arr first to avoid complicated comparisons
        // adjust break condition to compare 1 ahead of i

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
