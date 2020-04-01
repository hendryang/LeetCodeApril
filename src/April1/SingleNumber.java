package April1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public int mySolution(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length % 2 == 0) return 0;

        Arrays.sort(nums);
        for (int x = 0; x < nums.length; x += 2) {
            if (x + 1 == nums.length || nums[x] != nums[x + 1]) {
                return nums[x];
            }
        }
        return 0;
    }

    /*
        Time complexity : O(n^2). We iterate through nums, taking O(n) time. We search the whole list to find whether there is duplicate number, taking O(n) time. Because search is in the for loop, so we have to multiply both time complexities which is O(n^2)).
        Space complexity : O(n). We need a list of size nn to contain elements in nums
     */
    public int listSolution(int[] nums) {
        List<Integer> no_dup_list = new ArrayList<>();
        for (int num : nums) {
            if (!no_dup_list.contains(num)) {
                no_dup_list.add(num);
            } else {
                no_dup_list.remove(no_dup_list.size() - 1);
            }
        }
        return no_dup_list.get(0);
    }


    /*
        Time complexity : O(n . 1) = O(n). Time complexity of for loop is O(n). Time complexity of hash table(dictionary in python) operation pop is O(1).
        Space complexity : O(n). The space required by hash_table is equal to the number of elements in nums.
     */
    public int hashTableSolution(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    /*
        Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements in nums.
        Space complexity : O(1).
     */
    public int bitManipulationSolution(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
    @Test
    public void test() {
        int[] num1 = new int[]{1, 1, 2};
        System.out.println(mySolution(num1));
        System.out.println(bitManipulationSolution(num1));
    }
}
