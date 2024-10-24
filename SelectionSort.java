package algo;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        /**
         * 核心思想:
         * 1. 从0索引开始 跟后面的元素一一比较
         * 2. 小的放前面 打大的放后面
         * 3. 第一次循环结束后 最小的数据已经确定
         * 4. 第二次循环从1索引开始以此类推
         */

        //数据准备
        int[] arr = {3,5,2,4,1};

        for(int i = 0 ;i < arr.length - 1; i++){
            // 每一轮要干什么事情 :
            // 拿着i跟i后面的数据进行比较交换
            for (int j = i + 1 ; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
