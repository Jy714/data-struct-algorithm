package algo;

/**
 * 插入排序: 将0索引的元素到n索引的元素看作是有序地 把n+1索引的元素到最后一个当成是无序的
 * 遍历无序的数据 将遍历到的元素插入有序序列中合适的位置 如果遇到相同元素 插在后面
 * N的范围: 0~最大索引
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        // 找到无序的那一组数据是从哪个索引开始的
        int startIndex = -1;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > arr[i+1]){
//                System.out.println(i);//有序的那一组数据到1索引就结束了
                startIndex = i + 1;
                break;
            }
        }
        // 遍历从startIndex开始到最后一个元素 一次得到无序的那一组数据中的每一个元素
        for (int i = startIndex; i < arr.length; i++) {
            //问题: 如何把遍历到的数据 插入到前面有序的这一组当中
            //记录当前要插入数据的索引
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
