import java.util.Scanner;

/**
 * 解题思路
 * 动态规划问题
 *
 * 1.定义一个最小的max
 * 2.max_sum存储计算过程的和
 *      k=子集的起始序号
 *      start,end为最后计算结果子集的起止序号
 * 3.从第i个位置开始,i=1...n，
 *      每次计算和值max_sum，若max_sum > max:
 *                                  则max = max_sum
 *                                    start = k
 *                                    end = i
 *                         若max_sum < 0:
 *                                  说明前面的所有计算值不会比子集max大，
 *                                  max_sum = 0;
 *                                  k = i + 1
 *                                  因此从k = i + 1开始继续重新计算
 * 4. 最后的max即为子集的和最大值，start，end分别为起止序号
 *
 * */
public class P1003MaxSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len_num = in.nextInt();
        int case_num = 1;
        String str = in.nextLine();
        while (len_num>0){
            int num = in.nextInt();
            int arr[] = new int[num+1];
            arr[0] = 0;
            for (int i=1;i<arr.length;i++){
                arr[i] = in.nextInt();
            }
            int k = 1;
            int start = 0;
            int end = 0;
            int max_sum = 0;
            int max = -1001;
            for (int i=1;i<arr.length;i++){
                max_sum += arr[i];
                if (max_sum > max){
                    max = max_sum;
                    start = k;
                    end = i;
                }
                if (max_sum < 0){
                    max_sum = 0;
                    k = i + 1;
                }
            }
            System.out.println("Case "+case_num+":");
            System.out.println(max+" "+start+" "+end);
            if (len_num!=1)
                System.out.println();
            len_num--;
            case_num++;
        }
    }
}
