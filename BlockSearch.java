package algo;

/**
 * 分块查找 Block Search
 *
 * 原则1: 前一块中的最大数据, 一定小于后一块中所有的数据 (块内无序, 块间有序)
 * 原则2:  块数数量一般等于数字的个数开根号(root). 比如: 16个数字一般分为4块左右
 *        如果自己想要分成7,8 块可以吗？ 答案: 可以的 只不过效率没有那么好
 */
public class BlockSearch {
    public static void main(String[] args) {

        /*
        * 实现步骤:
        * 1. 创建数组blockArr存放每一个块对象的信息
        * 2. 先查找blockArr确定要查找的数据是属于哪一块
        * 3. 再单独便利这一块的数据即可
        * */

        // 1. 要把数据进行分块
        // 问题一: 要分为几块: 18 开根号 4.24块
        //18 / 4 = 4.5个

        //注意事项: 在我们分块的时候必须看是否大过下一块的数字 大过的话就不能让那个数字和前面的一起
        // 以这个情况来说 第一个块不能让21包括在块里 因为18(在第二个块)小于21 那就不成立了
        int[] arr = {16,5,9,12,21,18,
                32,23,37,26,45,34,
                50,48,61,52,73,66};
        // 创建三个块的对象
        Block b1 = new Block(21,0,5);
        Block b2 = new Block(45,6,11);
        Block b3 = new Block(73,12,17);
        // 定义数组来管理三个块的对象 (索引表)
        Block[] blockArr = {b1,b2,b3};
        // 定义一个变量用来记录要查找的元素
        int number = 23;
        //调用方法 传递索引表 数组 要查找的元素
        int index = getIndex(blockArr,arr,number);
        //打印一下
        System.out.println(index);
    }

    //利用分块查找的原理 查询number的索引
    private static int getIndex(Block[] blockArr, int[] arr, int number){
        // 1. 确定number是在哪一块当中的
        int indexBlock = findIndexBlock(blockArr, number);
        if (indexBlock == -1){
            //表示number不在数组当中
            return -1;
        }
        // 获取这一块的起始索引和节数索引
        int startIndex = blockArr[indexBlock].getStartIndex();
        int endIndex = blockArr[indexBlock].getEndIndex();
        //遍历
        for (int i = startIndex; i < endIndex; i++) {
            if(arr[i] == number){
                return i;
            }
        }
        // 数字不在数组当中
        return -1;
    }

    //定义一个方法 用来确定number在索引表的位置 (在哪一块表)
    public static int findIndexBlock(Block[] blockArr, int number){
        //Block b1 = new Block(21,0,5); --- 0
        //Block b2 = new Block(45,6,11); --- 1
        //Block b3 = new Block(73,12,17); --- 2

        // 从0索引开始遍历blockArr 如果number小于max 那么就表示number是在这一块当中的
        for (int i = 0; i < blockArr.length ; i++) {
            if(number <= blockArr[i].getMax()){
                return i;
            }
        }
        return -1; //数据过大 没有在块当中 (没有数据)
    }
}
class Block{
    private int max; // 最大值
    private int startIndex; //起始索引
    private int endIndex; // 结束索引

    public Block(){
    }

    public Block(int max,int startIndex, int endIndex){
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void setMax(int max){
        this.max = max;
    }

    public int getMax(){
        return this.max;
    }

    public void setStartIndex(int startIndex){
        this.startIndex = startIndex;
    }

    public int getStartIndex(){
        return this.startIndex;
    }

    public void setEndIndex(int endIndex){
        this.endIndex = endIndex;
    }

    public int getEndIndex(){
        return this.endIndex;
    }
}

