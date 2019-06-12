package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*SimpleTreeNode<Integer> stn1 = new SimpleTreeNode<>(111, null);
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



        st.MoveNode(node[5], node[0]);

        System.out.println("<-------------->");
        list = st.GetAllNodes();
        for (SimpleTreeNode i :list) {
            i.log();
        }
        list = st.GetAllNodes();

        st.GetAllNodes().forEach(SimpleTreeNode::log);

        for (SimpleTreeNode i :list) {
            i.log();
        }
        System.out.println("===================");*/

        BST<Integer> tree = new BST<>(new BSTNode<>(40, 40, null));
        System.out.println(tree.AddKeyValue(20, 20));
        System.out.println(tree.AddKeyValue(60, 60));
        System.out.println(tree.AddKeyValue(10, 10));
        System.out.println(tree.AddKeyValue(30, 30));
        System.out.println(tree.AddKeyValue(50, 50));
        System.out.println(tree.AddKeyValue(70, 70));
        System.out.println(tree.AddKeyValue(5, 5));
        System.out.println(tree.AddKeyValue(45, 45));
        System.out.println(tree.AddKeyValue(55, 55));
        System.out.println(tree.AddKeyValue(65, 65));

        System.out.println(tree.Count());
        System.out.println("==========");
        tree.DeleteNodeByKey(50);
        System.out.println();
        System.out.println(tree.Count());
    }
}
