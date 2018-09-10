import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 用map: color_num, 进行color及num的映射
 * 每接受一个color，判定color是否在color_num中:
 *  在: 读出color的num并+1，查看是否比max_color大，
 *      是： 修改max_color数量，并更新color_name
 *  不在：说明该颜色第一次出现，初始化颜色map(color,1), 查看是否比max_color大，
 *      是： 修改max_color数量，并更新color_name
 * */
public class P1004LetTheBallonRise {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            if (num==0)
                break;
            Map color_num = new HashMap();
            int max_color = 0;
            String color_name = "";
            String str = in.nextLine();
            for (int i=0;i<num;i++){
                String color = in.nextLine();
                if (color_num.containsKey(color)){
                    int this_color_num = (Integer) color_num.get(color) + 1;
                    if (this_color_num > max_color){
                        max_color = this_color_num;
                        color_name = color;
                    }
                    color_num.put(color,this_color_num);
                }
                else{
                    color_num.put(color,1);
                    if (max_color == 0){
                        max_color = 1;
                        color_name = color;
                    }
                }

            }
            System.out.println(color_name);
        }

    }
}
