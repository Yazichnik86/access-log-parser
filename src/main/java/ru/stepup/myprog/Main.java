package ru.stepup.myprog;

import ru.stepup.myprog.LineTooLongException;

import java.io.*;
import java.util.Arrays;
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
                int lineCounter = 0;
                int yandexCounter = 0;
                int googleCounter = 0;
                String line;
                // String[] parts = new String[0];
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    while ((line = reader.readLine()) != null) {
                        int length = line.length();
                        if (line.length() > 1024) {
                            throw new LineTooLongException("Слишком длинная строка (максимум 1024 символа).");
                        }
                        String[] firstBrackets = line.split("\"");
                        String parts[] = firstBrackets[5].split(";");
                        String fragment = null;
                        if (parts.length >= 2) {
                            fragment = parts[1];
                            fragment.split("/");
                            for (String part : parts) {
                                if (part.contains("YandexBot")) {
                                    part.trim();
                                    yandexCounter++;
                                }

                                if (part.contains("Googlebot")) {
                                    part.trim();
                                    googleCounter++;
                                }
                            }
                        }
                        lineCounter++;
                    }
                    System.out.println("Общее количество строк: " + lineCounter);
                    System.out.println("YandexBot: " + yandexCounter + " или " + Math.round(percentage(yandexCounter, lineCounter)) + "% от общего количества.");
                    System.out.println("Googlebot: " + googleCounter + " или " + Math.round(percentage(googleCounter, lineCounter)) + "% от общего количества.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static double percentage(int a, int b) {
        return (double) a / (double) b * 100;
    }
}

