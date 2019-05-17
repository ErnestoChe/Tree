package com.company;

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
                find.Node = null;
                break;
            }
            if(find.Node.NodeKey < key){
                find.Node = find.Node.RightChild;
            }else if(find.Node.NodeKey > key){
                find.Node = find.Node.LeftChild;
            }
        }
        if(find.Node == null){
            find.NodeHasKey = false;
        }else find.NodeHasKey = true;

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
        return false; // если узел не найден
    }

    public int Count()
    {
        return count; // количество узлов в дереве
    }

    public void log(BSTNode node){
        System.out.println("key " + node.NodeKey);
        System.out.println("val " + node.NodeValue);
        System.out.println(node.Parent != null ? "parent "+node.Parent.NodeValue : "parent null");
        System.out.println(node.LeftChild != null ? "left "+node.LeftChild.NodeValue : "left null");
        System.out.println(node.RightChild != null ? "right "+node.RightChild.NodeValue : "right null");
    }

}