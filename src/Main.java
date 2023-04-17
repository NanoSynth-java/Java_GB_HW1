import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
// Задача № 1
//
//        Random item = new Random();
//        int[] arrays = new int[10];
//        System.out.print("Массив: ");
//        for (int i = 0; i < arrays.length ; i++) {
//            arrays[i] = item.nextInt(2,5);
//            System.out.printf("%d \t", arrays[i]);;
//        }
//        int counter = 0;
//        int max_count = 0;
//        for (int array : arrays) {
//            if (array == 1) {
//                counter += 1;
//                if (counter > max_count)
//                    max_count = counter;
//            } else {
//                counter = 0;
//            }
//        }
//        System.out.println("\nРезультат " + max_count);
//      //////////////
//        Задача № 2
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter value from 2 to 5: ");
//        int val = scanner.nextInt();
//        System.out.printf("value = %d", val);
//        scanner.close();
//
//        Random item = new Random();
//        int[] arrays = new int[10];
//        System.out.print("\nМассив: ");
//        for (int i = 0; i < arrays.length; i++) {
//            arrays[i] = item.nextInt(2, 6);
//        }
//        System.out.println(Arrays.toString(arrays));
//
//        for (int j = 0; j < arrays.length; j++) {
//            for (int k = 0; k < arrays.length - j - 1; k++) {
//                if (arrays[k] == val) {
//                    arrays[k] = arrays[k + 1];
//                    arrays[k + 1] = val;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arrays));
//         Задача №3
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите первое число: ");
//        int input1 = scanner.nextInt();
//        System.out.println("Введите знак арифметической операции: ");
//        String signOfArithmeticOperation = scanner.next();
//        System.out.println("Введите третье число: ");
//        int input3 = scanner.nextInt();
//        String number1 = Integer.toString(input1);
//        String number2 = Integer.toString(input3);
//        String sResult = number1.concat(signOfArithmeticOperation);
//        String sResult2 = sResult.concat(number2);
//        System.out.println(sResult2);
//    }
//}
class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getInt() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
            }
        }
        return result;
    }
}