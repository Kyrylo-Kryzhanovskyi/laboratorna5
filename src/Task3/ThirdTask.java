package Task3;

import java.io.*;
// cd src
// javac Task3/ThirdTask.java
// java Task3/ThirdTask /Task3/source.txt /Task3/source_copy
public class ThirdTask {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Помилка: вкажіть шлях до файлу-джерела та назву файлу-копії без встановлення типу в якості параметрів. Приклад: /Task3/source.txt /Task3/source_copy");
            return;
        }
        String pathSource1 = args[0];
        String pathSource = System.getProperty("user.dir") +  pathSource1.replace('/', File.separatorChar);
        String pathTarget1 = args[1];
        String pathTarget = System.getProperty("user.dir") +  pathTarget1.replace('/', File.separatorChar);
        System.out.println(pathTarget);
        System.out.println(pathSource);
        copyBytesStream(pathSource,pathTarget + "1.txt");
        copyCharacterStream(pathSource,pathTarget + "2.txt");
        copyLinesStream(pathSource,pathTarget + "3.txt");
    }
    static void copyBytesStream(String pathSource, String pathResult) throws IOException {

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(pathSource)); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathResult))) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            System.out.println("Помилка вводу-виводу: " + e.getMessage());
            e.printStackTrace();
        }
    }
    static void copyCharacterStream(String pathSource, String pathResult) throws IOException {
        BufferedReader inputStream = null; BufferedWriter outputStream = null;

        try {
            inputStream = new BufferedReader (new FileReader(pathSource));
            outputStream = new BufferedWriter(new FileWriter(pathResult));

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            System.out.println("Помилка вводу-виводу: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    static void copyLinesStream(String pathSource, String pathResult) throws IOException {

        BufferedReader inputStream = null; PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(pathSource));
            outputStream = new PrintWriter(new FileWriter(pathResult));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } catch (IOException e) {
            System.out.println("Помилка вводу-виводу: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}
