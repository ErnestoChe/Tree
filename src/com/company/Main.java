package com.company;

import java.util.Arrays;

import static com.company.AlgorithmsDataStructures2.GenerateBBSTArray;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {40, 20, 60, 10,
                         30, 50, 70, 5,
                         55, 65, 75, 25,
                         45, 35, 15};
        int[] numbers2 = {10, 30, 50, 5,
                            25, 90, 15};
        Arrays.sort(numbers);
        Arrays.sort(numbers2);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print(numbers2[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print(i + "\t");
        }
        //int[] check = GenerateBBSTArray(numbers);
        //int[] check2 = GenerateBBSTArray(numbers2);
        /*for (int i = 0; i < check.length; i++) {
            System.out.print(i + " \t");
        }
        System.out.println();
        for (int i = 0; i < check.length; i++) {
            System.out.print(check[i] + " \t");
        }
        System.out.println();
        for (int i = 0; i < check2.length; i++) {
            System.out.print(i + " \t");
        }
        System.out.println();
        for (int i = 0; i < check2.length; i++) {
            System.out.print(check2[i] + " \t");
        }
        System.out.println();*/


    }
}
