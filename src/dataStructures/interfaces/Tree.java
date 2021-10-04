package dataStructures.interfaces;

import dataStructures.AbstractTree;
import dataStructures.Node;

public interface Tree<T> {

    void addChild(Node<T> newChild);

    boolean removeChild(Node<T> child);

    boolean removeChild(int index);

    Node<T> getChild(int index);

    Node<T> getParent();

    List<Node<T>> path();

    AbstractTree<T> subtree();

    List<T> toList();

    Node<T> find(Object value);

    Node<T> findParent(Node<T> another);

    int size();

    boolean isEmpty();
}