package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);
        int size = 0, depth = 0;
        while(size < a.length){
            size = (int)Math.pow(2, depth+1) - 1;
            depth++;
        }

        //"а для кого дебаг придумали, а?"
        //System.out.println(size + " size of new array");
        //System.out.println(a.length + " size of old");

        Integer[] tmp = new Integer[size];
        divideAndConquer(a, 0, a.length-1, tmp);
        int[] new_a = new int[size];
        for (int i = 0; i < size; i++) {
            if(tmp[i]!=null)
            new_a[i] = tmp[i];
        }
        return new_a;
    }
    public static void divideAndConquer(int[] a, int l, int r, Integer[] tmp){
        if(r>=l){
            int mid = l + (r-l)/2;
            //System.out.println(a[mid]);
            AddKey(a[mid], tmp);
            divideAndConquer(a, l, mid-1, tmp);
            divideAndConquer(a, mid+1, r, tmp);
        }
    }

    public static void AddKey(int key, Integer[] tmp)
    {
        // добавляем ключ в массив
        int i = 0;
        if((tmp[i]) == null){
            tmp[i] = key;
        }else{
            while(true){
                if(tmp[i]>key){
                    i = 2 * i + 1;
                }else if(tmp[i]<key){
                    i = 2 * i + 2;
                }
                if(i >= tmp.length){
                    i = -1;
                    break;
                }
                if((tmp[i]) == null){
                    tmp[i] = key;
                    break;
                }
                if(tmp[i] == key){
                    break;
                }
            }
        }
    }
}
//29.06.2019
//ищем элементы за O(logN)?
//изи
//смог в рекурсию
