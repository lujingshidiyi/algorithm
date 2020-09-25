package jzoffer;

/**
 * @author jlu3
 * @date 2020/9/25
 * Description: 替换空格
 */
public class LC5 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     * 示例 1：
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * <p>
     * 限制：
     * 0 <= s 的长度 <= 10000
     */
    public static void main(String[] args) {
        SolutionLc5 solutionLc5 = new SolutionLc5();
        System.out.println(solutionLc5.replaceSpace("\"We are happy.\""));
    }
}

class SolutionLc5 {

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer(s);
        int len1 = s.length() - 1;
        for (int i = 0; i <= len1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        int len2 = sb.length() - 1;
        while (len2 > len1 && len1 >= 0) {
            char c = sb.charAt(len1--);
            if (c == ' ') {
                sb.setCharAt(len2--, '0');
                sb.setCharAt(len2--, '2');
                sb.setCharAt(len2--, '%');
            } else {
                sb.setCharAt(len2--, c);
            }
        }
        return sb.toString();
    }

}
