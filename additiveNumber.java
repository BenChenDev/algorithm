
/*
*Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
 

Constraints:

num consists only of digits '0'-'9'.
1 <= num.length <= 35
Follow up:
How would you handle overflow for very large input integers?
use Long data type
*/
class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3){return false;}
        for(int i = 1; i <= len/2; i++){
            if(num.charAt(0) == '0' && i > 1){return false;}
            Long first = Long.valueOf(num.substring(0,i));
            
            for(int j = 1; len-i-j >= Math.max(i,j); j++){
                if(num.charAt(i) == '0' && j>1){break;}
                
                Long second = Long.valueOf(num.substring(i,i+j));
                if(isAdditive(first, second, i+j, num)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isAdditive(long num1, long num2, int start, String num) {
        if(start == num.length()) return true;
        Long second = num1+num2;
        long first = num2;
        String sum = second.toString();
        
        return num.startsWith(sum, start) && isAdditive(first, second, start + sum.length(), num);
    }
}