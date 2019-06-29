package com.company;

import java.util.Arrays;

import static com.company.AlgorithmsDataStructures2.GenerateBBSTArray;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {40, 20, 60, 10, 30, 50, 70, 5, 55, 65, 75};
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        int[] check = GenerateBBSTArray(numbers);
        for (int i = 0; i < check.length; i++) {
            System.out.print(i + " \t");
        }
        System.out.println();
        for (int i = 0; i < check.length; i++) {
            System.out.print(check[i] + " \t");
        }
        System.out.println();


    }
}
