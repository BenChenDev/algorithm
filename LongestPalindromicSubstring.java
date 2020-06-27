/**Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb" 

Related topic: String, Dynamic programming
https://leetcode.com/problems/longest-palindromic-substring/

*/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 0) return "";
        
        int start = 0;
        int end = 0;
        int maxLen = -1;
        for(int i = 0; i < s.length(); i++){
            int len1 = expendFromMiddle(s, i, i);
            int len2 = expendFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > maxLen){
                maxLen = len;
                start = i - ((maxLen-1)/2);
                end = i + (maxLen/2);
                
            }
            
        }
        
        return s.substring(start, end + 1);
    }
    
    public int expendFromMiddle(String s, int left, int right){
        if(s.length() == 0) return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right - left - 1; // this return statement runs after left and right pointer expended,
        //so we do right - left - 1 instend of right - left + 1
    }
}