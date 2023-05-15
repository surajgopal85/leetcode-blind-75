package com.mistergopal;

public class RemoveDuplicates {
    public int removeDups(int[] nums) {
        // start i counter at beginning of array
        // j counter begins after
        // every time contents of i and j do not match, you have a unique element:
        // increment i, reset nums[i] to the next element (nums[j])
        // since this is a "late counter" (increments after unique found) it must be returned + 1
        // to capture the true # of unique elements
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
