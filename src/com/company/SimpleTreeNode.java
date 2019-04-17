package com.company;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<>();
    }
    public void log(){
        System.out.println(NodeValue + " value");
        System.out.println((Parent != null ? Parent.NodeValue + " parent" : "null parent"));
        System.out.println("Children:");
        for (int i = 0; i < Children.size(); i++) {
            System.out.print(Children.get(i).NodeValue + " ");
        }
        System.out.println();
        System.out.println();
    }
}
class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null
    public int count;

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
        Root.Parent = null;
        count = 1;
    }

    /**
     * На вход подаются два узла дерева, второй узел становится дочерним первого
     * @param ParentNode
     * @param NewChild
     */
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        // ваш код добавления нового дочернего узла существующему ParentNode
        NewChild.Parent = ParentNode;
        ParentNode.Children.add(NewChild);
        count++;
    }

    /**
     * Удаляет указанный узел
     * @param NodeToDelete
     */
    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if(NodeToDelete == Root){
            for (SimpleTreeNode<T> i: Root.Children) {
                i.Parent = null;
                count--;
            }
        }else
        if(GetAllNodes().contains(NodeToDelete)){
            NodeToDelete.Parent.Children.remove(NodeToDelete);
            NodeToDelete.Parent.Children.addAll(NodeToDelete.Children);
            NodeToDelete.Parent = null;
            NodeToDelete.Children.clear();
            count--;
        }else{
            System.out.println("couldnt delete");
        }
        // ваш код удаления существующего узла NodeToDelete
    }

    /**
     * Возввращает список всех узлов в дереве
     */
    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> l = new ArrayList<>();
        l.add(Root);
        l.addAll(getN(Root));
        return l;
    }

    /**
     * Рекусрсивный алгоритм получения всех узлов
     * @param tmp
     * @return
     */
    public List<SimpleTreeNode<T>> getN(SimpleTreeNode<T> tmp){
        List<SimpleTreeNode<T>> r = new ArrayList<>();
        if(!tmp.Children.isEmpty()){
            for (SimpleTreeNode<T> i: tmp.Children){
                r.addAll(getN(i));
            }
        }r.addAll(tmp.Children);
        return r;
    }

    /**
     * Возвращает список всех узлов по заданному значению
     * @param val
     */
    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // ваш код поиска узлов по значению
        List<SimpleTreeNode<T>> tmp = GetAllNodes();
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        for (SimpleTreeNode<T> i: tmp) {
            if(i.NodeValue == val){
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Перемещает первый узел в список дочерних второго
     * @param OriginalNode перемещаемый узел
     * @param NewParent новый "родитель" для перемещаемого узла
     */
    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        OriginalNode.Parent.Children.remove(OriginalNode);
        OriginalNode.Parent = NewParent;
        NewParent.Children.add(OriginalNode);
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    /**
     * Возвращает количество узлов в дереве
     * @return
     */
    public int Count()
    {
        // количество всех узлов в дереве
        return count;
    }

    /**
     * Возвращает количество листьев в дереве(узлов, неимеющих дочерние узлы)
     * @return
     */
    public int LeafCount()
    {
        // количество листьев в дереве
        int count = 0;
        List<SimpleTreeNode<T>> tmp = GetAllNodes();
        for (SimpleTreeNode<T> i: tmp) {
            if(i.Children.isEmpty()) count++;
        }
        return count;
    }
}
