package Task5;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class RealizeCloseable implements Closeable {
    int rc = 50;
    public RealizeCloseable() {
        System.out.println("Constructor RealizeCloseable");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try(RealizeCloseable RC = new RealizeCloseable()){
            System.out.println(RC.rc);
            System.out.println("Введіть нове значення:");
            RC.rc = Integer.parseInt(in.next());
            System.out.println(RC.rc);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void close(){
        System.out.println(rc);
        System.out.println("CLoooooose");
    }
}
