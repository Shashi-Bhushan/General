package in.shabhushan.cp_trials.dynamic_programming;

import java.util.*;

public class LongestIncreasingSubsequence {
  private static Map<Integer, Integer> map;

  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return nums.length;
    map = new HashMap<>();

    return helper(nums, -1);
  }

  private static int helper(int[] nums, int index) {
    if (index == nums.length - 1) return 1;
    else if (map.containsKey(index)) return map.get(index);
    else {
      int max = 1;

      for (int i = index + 1; i < nums.length; i++) {
        if (index == -1) {
          max = Math.max(max, helper(nums, i));
        }
        else if (nums[index] < nums[i]) {
          max = Math.max(max, 1 + helper(nums, i));
        }
      }

      map.put(index, max);
      return max;
    }
  }

  /**
   * Check this for reference
   * https://leetcode.com/problems/longest-increasing-subsequence/discuss/671359/My-Java-DP-Solution-with-Pictorial-Explanation
   */
  public static int lengthOfLISDP(int[] nums) {
    int n = nums.length;
    if (n == 0 || n == 1) return n;

    int[] dp = new int[n];
    dp[0] = 1;

    int ans = 1;

    // between 0 and i, whichever nums[j] is greater than nums[i], get max of dp[j] for those.
    for (int i = 1; i < n; i++) {
      int max = 1;

      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          max = Math.max(max, 1 + dp[j]);
        }
      }

      dp[i] = max;
      ans = Math.max(ans, max);
    }

    return ans;
  }
}
