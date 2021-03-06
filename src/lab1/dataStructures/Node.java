package lab1.dataStructures;

import lab1.dataStructures.interfaces.List;
import lab1.dataStructures.interfaces.Tree;

public class Node<E> implements Tree<E> {
    E value;
    int subtreeHeight;
    List<Node<E>> childs;
    Node<E> parent;

    @SuppressWarnings("unchecked")
    public Node() {
        this.value = (E) new Object();
        childs = new ArrayList<>();
        parent = null;
        subtreeHeight = 1;
    }

    public Node(E value) {
        this.value = value;
        childs = new ArrayList<>();
        parent = null;
        subtreeHeight = 1;
    }

    @Override
    public void addChild(Node<E> newChild) {
        if (childs.isEmpty()) changeParentHeight(newChild.subtreeHeight);
        childs.add(newChild);
        newChild.parent = this;
    }

    private void changeParentHeight(int dHeight) {
        subtreeHeight += dHeight;
        if (parent != null) {
            parent.changeParentHeight(dHeight);
        }
    }

    @Override
    public boolean removeChild(Node<E> child) {
        return childs.remove(child);
    }

    @Override
    public boolean removeChild(int index) {
        return childs.remove(index) != null;
    }

    @Override
    public Node<E> getChild(int index) {
        return childs.get(index);
    }

    @Override
    public Node<E> getParent() {
        return parent;
    }

    @Override
    public int getHeight() {
        return subtreeHeight;
    }

    @Override
    public List<Node<E>> path() {
        List<Node<E>> res = new ArrayList<>();
        Node<E> curNode = this;
        res.add(curNode);
        while (curNode.parent != null) {
            curNode = curNode.parent;
            res.add(curNode);
        }
        return res;
    }

    @Override
    public AbstractTree<E> subtree() {
        return new AbstractTree<E>(this);
    }

    @Override
    public List<E> toList() {
        return subtree().toList();
    }

    @Override
    public Node<E> find(Object value) {
        if (this.value == value) return this;
        else {
            if (childs.isEmpty()) return null;
            for (int i = 0; i < childs.size(); ++i) {
                Node<E> foundElement = childs.get(i).find(value);
                if (foundElement != null) {
                    return foundElement;
                }
            }
            return null;
        }
    }

    @Override
    public Node<E> findParent(Node<E> another) {
        return another.parent;
    }

    @Override
    public int size() {
        return subtree().size();
    }

    @Override
    public boolean isEmpty() {
        return subtree().size() == 1;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value + "}";
    }
}
