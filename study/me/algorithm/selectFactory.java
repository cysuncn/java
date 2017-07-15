/**
 * Created by Administrator on 2017/6/19.
 */

import java.util.Arrays;


public class selectFactory {
    private class Sort
    {

    }
    //choose the max num
    public static int mini(int num[], int k)
    {
        int length = num.length;
        int j = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = k; i != length; ++i) {
            if (num[i] < minValue) {
                minValue = num[i];
                j = i;
            }
        }
        return j;
    }

    //MergeSort function
    public static int[] mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(nums, low, mid);
            // 右边
            mergeSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

        //selectSort function
        private static int[] selectSort ( int num[])
        {
            int j = 0;
            int tmp = 0;
            int length = num.length;
            for (int i = 0; i != length; ++i) {
                j = mini(num, i);
                tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
            }
            return num;
        }

        //selectFactory function
        private static int[] bubbleSort ( int num[])
        {
            int length = num.length;
            int j = 0;
            int tmp = 0;
            int k = 0;
            for (int i = 0; i != length; ++i) {
                j = i + 1;
                while (j != length) {
                    if (num[i] > num[j]) {
                        tmp = num[j];
                        num[j] = num[i];
                        num[i] = tmp;
                    }
                    j++;
                }
                k++; //use k let find the max num dec
            }
            return num;
        }

    public static void main(String[] args) {
        int num[] = {1, 3, 2, 4, 6, 1, 3, 5, 7, 8, 9, 14, 5, 0};
        int num0[] = {1, 3, 2, 4, 6, 1, 3, 5, 7, 8, 9, 14, 5, 0};
        System.out.println("OriginArry is :" + Arrays.toString(num0));
        int num2[] = bubbleSort(num0);
        System.out.println("selectFactory is :" + Arrays.toString(num2));
        num0 = num;
        System.out.println("OriginArry is :" + Arrays.toString(num0));
        int num3[] = selectSort(num0);
        System.out.println("selectSort is :" + Arrays.toString(num3));
        num0 = new int[] {1, 3, 2, 4, 6, 1, 3, 5, 7, 8, 9, 14, 5, 0};
//        int num_v[] = {1, 3, 2, 4, 6, 1, 3, 5, 7, 8, 9, 14, 5, 0};
        System.out.println("OriginArry is :" + Arrays.toString(num0));
        int temp[] = new int[num0.length];
        int num4[] = mergeSort(num0, 0, num0.length - 1);
        System.out.println("mergeSort  is :" + Arrays.toString(num4));
    }
}
