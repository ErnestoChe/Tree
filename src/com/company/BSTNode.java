package com.company;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если не найден узел, и в дереве только один корень
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null
    int count;
    public BST(BSTNode<T> node)
    {
        Root = node;
        count = 1;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        BSTFind<T> find = new BSTFind<>();
        find.Node = Root;
        while(find.Node.NodeKey!=key){
            if(find.Node.RightChild == null && find.Node.LeftChild == null){
                if(key<find.Node.NodeKey){
                    find.ToLeft = true;
                }else find.ToLeft = false;
                //find.Node = null;
                break;
            }
            if(find.Node.NodeKey < key){
                if(find.Node.RightChild != null){
                    find.Node = find.Node.RightChild;
                }else {
                    //find.Node = null;
                    find.ToLeft = false;
                    break;
                }
            }else /*if(find.Node.NodeKey > key)*/{
                if(find.Node.LeftChild != null){
                    find.Node = find.Node.LeftChild;
                }else{
                    //find.Node = null;
                    find.ToLeft = true;
                    break;
                }
            }
        }
        find.NodeHasKey = (find.Node.NodeKey == key);
        return find;
    }

    public boolean AddKeyValue(int key, T val)
    {
        // добавляем ключ-значение в дерево
        boolean is_key = true;

        BSTNode<T> node_to_add = new BSTNode<>(key, val, null);
        BSTNode<T> tmp = Root;
        while(true){
            if(tmp.NodeKey < key){
                if(tmp.RightChild != null){
                    tmp = tmp.RightChild;
                }else{
                    tmp.RightChild = node_to_add;
                    node_to_add.Parent = tmp;
                    count++;
                    break;
                }
            }else if(tmp.NodeKey > key){
                if(tmp.LeftChild != null){
                    tmp = tmp.LeftChild;
                }else{
                    tmp.LeftChild = node_to_add;
                    node_to_add.Parent = tmp;
                    count++;
                    break;
                }
            }

            if(tmp.NodeKey == key){
                is_key = false;
                break;
            }
        }
        return is_key; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальное/минимальное в поддереве
        BSTNode tmp = FromNode;
        if(FindMax){
            while(tmp.RightChild != null){
                tmp = tmp.RightChild;
            }
        }else{
            while(tmp.LeftChild != null){
                tmp = tmp.LeftChild;
            }
        }

        return tmp;
    }

    public boolean DeleteNodeByKey(int key)
    {
        // удаляем узел по ключу
        Boolean flag;
        BSTNode del_node = FindNodeByKey(key).Node;
        if(del_node.NodeKey==key){
            if(del_node.LeftChild == null && del_node.RightChild == null)//если нет дочерних элементов
            {
                if(del_node == Root){
                    Root = null;
                }else{
                    if(del_node.NodeKey<del_node.Parent.NodeKey){
                        del_node.Parent.LeftChild = null;
                    }else del_node.Parent.RightChild = null;
                }
                flag = true;
            }else
            if(del_node.LeftChild != null && del_node.RightChild == null)//есть только левый дочерний элемент
            {
                if(del_node == Root){
                    Root = del_node.LeftChild;
                    Root.Parent = null;
                }else{
                    BSTNode child = del_node.LeftChild;
                    child.Parent = del_node.Parent;
                    if(del_node.Parent.NodeKey < del_node.NodeKey){
                        child.Parent.RightChild = child;
                    }else child.Parent.LeftChild = child;
                }
                flag = true;
            }else if(del_node.LeftChild == null && del_node.RightChild!= null)//есть только правый дочерний элемент
            {
                if(del_node == Root){
                    Root = del_node.RightChild;
                    Root.Parent = null;
                }else{
                    BSTNode child = del_node.RightChild;
                    child.Parent = del_node.Parent;
                    if(del_node.Parent.NodeKey < del_node.NodeKey){
                        child.Parent.RightChild = child;
                    }else child.Parent.LeftChild = child;
                }
                flag = true;
            }else
            { //есть оба дочерних элемента
                BSTNode preemnik = FinMinMax(del_node.RightChild, false);
                DeleteNodeByKey(preemnik.NodeKey);
                count++;

                BSTNode par = del_node.Parent;
                if(del_node == Root){
                    Root = preemnik;
                }else{
                    if(del_node.NodeKey < par.NodeKey){
                        par.LeftChild = preemnik;
                    }else par.RightChild = preemnik;
                }

                preemnik.Parent = del_node.Parent;
                preemnik.LeftChild = del_node.LeftChild;
                preemnik.RightChild = del_node.RightChild;

                if(del_node.RightChild!=null)   del_node.RightChild.Parent = preemnik;
                if(del_node.LeftChild!=null)   del_node.LeftChild.Parent = preemnik;

                flag = true;
            }
        } else flag = false;

        if(flag) count--;
        return flag; // если узел не найден
    }

    public int Count()
    {
        return count; // количество узлов в дереве
    }

    public ArrayList<BSTNode> DeepAllNodes(int order)
    {
        ArrayList<BSTNode> list = deep(Root, order);
        return list;
    }
    public ArrayList<BSTNode> deep(BSTNode node, int order){
        ArrayList<BSTNode> list = new ArrayList<>();
        switch (order){
            case(0):{   //in order
                if(node.LeftChild!=null) {
                    list.addAll(deep(node.LeftChild, order));
                }
                list.add(node);
                if(node.RightChild!=null) {
                    list.addAll(deep(node.RightChild, order));
                }
                break;
            }
            case(1):{   //post order
                if(node.LeftChild!=null) {
                    list.addAll(deep(node.LeftChild, order));
                }
                if(node.RightChild!=null) {
                    list.addAll(deep(node.RightChild, order));
                }
                list.add(node);
                break;
            }
            case(2):{   //pre order
                list.add(node);
                if(node.LeftChild!=null) {
                    list.addAll(deep(node.LeftChild, order));
                }
                if(node.RightChild!=null) {
                    list.addAll(deep(node.RightChild, order));
                }
                break;
            }
        }

        return list;
    }

    public ArrayList<BSTNode> WideAllNodes()
    {
        ArrayList<BSTNode> tmp = new ArrayList<>();
        tmp.add(Root);
        return tmp;
    }
    public ArrayList<BSTNode> wide(ArrayList<BSTNode> list){
        ArrayList<BSTNode> tmp = new ArrayList<>();
        for (BSTNode i:list) {
            if(i.LeftChild!=null) tmp.add(i.LeftChild);
            if(i.RightChild!=null) tmp.add(i.RightChild);
            list.addAll(tmp);
        }
        return  list;
    }
    public void log_find(BSTFind find_node){
        System.out.println("key " + find_node.Node.NodeKey);
        System.out.println("to left " + find_node.ToLeft);
        System.out.println("has key " + find_node.NodeHasKey);
    }

    public void log(BSTNode node){
        if(node!= null){
            System.out.println("key " + node.NodeKey);
            System.out.println("val " + node.NodeValue);
            System.out.println(node.Parent != null ? "parent "+node.Parent.NodeValue : "parent null");
            System.out.println(node.LeftChild != null ? "left "+node.LeftChild.NodeValue : "left null");
            System.out.println(node.RightChild != null ? "right "+node.RightChild.NodeValue : "right null");
        }else System.out.println("null");

        System.out.println();
    }

}