package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {40, 20, 60, 10, 30, 50, 70, 5, 45, 55, 65, 75};

        aBST abst = new aBST(4);
        for (int i:numbers) {
            System.out.println(i+"\t"+abst.AddKey(i));
        }
        System.out.println();

        System.out.println(abst.AddKey(50));
    }
}
