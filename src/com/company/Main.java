package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
            list2.add(10 - i);
        }
        System.out.println(list);
        System.out.println(list2);
        list.addAll(list2);
        System.out.println(list);

        System.out.println("---------------------");*/
        SimpleTreeNode<Integer> stn1 = new SimpleTreeNode<>(111, null);
        SimpleTree<Integer> st = new SimpleTree<>(stn1);
        SimpleTreeNode<Integer> node[] = new SimpleTreeNode[10];
        for (int i = 0; i < node.length; i++) {
            node[i] = new SimpleTreeNode<>(i, null);
        }
        st.AddChild(st.Root, node[1]);
        st.AddChild(st.Root, node[0]);
        System.out.println("-------------");
        node[1].log();
        node[0].log();
        st.Root.log();
        System.out.println("=================");
        st.AddChild(node[0], node[2]);
        st.AddChild(node[0], node[3]);
        st.AddChild(node[1], node[4]);
        st.AddChild(node[1], node[5]);
        node[0].log();
        node[3].log();
        System.out.println(st.count);
        System.out.println("++++++++++++++++++");
        List<SimpleTreeNode<Integer>> list = st.GetAllNodes();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).NodeValue);
        }
        System.out.println("fffffffffffffffffff");
        SimpleTreeNode<Integer> find = st.FindNodesByValue(111).get(0);
        System.out.println(st.FindNodesByValue(111).size());
        System.out.println((st.FindNodesByValue(222).isEmpty() ? "empty" : "not empty"));
        find.log();

        int test = 8;
        st.DeleteNode(node[test]);
        list = st.GetAllNodes();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).NodeValue);
        }
        System.out.println((st.FindNodesByValue(test).isEmpty() ? "empty" : "not empty"));
        node[test].log();

        System.out.println("_______________________");

        list = st.GetAllNodes();
        for (SimpleTreeNode i :list) {
            i.log();
        }

        st.MoveNode(node[5], node[0]);

        System.out.println("<-------------->");
        list = st.GetAllNodes();
        for (SimpleTreeNode i :list) {
            i.log();
        }

        
    }
}
