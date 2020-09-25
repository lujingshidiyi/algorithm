package leetcode;

import java.util.Stack;

/**
 * @author jlu3
 * @date 2020/9/16
 * Description: algorithm
 */
public class LC232 {
//    使用栈实现队列的下列操作：
//
//    push(x) -- 将一个元素放入队列的尾部。
//    pop() -- 从队列首部移除元素。
//    peek() -- 返回队列首部的元素。
//    empty() -- 返回队列是否为空。
//
//    示例:
//    leetcode.MyQueue queue = new leetcode.MyQueue();
//
//    queue.push(1);
//    queue.push(2);
//    queue.peek();  // 返回 1
//    queue.pop();   // 返回 1
//    queue.empty(); // 返回 false
//
//    说明:
//    你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

    public static void main(String[] args) {
        MyQueue3 obj = new MyQueue3();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
    }
}

class MyQueue {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        int frontElement = newStack.pop();

        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
        return frontElement;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        int frontElement = newStack.peek();
        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
        return frontElement;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}

class MyQueue2 {

    private Stack<Integer> stack;
    int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (empty()) front = x;
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        Stack<Integer> stack2 = new Stack<>();

        while (stack.size() > 1) {
            front = stack.peek();
            stack2.push(stack.pop());
        }

        int ret = stack.pop();

        while (!stack2.isEmpty())
            stack.push(stack2.pop());

        return ret;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}

class MyQueue3 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public MyQueue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}