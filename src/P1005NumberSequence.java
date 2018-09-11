import java.util.Scanner;

/**
 * 循环列，mod 7意味着循环节为49
 * */
public class P1005NumberSequence {
    public static void main(String[] args){
        Scanner in =  new Scanner(System.in);
        while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            if (a == 0 && b == 0 && n ==0)
                break;
            int f[] = new int[49];
            for (int i = 1;i<49;i++){
                if (i == 1 || i == 2)
                    f[i] = 1;
                else {
                    f[i] = (a*f[i-1] + b*f[i-2]) % 7;
                }
            }
            int index = n % 48;
            System.out.println(f[index]);
        }
    }
}
