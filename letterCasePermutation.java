/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S.toCharArray().length == 0 || S == null){return res;}
        
        if(isNumeric(S)){
            res.add(S);
            return res;
        }
        
        
        solve(S.toCharArray(),res, 0);
        return res;
    }
    
    private void solve(char[] s, List<String> res, int index) {
        if(index >= s.length) {
            res.add(new String(s));
        }else{
            if(Character.isLetter(s[index])){
                solve(s, res, index+1);
            
            //conver current letter to upper or lower case
            if(Character.isUpperCase(s[index])){
                s[index] = Character.toLowerCase(s[index]);
            }else{
                s[index] = Character.toUpperCase(s[index]);
                
            }
            solve(s, res, index+1);
            
        }else{
            solve(s,res,index+1);
        }
        }
        
        
       
    }
    
    private boolean isNumeric(final String s){
        for(char i : s.toCharArray()){
            if(!Character.isDigit(i)){
                return false;
            }
        }
        return true;
    }
}