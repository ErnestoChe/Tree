package com.company;

public class aBST {
    public Integer Tree []; // массив ключей

    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int)Math.pow(2, depth) - 1;
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key)
    {
        // ищем в массиве индекс ключа
        int i = 0;
        while(true){
            if(Tree[i] > key){
                i = 2 * i + 1;
            }else if(Tree[i] < key){
                i = 2 * i + 2;
            }
            if(i >= Tree.length){
                return null;
            }
            if(Tree[i] == null){
                i = -i;
                break;
            }
            if(Tree[i] == key){
                break;
            }
        }
        return i; // не найден
    }

    public int AddKey(int key)
    {
        // добавляем ключ в массив
        int i = 0;
        if(Tree[i] == null){
            Tree[i] = key;
        }else{
            while(true){
                if(Tree[i]>key){
                    i = 2 * i + 1;
                }else if(Tree[i]<key){
                    i = 2 * i + 2;
                }
                if(i >= Tree.length){
                    i = -1;
                    break;
                }
                if(Tree[i] == null){
                    Tree[i] = key;
                    break;
                }
                if(Tree[i] == key){
                    break;
                }
            }
        }
        return i;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }
}
