package ru.stepup.myprog;

import ru.stepup.myprog.LineTooLongException;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int N = 1;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if ((!fileExists) || (isDirectory)) {
                System.out.println("Файл не существует или указанный путь является путём к папке.");
                continue;
            }

            if (fileExists) {
                System.out.println("Путь к файлу указан верно. Кол-во верно указанных путей к файлу: " + N);
                N++;
                int minLength = Integer.MAX_VALUE;
                int maxLength = Integer.MIN_VALUE;
                int lineCounter = 0;
                String line;
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    while ((line = reader.readLine()) != null) {
                        int length = line.length();
                        if (line.length() > 1024) {
                            throw new LineTooLongException("Слишком длинная строка (максимум 1024 символа).");
                        }
                        if (line.length() < minLength) {
                            minLength = line.length();
                        } else if (line.length() >= maxLength) {
                            maxLength = line.length();
                        }
                        lineCounter++;
                    }
                    System.out.println("Общее кол-во строк в файле: " + lineCounter);
                    System.out.println("Длина самой короткой строки: " + minLength);
                    System.out.println("Длина самой длинной строки: " + maxLength);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}

