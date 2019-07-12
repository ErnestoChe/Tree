package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        test_simpleTree();
    }
    public void test_balancedBST(){
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
    public static void test_simpleTree(){
        SimpleTreeNode<Integer>[] node = new SimpleTreeNode[11];
        for (int i = 0; i < node.length; i++) {
            node[i] = new SimpleTreeNode<>(i, null);
        }
        SimpleTree<Integer> st = new SimpleTree<Integer>(node[1]);

        st.AddChild(node[1], node[2]);
        st.AddChild(node[1], node[3]);
        st.AddChild(node[1], node[6]);

        st.AddChild(node[2], node[5]);
        st.AddChild(node[2], node[7]);

        st.AddChild(node[3], node[4]);


        st.AddChild(node[6], node[8]);

        st.AddChild(node[8], node[9]);
        st.AddChild(node[8], node[10]);
        st.AddChild(node[8], node[0]);

        System.out.println(st.count);

        ArrayList evenTrees = st.EvenTrees();
        System.out.println(evenTrees);
    }
}
