package com.company;

import java.util.Arrays;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root;

    public int [] BSTArray; // временный массив для ключей дерева

    public BalancedBST()
    {
        Root = null;
    }
    @SuppressWarnings("Duplicates")
    public void CreateFromArray(int[] a)
    {
        Arrays.sort(a);
        int size = 0, depth = 0;
        while(size < a.length){
            size = (int)Math.pow(2, depth+1) - 1;
            depth++;
        }
        Integer[] tmp = new Integer[size];
        divideAndConquer(a, 0, a.length-1, tmp);
        BSTArray = new int[size];

        for (int i = 0; i < size; i++) {
            if(tmp[i]!=null)
                BSTArray[i] = tmp[i];
        }
        // создаём массив дерева BSTArray из заданного
        // ...
    }

    @SuppressWarnings("Duplicates")
    public static void divideAndConquer(int[] a, int l, int r, Integer[] tmp)
    {
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
                }else if(tmp[i]<=key){
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
                /*if(tmp[i] == key){
                    break;
                }*/
            }
        }
    }

    public void GenerateTree()
    {

        Root = new BSTNode(BSTArray[0], null);
        Root.Level = 1;
        for (int i = 1; i < BSTArray.length; i++) {
            AddKeyValue(BSTArray[i]);
        }
        // создаём дерево с нуля из массива BSTArray
        // ...
    }

    public void AddKeyValue(int key)
    {
        // добавляем ключ-значение в дерево
        boolean is_key = true;

        BSTNode node_to_add = new BSTNode(key, null);
        BSTNode tmp = Root;
        while(true){
            if(tmp.NodeKey < key){
                if(tmp.RightChild != null){
                    tmp = tmp.RightChild;
                }else{
                    tmp.RightChild = node_to_add;
                    node_to_add.Parent = tmp;
                    node_to_add.Level = node_to_add.Parent.Level+1;
                    break;
                }
            }else if(tmp.NodeKey > key){
                if(tmp.LeftChild != null){
                    tmp = tmp.LeftChild;
                }else{
                    tmp.LeftChild = node_to_add;
                    node_to_add.Parent = tmp;
                    node_to_add.Level = node_to_add.Parent.Level+1;
                    break;
                }
            }

        }
    }



    public boolean IsBalanced(BSTNode root_node)
    {
        if(root_node == null){
            return true;
        }
        if(root_node.LeftChild == null & root_node.RightChild == null){
            return true;
        }

        int l = maxDepth(root_node.LeftChild), r = maxDepth(root_node.RightChild);
        boolean bal = (Math.abs(l-r)<=1);
        if(!bal) return false;
        boolean left = IsBalanced(root_node.LeftChild);
        boolean right = IsBalanced(root_node.RightChild);


        return (left & right & bal); // сбалансировано ли дерево с корнем root_node
    }

    public int maxDepth(BSTNode node)
    {
        if(node == null){
            return 0;
        }else {
            int left = maxDepth(node.LeftChild);
            int right = maxDepth(node.RightChild);
            return Math.max(left, right)+1;
        }
    }
}
