package com.mistergopal;

public class ProductExceptSelf {
    // problem: given arr of nums, return new arr where each element
    // is the product of ALL OTHER ELEMENTS (does not include element at that index).
    // example: nums = [1, 2, 3, 4, 5]
    // products = [120, 60, 40, 30, 24]

    public int[] productsNoSelf(int[] nums) {
        // store length of nums
        // init new arr res to store products except self
        int n = nums.length;
        int[] res = new int[n];

        // solution: have a left pointer storing left sided products
        // right pointer storing right sided products
        // left * right = product except self
        // store in res

        // example: nums = [1, 2, 3, 4, 5]

        // init left to 1 so product is multiplied on and not lost
        int left = 1;
        // move backwards
        for(int i = 0; i < n; i++) {
            if(i > 0)
                left *= nums[i - 1];
            res[i] = left;
        }
        // concept: at this point, res stores "partial products"
        // ex. res[0] == 1, res[1] == 1, res[2] == 1*2 == 2, res[3] == 6 (1*2*3), res[4] == 24 (1*2*3*4)

        // init right to 1 so product is multiplied on and not lost
        int right = 1;
        // now, "reset" using right products
        // ex: res[4] == 24 (no change due to condition, *= 1), res[3] == 30 (6*5), res[2] == 40 (2*20), res[1] == 60 (1*60), res[0] == 120 (1 * 120)
        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1)
                right *= nums[i + 1];
            res[i] *= right;
        }

        return res;
    }
}
