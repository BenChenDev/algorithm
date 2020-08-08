/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      helper("", n, n, result);
      return result;
  }
  
  public static void helper(String currentString, int left, int right, List<String> result){
      if(left == 0 && right == 0){
          result.add(currentString);
          return;
      }
      
      if(left > 0){
          helper(currentString + "(", left-1, right, result);
      }
      
      if(left < right){
          helper(currentString + ")", left, right-1, result);
      }
  }
}