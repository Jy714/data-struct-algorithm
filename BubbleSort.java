package algo;

/**
 * 冒泡排序： 相邻的数据两两比较 小的放前面 大的放后面
 * 把一大堆杂乱的数据排成有序的数据 (小到大 大到小都可以)
 */
public class BubbleSort {
    public static void main(String[] args) {
        /**
         *核心思想:
         * 1. 相邻的元素两两比较, 大的放右边, 小的放左边
         * 2. 第一轮比较完毕之后 最大值就已经确定 第一轮可以少循环一次 后面以此类推
         * 3. 如果数组中有n个数据 总共我们只要执行 n-1 轮的代码就可以
         */
        // 数据准备
        int[] arr = {2,4,5,3,1};
        // 利用冒泡排序将数组中的数据变成 1 2 3 4 5
        //第一轮: 结束之后最大值在数组的最右边 . . . . 5
        //for i = 我要执行多少轮
        for (int i = 0; i < arr.length - 1; i++){ // arr.length - 1 是因为如果不减一 最后一个值在做比较的时候会直接报错 (ArrayIndexOutOfBoundsException)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //i 依次表示数组中的每一个元素: 0 1 2 3 4
                //i i+1 (相邻的)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
