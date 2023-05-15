package com.mistergopal;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // problem: given int arr nums, find indices of two elements that add to int target.
    // NOTE: nums is sorted in ascending order.

    // O(n^2) - less than ideal - nested iteration
    // v simple: check all others against nums[i] for target sum
    // brute force!
    public int[] solution(int[] nums, int target) {
        // initialize vals to store the indices of elements in nums that add to target
        int[] vals = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    vals[0] = nums[i];
                    vals[1] = nums[j];
                    break;
                }
            }
        }
        return vals;
    }

    // O(n) using hashMap
    // hashMap functions like dict in py: k, v store
    // keys are nums, vals are indices
    // complement is ? + nums[i] == target
    // if it's already in the hashMap, grab indices and return in arr
    // key methods get(returns val at key), containsKey(does it already exist), put(equiv to add for ArrayList)
    public int[] hashMapSolution(int[] nums, int target) {
        Map<Integer, Integer> arrMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(arrMap.containsKey(complement)) {
                return new int[] {arrMap.get(complement), i};
            }
            arrMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
