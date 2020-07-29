import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * 我们从一个数组来逐步逐步说明快速排序的方法和思路。
 *
 * 假设我们对数组{7, 1, 3, 5, 13, 9, 3, 6, 11}进行快速排序。
 * 首先在这个序列中找一个数作为基准数，为了方便可以取第一个数。
 * 遍历数组，将小于基准数的放置于基准数左边，大于基准数的放置于基准数右边。
 * 此时得到类似于这种排序的数组{3, 1, 3, 5, 6, 7, 9, 13, 11}。
 * 在初始状态下7是第一个位置，现在需要把7挪到中间的某个位置k，也即k位置是两边数的分界点。
 * 那如何做到把小于和大于基准数7的值分别放置于两边呢，我们采用双指针法，从数组的两端分别进行比对。
 * 先从最右位置往左开始找直到找到一个小于基准数的值，记录下该值的位置（记作 j）。
 * 再从最左位置往右找直到找到一个大于基准数的值，记录下该值的位置（记作 i）。
 * 如果位置i<j，则交换i和j两个位置上的值，然后继续从(j-1)的位置往前和(i+1)的位置往后重复上面比对基准数然后交换的步骤。
 * 如果执行到i==j，表示本次比对已经结束，将最后i的位置的值与基准数做交换，此时基准数就找到了临界点的位置k，位置k两边的数组都比当前位置k上的基准值或都更小或都更大。
 * 上一次的基准值7已经把数组分为了两半，基准值7算是已归位（找到排序后的位置）。
 * 通过相同的排序思想，分别对7两边的数组进行快速排序，左边对[left, k-1]子数组排序，右边则是[k+1, right]子数组排序。
 * 利用递归算法，对分治后的子数组进行排序。
 * 快速排序之所以比较快，是因为相比冒泡排序，每次的交换都是跳跃式的，每次设置一个基准值，将小于基准值的都交换到左边，大于基准值的都交换到右边，这样不会像冒泡一样每次都只交换相邻的两个数，因此比较和交换的此数都变少了，速度自然更高。当然，也有可能出现最坏的情况，就是仍可能相邻的两个数进行交换。
 *
 * 快速排序基于分治思想，它的时间平均复杂度很容易计算得到为O(NlogN)。
 * @Author 陈急舟
 * @Date 2020/07/29 13:10:16
 * @Version 1.0
 */
public class QuickSort {
    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        int len;
        if(array == null
                || (len = array.length) == 0
                || len == 1) {
            return ;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        System.out.println(Arrays.toString(array));
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;
        System.out.println(Arrays.toString(array));

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 13, 9, 3, 6, 11};
        quickSort(arr);
    }
}
