import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите первое число:");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = new Scanner(System.in).nextInt();
        System.out.println("Сумма двух чисел:");
        int summa=firstNumber+secondNumber;
        System.out.println(summa);
        System.out.println("Разность двух чисел:");
        int raznost =firstNumber-secondNumber;
        System.out.println(raznost);
        System.out.println("Произведение двух чисел:");
        int proizvedenie=firstNumber*secondNumber;
        System.out.println(proizvedenie);
        System.out.println("Частное двух чисел:");
        double chastnoe=(double) firstNumber/secondNumber;
        System.out.println(chastnoe);
    }
}