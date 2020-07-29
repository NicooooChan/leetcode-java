import java.util.Arrays;

/**
 * @ClassName SheelSort
 * @Description TODO
 * 希尔排序的复杂度和增量序列是相关的
 * {1,2,4,8,...}这种序列并不是很好的增量序列，使用这个增量序列的时间复杂度（最坏情形）是O(n^2)
 * Hibbard提出了另一个增量序列{1,3,7，...,2^k-1}，这种序列的时间复杂度(最坏情形)为O(n^1.5)
 * Sedgewick提出了几种增量序列，其最坏情形运行时间为O（n^1.3）,其中最好的一个序列是{1,5,19,41,109,...}
 * @Author 陈急舟
 * @Date 2020/07/29 08:31:19
 * @Version 1.0
 */
public class SheelSort {
    public static void sort(int[] arr) {

       int N = arr.length;
       // 进行分组，最开始时的增量（gap）为数组长度的一半
        for (int gap = N/2; gap > 0; gap /= 2) {
            // 对各个分组进行插入排序
            for (int i = 0; i < N; i++) {
                // 将 arr[i] 插入到所在分组的正确位置上
                insertI(arr, gap, i);
            }
        }
    }

    private static void insertI(int[] arr, int gap, int i){
        int inserted = arr[i];
        int j;
        // 插入的时候按组进行插入（组内元素两两相隔gap）
        for (j = i - gap; j >= 0 && inserted < arr[j]; j -= gap) {
            arr[j + gap] = arr[j];
        }
        arr[j + gap] = inserted;
    }

    public static void main(String[] args) {
        int[] arr = {50, 15, 3, 30, 40};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
