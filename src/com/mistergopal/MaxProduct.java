package com.mistergopal;

public class MaxProduct {
    public int solution(int[] nums) {
        // problem: find the SUBARRAY w maximum product btwn 2 elements in int arr
        // return that product

        // test ex: [2, 3, -2, 4]

        // solution: 2 pointers, 1 pass
        // reset l or r pointer to 1 if you encounter a 0
        // increment left up from 0, right down from length - 1
        // update max product by comparing to current product

        int n = nums.length;
        int l = 1, r = 1;
        // init return value to 1st el in arr
        int ans = nums[0];

        for(int i = 0; i < n; i++) {
            // reset l and r to 1 if you encounter a 0 along the way
            // ensures we are multiplying and storing products without dip to 0
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            // mult l by current val
            // mult r by value coming down from top (last, 2nd last
            l *= nums[i];
            r *= nums[n - i - 1];

            // crazy line! concept:
            // find max between current answer AND
            // l (mult by curr val) and r(mult from top)

            ans = Math.max(ans, Math.max(l, r));
        }
        return ans;

        // test run:
        // [2, 3, -2, 4]
        // i = 0: ans = 2, l = 2, r = 4 -> ans = 4
        // i = 1: ans = 4, l = 2 -> 6, r = 4 -> -8, --> ans = 6
        // i = 2: ans = 6, l = 6 -> -12, r = -8 -> -24, --> ans = 6
        // i = 3: ans = 6, l = -12 -> -48, r = -24 -> -48, --> ans = 6
    }
}
