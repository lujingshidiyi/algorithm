package project;

/**
 * @author jlu3
 * @date 2020/9/25
 * Description: algorithm
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 5, 3, 4};
        InsertionSort.sort2(arr);
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void sort2(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            int j;
            for (j = i; arr.length - j > 1 && temp > arr[j + 1]; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }
    }
}
