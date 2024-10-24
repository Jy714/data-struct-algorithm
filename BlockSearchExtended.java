package algo;

/**
 * 分模块查找(无规律的数据)
 */
public class BlockSearchExtended {
    public static void main(String[] args) {

        int[] arr = {27,22,30,40,36,
                13,19,16,20,
                7,10,
                43,50,48};

        BlockExtended b1 = new BlockExtended(22,40,0,4);
        BlockExtended b2 = new BlockExtended(13,20,5,8);
        BlockExtended b3 = new BlockExtended(7,10,9,10);
        BlockExtended b4 = new BlockExtended(43,50,11,13);

        BlockExtended[] blockArr = {b1,b2,b3,b4};

        int number = 100;

        int index = getIndex(blockArr,arr,number);

        System.out.println(index);

    }

    public static int getIndex(BlockExtended[] blockArr,int[] arr,int number){
        //找到数字可能存在的块的索引
        int blockIndex = getBlockIndex(blockArr, number);
        if(blockIndex == -1){
            return -1;
        }
        // 找出块中数据的起始索引和结束索引
        int startIndex = blockArr[blockIndex].getStartIndex();
        int endIndex = blockArr[blockIndex].getEndIndex();

        for (int i = startIndex; i <= endIndex;i++){
            if(arr[i] == number){
                return i;
            }
        }
        //数字不存在数组中
        return -1;
    }

    public static int getBlockIndex(BlockExtended[] blockArr,int number){
        for (int i = 0; i < blockArr.length; i++){
            if(number >= blockArr[i].getMin() && number <= blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }
}

class BlockExtended{
    private int min;
    private int max;
    private int startIndex;
    private int endIndex;

    public BlockExtended(){}

    public BlockExtended(int min, int max, int startIndex, int endIndex){
        this.min = min;
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void setMin(int min){
        this.min = min;
    }

    public int getMin(){
        return this.min;
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
