package Task6;

import java.util.Arrays;
import java.util.Scanner;

public class AnalyzeExceptions {
     public static void main(String[] args){
        System.out.println("Введіть 1:");
        Scanner in = new Scanner(System.in);
        try {
            if (in.nextInt() == 1) {
                throw new ERROR1EXCEPTION1("throw first exception");
            }
        else{
                throw new ERROR2EXCEPTION2("throw second exception");
            }
        } catch (ERROR1EXCEPTION1 | ERROR2EXCEPTION2 e) {
            try {
                throw new ERROR3EXCEPTION3("throw third exception");
            } catch (ERROR3EXCEPTION3 ex) {
                ex.printStackTrace();
                e.printStackTrace();
                System.out.println(ex.getMessage());
                System.out.println(e.getMessage());
            }
        }
     }
}

class ERROR1EXCEPTION1 extends Exception {
    public ERROR1EXCEPTION1() {}
    public ERROR1EXCEPTION1(String m) {
        super(m);
    }
}
class ERROR2EXCEPTION2 extends Exception {
    public ERROR2EXCEPTION2() {}
    public ERROR2EXCEPTION2(String m) {
        super(m);
    }
}

class ERROR3EXCEPTION3 extends Exception {
    public ERROR3EXCEPTION3() {}
    public ERROR3EXCEPTION3(String m) {
        super(m);
    }
}