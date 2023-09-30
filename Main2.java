package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Задача *:
//        Написать try/catch/finally, в котором finally вызван не будет
        Scanner sc = new Scanner(System.in);
        int number = 0;
            System.out.print("Укажите число меньше 20:");
            try {
                number = sc.nextInt();

                if(number < 20)
                    System.out.println("Замечательно!");
                else System.out.println("Неправильно");
                System.exit(0);

            }catch(InputMismatchException e){
                System.err.println("Нужно ввести именно число...");
                System.exit(0);
            }
            finally {
                System.out.println("___________");

            }
    }
}
