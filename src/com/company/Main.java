package com.company;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        int[] numbers = {40, 20, 60, 10,
                         30, 50, 70, 5,
                         55, 65, 75, 25,
                         45, 35, 15};
        int[] numbers2 = {10, 30, 50, 5,
                            25, 90, 15};
        int[] numbers3 = {1, 5, 3, 6};

        BalancedBST bal = new BalancedBST();
        bal.CreateFromArray(numbers3);
        bal.GenerateTree();
        for (int i = 0; i < bal.BSTArray.length; i++) {
            System.out.print(bal.BSTArray[i] + " ");
        }
        System.out.println();

        System.out.println(bal.IsBalanced(bal.Root.LeftChild));
    }
}
