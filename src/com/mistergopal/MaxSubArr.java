package com.mistergopal;

public class MaxSubArr {
    public int solution(int[] nums) {
        // problem: given int arr, find the subArr with max sum
        // solution: 2 pointers: absolute max (maxSoFar), relative max (maxFromHere)
        // compare relative max + current value to current value, store max of 2 AS relative max
        // compare absolute max to relative max, store max of 2 AS absolute max
        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for(int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i] + maxEndingHere, nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
        // test ex: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

    }
    public int altSoln(int[] nums) {
        // same logic, rewriting for practice
        // init currentSum = 0, maxSum to the min possible int
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i]; // add current val to currSum
            maxSum = Math.max(currSum, maxSum); // max now = greater of curr and max
            currSum = Math.max(currSum, 0); // now, if currSum -, ditch for 0, start over adding new #s
            // * more intuitively sensible to me than prev! *
        }
        return maxSum;
        // test
        // [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        // i = 0: currSum = 0 + -2 = -2; maxSum = -2; currSum = 0
        // i = 1: currSum = 0 + 1 = 1; maxSum = 1; currSum = 1
        // i = 2: currSum = 1 + -3 = -2; maxSum = 1; currSum = 0
        // i = 3: currSum = 0 + 4 = 4; maxSum = 4; currSum = 4
        // i = 4: currSum = 4 + -1 = 3; maxSum = 4; currSum = 3
        // i = 5: currSum = 3 + 2 = 5; maxSum = 5; currSum = 5
        // i = 6: currSum = 5 + 1 = 6; maxSum = 6; currSum = 6
        // i = 7: currSum = 6 + -5 = 1; maxSum = 6; currSum = 1
        // i = 8: currSum = 1 + 4 = 5; maxSum = 6; currSum = 5
    }
}
