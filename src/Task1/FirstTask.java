package Task1;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть кількість слів (фраз):");
        int num = in.nextInt();
        int i = 0;
        while (i < num) {
            System.out.printf("Поточна ємність string builder: " + sb.capacity() + "\tВведіть cлово № " + (i+1) + ": ");
            String input = in.next();
            i++;
            sb.append(input).append(" ");
        }
        System.out.println("Фінальна ємність string builder: " + sb.capacity() + "\t\nПідсумкове значення:");
        System.out.println(sb.toString().trim());
        in.close();
    }
}
