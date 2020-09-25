package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jlu3
 * @date 2020/9/16
 * Description: algorithm
 */
public class LC225 {
    //    使用队列实现栈的下列操作：
//
//    push(x) -- 元素 x 入栈
//    pop() -- 移除栈顶元素
//    top() -- 获取栈顶元素
//    empty() -- 返回栈是否为空
//
//    注意:
//    你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
//    你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

}

class MyStack {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        // 创建另外一个队列 q2
        Queue<Integer> q2 = new LinkedList<>();

        // 除了最后一个元素，将 q 中的所有元素放入 q2
        while (q.size() > 1)
            q2.add(q.remove());

        // q 中剩下的最后一个元素就是“栈顶”元素
        int ret = q.remove();

        // 此时 q2 是整个数据结构存储的所有其他数据，赋值给 q
        q = q2;

        // 返回“栈顶元素”
        return ret;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyStack2 {

    private Queue<Integer> q;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        Queue<Integer> q2 = new LinkedList<>();
        while (q.size() > 1) {
            // 每从 q 中取出一个元素，都给 top 赋值
            // top 最后存储的就是 q 中除了队尾元素以外的最后一个元素
            // 即新的栈顶元素
            top = q.peek();
            q2.add(q.remove());
        }

        int ret = q.remove();
        q = q2;
        return ret;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyStack3 {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack3() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        Queue<Integer> q2 = new LinkedList<>();

//        while(!q.isEmpty())
//            q2.add(q.remove());
//
//        q.add(x);
//
//        while (!q2.isEmpty())
//            q.add(q2.remove());

        q2.add(x);
        while (!q.isEmpty())
            q2.add(q.remove());

        q = q2;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyStack4 {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack4() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        // 首先，将 x 入队
        q.add(x);

        // 执行 n - 1 次出队再入队的操作
        for (int i = 1; i < q.size(); i++)
            q.add(q.remove());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}