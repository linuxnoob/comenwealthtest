package com.testCommonwealth.testCommon;

import java.util.Scanner;

public class TestHashTag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert Number : ");
        int number = scanner.nextInt();

        for(int i = 0; i < number; ++i) {
            int printedSpace = (number-1)-i;
            int printedHash = i+1;
            for(int j = 0; j < printedSpace; ++j) {
                System.out.print(" ");
            }
            for(int j = 0; j < printedHash; ++j) {
                System.out.print("#");
            }

            System.out.println(" ");
        }

    }
}
