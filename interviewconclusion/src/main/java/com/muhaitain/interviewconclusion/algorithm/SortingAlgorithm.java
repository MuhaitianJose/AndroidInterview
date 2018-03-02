package com.muhaitain.interviewconclusion.algorithm;

import android.util.Log;

/**
 * Created by Muhaitian on 2018/2/27.
 */

public class SortingAlgorithm {

    private static final String TAG = SortingAlgorithm.class.getSimpleName();

    /**
     * 冒泡排序
     * 数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
     * 设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
     * 这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
     * <p>
     * 平均时间复杂度：O(n2)
     *
     * @param arr
     */
    public static void BubbleSortAscending(int[] arr) {
        //递增排序
        int temp = 0;
        boolean flag = false;
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        long end_time = System.currentTimeMillis();

        Log.d(TAG, "BubbleSort: total time = " + (end_time - start_time));
    }

    public static void BubbleSortDiminishing(int[] arr) {
        //递减排序
        int temp = 0;
        boolean flag = false;
        long start_time = System.currentTimeMillis();
        for (int i = arr.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        long end_time = System.currentTimeMillis();

        Log.d(TAG, "BubbleSort: total time = " + (end_time - start_time));
    }

    /**
     * 选择排序
     * 基本思想：
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * <p>
     * <p>
     * 平均时间复杂度：O(n2)
     *
     * @param arr
     */
    public static void SelctionSortAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

    public static void SelctionSortDiminishing(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 基本思想：
     * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     *
     * @param arr
     */
    public static void InsertionSortAscending(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void InsertionSortDiminishing(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 基本思想：
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
     * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
     *
     * @param arr
     */
    public static void ShellSortAscending(int[] arr) {
        int temp;
        int step_length = arr.length;
        while (true) {
            step_length = step_length / 2;
            for (int k = 0; k < step_length; k++) {
                for (int i = k + step_length; i < arr.length; i += step_length) {
                    for (int j = i; j > k; j -= step_length) {
                        if (arr[j] < arr[j - step_length]) {
                            temp = arr[j];
                            arr[j] = arr[j - step_length];
                            arr[j - step_length] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (step_length == 1) {
                break;
            }
        }
    }

    public static void ShellSortDiminishing(int[] arr) {
        int temp;
        int step_length = arr.length;
        while (true) {
            step_length = step_length / 2;
            for (int k = 0; k < step_length; k++) {
                for (int i = k + step_length; i < arr.length; i += step_length) {
                    for (int j = i; j > k; j -= step_length) {
                        if (arr[j] > arr[j - step_length]) {
                            temp = arr[j];
                            arr[j] = arr[j - step_length];
                            arr[j - step_length] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (step_length == 1) {
                break;
            }
        }
    }

    /**
     * java这种递归调用会内存溢出
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        int i = left, j = right, key = array[left];
        while (i < j) {
            while (i < j && array[j] >= key) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < key) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = key;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    /**
     * 再来看归并排序，其的基本思路就是将数组分成2组A，B，如果这2组组内的数据都是有序的，那么就可以很方便的将这2组数据进行排序。
     * 如何让这2组组内数据有序了？可以将A，B组各自再分成2组。依次类推，当分出来的小组只有1个数据时，可以认为这个小组组内已经达到了有序，
     * 然后再合并相邻的2个小组就可以了。这样通过先递归的分解数列，再合并数列就完成了归并排序。
     * 归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，时间复杂度可以记为O(N)，故一共为O(N*logN)。
     *
     * @param array
     * @param first
     * @param last
     * @param temp
     */
    public static void MergeSort(int[] array, int first, int last, int[] temp) {
        if (first < last) {
            int middle = (first + last) / 2;

            MergeSort(array, first, middle, temp);
            MergeSort(array, middle + 1, last, temp);
            MergeArray(array,first,middle,last,temp);
        }
    }

    public static void MergeArray(int[] array, int first, int middle, int last, int[] temp) {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            } else {
                temp[k] = array[j];
                k++;
                j++;
            }
        }

        while (i <= n) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= m) {
            temp[k] = array[j];
            k++;
            j++;
        }
        for (int mk = 0; mk < k; mk++) {
            array[mk] = temp[mk];
        }
    }

}
