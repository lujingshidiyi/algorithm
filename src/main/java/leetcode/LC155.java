package leetcode;

import java.util.Stack;

public class LC155 {
    //    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//    push(x) —— 将元素 x 推入栈中。
//    pop() —— 删除栈顶的元素。
//    top() —— 获取栈顶元素。
//    getMin() —— 检索栈中的最小元素。
//             
//    示例:
//    输入：
//        ["leetcode.MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//    输出：
//        [null,null,null,null,-3,null,0,-2]
//    解释：
//        leetcode.MinStack minStack = new leetcode.MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.
//             
//    提示：
//    pop、top 和 getMin 操作总是在 非空栈 上调用。
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.getMin());
        minStack.push(-7);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }
}

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
