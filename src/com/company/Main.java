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

        BST<Integer> tree = new BST<>(new BSTNode<>(5, 555, null));
        System.out.println(tree.AddKeyValue(2, 222));
        System.out.println(tree.AddKeyValue(7, 777));
        //System.out.println(tree.AddKeyValue(7, 456));
        System.out.println(tree.AddKeyValue(1, 111));
        System.out.println(tree.AddKeyValue(3, 333));
        System.out.println(tree.AddKeyValue(9, 999));
        System.out.println(tree.AddKeyValue(6, 666));

        System.out.println("right " + tree.Root.RightChild.NodeKey);
        System.out.println("left " + tree.Root.LeftChild.NodeKey);
        System.out.println(tree.Count());

        System.out.println(tree.FindNodeByKey(2).NodeHasKey ? tree.FindNodeByKey(2).Node.NodeValue : "null");
        System.out.println(tree.FindNodeByKey(7).NodeHasKey ? tree.FindNodeByKey(7).Node.NodeValue : "null");
        System.out.println(tree.FindNodeByKey(5).NodeHasKey ? tree.FindNodeByKey(5).Node.NodeValue : "null");
        System.out.println(tree.FindNodeByKey(1).NodeHasKey ? tree.FindNodeByKey(1).Node.NodeValue : "null");
        System.out.println("================");
        System.out.println(tree.FinMinMax(tree.FindNodeByKey(7).Node, false).NodeValue);
        System.out.println(tree.FinMinMax(tree.FindNodeByKey(7).Node, true).NodeValue);


        tree.log(tree.FindNodeByKey(5).Node);
    }

    public static int findComplement(int num) {
        int[] pow = new int[32];
        int i = 0;
        int ans = 0;
        while(num > 0){
            pow[i] = num % 2;
            if(pow[i] == 0){
                pow[i] = 1;
            }else pow[i] = 0;
            num /= 2;
            i++;

        }
        for (int j = 0; j < i; j++) {
            ans += pow[j] * Math.pow(2, j);
        }
        return ans;
    }
}
