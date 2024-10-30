package Task2;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть рядок:");
        str = in.nextLine();
        System.out.println("Даний рядок: " + str);
        for (char i : str.toCharArray()) {
            if (Character.isUpperCase(i)){
                System.out.printf("\nCимвол %c = літера у ВЕРХНЬОМУ регістрі\n",i);
            }
            else  if (Character.isLowerCase(i)){
                System.out.printf("\nCимвол %c = літера у нижньому регістрі\n", i);
            }
            else  if (Character.isDigit(i)){
                System.out.printf("\nCимвол %c = цифра\n", i);
            }
            else  if (Character.isSpaceChar(i)){
                System.out.printf("\nCимвол %c = пробіл\n", i);
            }
            else{
                System.out.printf("\nCимвол %c = Ні літера, ні цифра, ні пропуск -- якийся інший символ\n", i);
            }
        }
    }
}
