package app;

import java.util.Random;
import java.util.Scanner;


public class Lesson8 {
    public static void main(String[] args) {
        int[] numbers = new int[15];

        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        System.out.println("Початковий масив:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }

        System.out.println("Відсортований масив:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int searchNumber = scanner.nextInt();

        int left = 0;
        int right = numbers.length - 1;
        int foundIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == searchNumber) {
                foundIndex = mid;
                break;
            } else if (numbers[mid] < searchNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Число знайдено на позиції: " + foundIndex);
        } else {
            System.out.println("Число не знайдено.");
        }
    }
}