package lab1.dataStructures;

import lab1.dataStructures.interfaces.List;

public class AbstractTree<T> extends Node<T> {

    public AbstractTree() {
        super();
    }

    public AbstractTree(T value) {
        super(value);
    }

    public AbstractTree(Node<T> node) {
        this.value = node.value;
        this.subtreeHeight = node.subtreeHeight;
        this.childs = node.childs;
        this.parent = null;
    }

    @Override
    public List<T> toList() {
        List<T> res = new ArrayList<>();
        res.add(value);
        if (childs.isEmpty()) return res;
        for (int i = 0;i < childs.size(); ++i) {
            res.addAll(childs.get(i).toList());
        }
        return res;
    }

    @Override
    public String toString() {
        return "TreeRootNode{" +
                "RootValue=" + value +
                ", childs=" + childs +
                ", parent=" + parent +
                '}';
    }
}