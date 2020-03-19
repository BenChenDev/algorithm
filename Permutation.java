
/**
 *Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

hint: back tracking
 */
class Solution{
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
           return new ArrayList<>();

       List<List<Integer>> finalResult = new ArrayList<>();
       Arrays.sort(nums);
       permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
       return finalResult;
   }

   private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

       if (currResult.size() == nums.length) {
           finalResult.add(new ArrayList<>(currResult));
           return;
       }

       for (int i = 0; i < nums.length; i++) {
           if (used[i])
               continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
           currResult.add(nums[i]);
           used[i] = true;
           permuteRecur(nums, finalResult, currResult, used);
           used[i] = false; // back tracking
           currResult.remove(currResult.size() - 1); //back tracking
       }
   }
}