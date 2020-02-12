package Write1;

import java.util.Scanner;

public class Write1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int count = 0 ;
            int i  =0 ;
            int sum = 0 ;
            StringBuffer sb = new StringBuffer();
            String res = null;
            while(i<str.length()){
                char c =str.charAt(i);
                if (c>='0'&&c<='9'){
                    count++;
                    sb.append(c);
                }else {
                    if(sum<count){
                        res = sb.toString();
                        sum = count;
                    }
                    count= 0 ;
                    sb = new StringBuffer();
                }
                i++;
            }
            if(count > sum){
                res = sb.toString();
            }
            System.out.println(res);
        }
    }
}
