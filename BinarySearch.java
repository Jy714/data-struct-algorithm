package algo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,9,10};
        //要查找的数字
        int number = 8;
        int position = binarySearch(arr, number);
        System.out.println("数字" + number + "在数组中的索引是第" + position + "位" );
    }

    //效率比较高 只不过数据必须要是有序的
    public static int binarySearch(int arr[],int number){
        //用来记录数组索引的位置
        int min = 0;
        //数组的索引是从0开始 所以最后的索引位置需要拿数组的长度(length)减掉1
        int max = arr.length - 1;
        // 利用循环不断地去找想要查找的数据
        while(true){
            //如果min大过max得值 就直接返回 (在数组中没有我们想要查找的数字)
            if(min > max){
                return -1;
            }
            //找到min和max的中间位置
            int mid = (min + max) / 2;
            // 拿着mid指向的元素跟要查找的元素进行比较
            if(arr[mid] > number){
                //如果arr[mid]的值 大于 number的值 这就代表number在左边
                //所以 min值不用变 拿max的值来变 max = mid - 1;
                max = mid - 1;
            }else if(arr[mid] < number){
                //如果arr[mid]的值 大于 number的值 这就代表number在右边
                min = mid + 1;
            }else if(arr[mid] == number){
                //刚好在中间 找到值了 所以直接return这个索引的值 不用改变东西
                return mid;
            }
        }
    }
}

