import java.util.Arrays;

/**
 * @ClassName InsertionSort1
 * @Description 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
 * @Author 陈急舟
 * @Date 2020/07/28 13:36:46
 * @Version 1.0
 */
public class InsertionSort {

    public static void InsertSort(int[] arr) {
        int i, j;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < arr.length; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                System.out.println(Arrays.toString(arr));
                j--;
            }

            arr[j] = target;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 5, 8, 10, 2};
        InsertSort(arr);
        System.out.println("result:" + Arrays.toString(arr));
    }
}
