import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        System.out.println("Введите размер списка: ");
        try {
            N = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Размер списка может быть задан только целым положительным числом!");
            System.exit(1);
        }
        if (N > 0) {
            ArrayList<Double> originalArray = new ArrayList<>(N);
            try {
                System.out.println("Введите элементы списка: ");
                for (int i = 0; i < N; i++) {
                    originalArray.add(i, scanner.nextDouble());
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Могут быть введены только числа!");
                System.exit(1);
            }
            int k = 0;
            try {
                System.out.println("Введите до какого k-ого элемента(включительно) нужно посчитать среднее арифметическое\nПомните, что индексация элементов в списке начинается с нуля!");
                System.out.print("k: ");
                k = scanner.nextInt();
                scanner.close();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Номер элемента может быть задан только целым числом, которое больше или равно нуля!");
                System.exit(1);
            }
            if ((k >= 0) & (k <= N)) {
                double res = 0;
                LinkedList<Double> tempArray = new LinkedList<>();
                for (int i = 0; i <= k; i++) {
                    res += originalArray.get(i);
                    tempArray.add(originalArray.get(i));
                }
                double srAr = res / tempArray.size();
                ArrayList<Double> newArray = new ArrayList<>(N);
                newArray.addAll(originalArray);
                newArray.set(k, srAr);
                System.out.println("Исходный список: " + originalArray);
                System.out.println("Новый список: " + newArray);
            } else System.out.println("Ошибка! Учитывайте заданный размер и нумерацию индексов, которая начинается с нуля!");
        } else {
            System.out.println("Ошибка! Размер списка - не только целое, но и положительное число!");
        }
    }
}
