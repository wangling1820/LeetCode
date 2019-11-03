// 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/contest/weekly-contest-161/problems/minimum-remove-to-make-valid-parentheses/
// 使用栈进行括号的匹配，并记录无效括在字符串中的位置
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackLoc = new Stack<>();
        char[] temp = s.toCharArray();
        for (int i=0; i<s.length(); ++i){
            char ch = temp[i];
            if (ch == ')' || ch == '('){
                if (stack.isEmpty()){
                    stack.push(ch);
                    stackLoc.push(i);
                }else if (stack.peek() == '(' && ch == ')'){
                    stack.pop();
                    stackLoc.pop();
                }else{
                    stack.push(ch);
                    stackLoc.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; --i){
            if (!stackLoc.isEmpty() && stackLoc.peek() == i){
                stackLoc.pop();
                continue;
            }
            sb.append(temp[i]);
        }
        return sb.reverse().toString();
    }
}