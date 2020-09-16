import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author jlu3
 * @date 2020/9/11
 * Description: algorithm
 */
public class LC34 {
//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//    你的算法时间复杂度必须是 O(log n) 级别。
//    如果数组中不存在目标值，返回 [-1, -1]。
//
//    示例 1:
//    输入: nums = [5,7,7,8,8,10], target = 8
//    输出: [3,4]
//
//    示例 2:
//    输入: nums = [5,7,7,8,8,10], target = 6
//    输出: [-1,-1]

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return searchRange1(nums, target, 0);
    }

    public static int[] searchRange1(int[] nums, int target, int plus) {
        int middle = nums.length / 2;
        if (nums[middle] == target) {
            return findFirstAndLast(nums, middle, target, plus);
        }
        if (nums.length > 1 && nums[middle] < target) {
            return searchRange1(Arrays.copyOfRange(nums, middle, nums.length), target, plus + middle);
        }
        if (nums.length > 1 && nums[middle] > target) {
            return searchRange1(Arrays.copyOfRange(nums, 0, middle), target, plus + 0);
        }
        return new int[]{-1, -1};
    }


    private static int[] findFirstAndLast(int[] nums, int middle, int target, int plus) {
        int first = middle;
        int last = middle;
        while (first >= 0 && nums[first] == target) {
            first--;
        }
        while (last < nums.length && nums[last] == target) {
            last++;
        }
        return new int[]{first + 1 + plus, last - 1 + plus};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 2, 3, 4, 4, 4, 5};
        int target = 5;
        int[] result = searchRange(nums, target);
        IntStream.rangeClosed(0, result.length - 1).forEach(i -> {
            System.out.println(result[i]);
        });
    }
}
