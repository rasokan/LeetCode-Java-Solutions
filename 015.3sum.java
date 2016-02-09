/**
 * @see <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> setList = new HashSet<>();
        if (nums.length < 3) return lists;
        for (int i = 0; i < nums.length - 2; ++i) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                // previously written as nums[low] + nums[high] > target - nums[i])
                // wrong !!!!!!!! where the hell is target !!!!!?????    it is zero in this problem !!!!
                if (nums[low] + nums[high] > 0 - nums[i]) --high;
                else if (nums[low] + nums[high] == 0 - nums[i]) {
                    List<Integer> aRes = new ArrayList<Integer>();
                    aRes.add(nums[i]);
                    aRes.add(nums[low]);
                    aRes.add(nums[high]);
                    setList.add(aRes);
                    // need to do something here, otherwise time limit execeeded !!!!!!!!!
                    // because we will not exit the while loop
                    ++low;
                    --high;
                }
                else ++low;
            }
        }
        for (List<Integer> aList : setList) {
            lists.add(aList);
        }
        nums = newNums;
        return lists;
    }
}