package com.mistergopal;

public class BuySellStock {
    // problem: given num arr of stock prices (index = day of given price), return
    // maximum profit by buying on 1st, selling on 2nd.
    public int maxProfit(int[] prices) {
        // solution: O(n)
        // concept: initialize buy & sell ints to max int and 0, respectively
        // buy should be the min value seen so far
        // sell should be the MAX DIFF btwn buy and itself, ensuring max profit
        int buy = Integer.MAX_VALUE, sell = 0;
        for(int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]); // if current < buy, buy = current
            sell = Math.max(sell, prices[i] - buy); // if today's price - buy price > sell, set sell to that
            // this ensures max profit

        }
        // return max profit
        return sell;
    }
}
