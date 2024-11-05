package Task4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class FourthTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу: ");
        //String fileName = System.getProperty("user.dir") + ("/src"+in.nextLine()).replace('/', File.separatorChar);
        String fileName = System.getProperty("user.dir") + ("/src"+"/Task4/source.dat").replace('/', File.separatorChar);
        System.out.println(fileName);
        try (DataInputStream fileInputStream = new DataInputStream(new BufferedInputStream(
                new FileInputStream(fileName)))) {
            int byteValue;
            int count = 0;

            System.out.println("Шістнадцятковий дамп файлу:");
            String string = "";
            // Читання файлу побайтово та виведення в шістнадцятковому форматі
            while ((byteValue = fileInputStream.read()) != -1) {
                if (count % 16 == 0) {
                    System.out.printf("%08X  ", count); // Зсув у шістнадцятковому форматі з 8 цифрами
                }
                System.out.printf("%02X ", byteValue);
                string += (char) byteValue;
                count++;

                // Додаємо новий рядок після кожних 16 байт
                if (count % 16 == 0) {
                    System.out.print(" | " + string);
                    System.out.println();
                    string = "";
                }
            }
            if (count % 16 != 0) {
                int remaining = 16 - count % 16;
                for (int i = 0; i < remaining; i++) {
                    System.out.print("   ");
                }
                System.out.print(" | " + string);
                System.out.println();
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: Файл не знайдено.");
            throw new RuntimeException(e);
        } catch (EOFException e) {
            System.out.println("Помилка: Неочікуваний кінець файлу.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Помилка: Помилка доступу до файлу.");
            throw new RuntimeException(e);
        } finally {
            System.out.println("КІНЕЦЬ");
            in.close();
        }
    }

}
