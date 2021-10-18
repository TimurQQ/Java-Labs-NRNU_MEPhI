import lab1.dataStructures.AbstractTree;
import lab1.dataStructures.ArrayList;
import lab1.dataStructures.HashMap;
import lab1.dataStructures.Node;
import lab2.ListUtils;
import lab2.TreeUtils;

public class Program {

    public static void main (String[] args){
        //List Testing
        startListTesting();

        //HashMap Testing
        startHashMapTesting();

        //AbstractTree Testing
        startAbstractTreeTesting();

        //merge Testing
        startMergeTesting();

        //getDeep Testing
        startGetDeepTesting();
    }

    private static void startGetDeepTesting() {
        AbstractTree<String> t = new AbstractTree<>("987743");
        t.addChild(new Node<>("-100"));
        t.addChild(new Node<>("***"));
        t.getChild(1).addChild(new Node<>("999"));
        t.getChild(1).getChild(0).addChild(new Node<>("pippop"));
        AbstractTree<String> t1 = t.getChild(1).subtree();
        System.out.println(TreeUtils.deep(t));
    }

    private static void startMergeTesting() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        System.out.println(a);
        b.add(8);
        b.add(9);
        b.add(10);
        System.out.println(b);
        System.out.println(ListUtils.merge(a, b));
    }

    private static void startListTesting() {
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(a);
        System.out.println(a.isEmpty());
        a.add(8953);
        System.out.println(a.isEmpty());
        a.add(54);
        a.add(-389);
        a.add(null);
        System.out.println(a);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a.capacity());
        a.add(5435);
        System.out.println(a);
        System.out.println(a.capacity());
        a.add(1, 0);
        System.out.println(a);
        System.out.println(a.indexOf(0));
        Integer elem = a.get(3);
        System.out.println(elem);
        System.out.println(a.size());
        System.out.println(a.contains(54));
        Integer deleted = a.remove(2);
        System.out.println(deleted);
        System.out.println(a);
        System.out.println(a.size());
        System.out.println(a.contains(54));
        a.set(0, -1);
        System.out.println(a);
    }

    private static void startHashMapTesting() {
        HashMap<Integer, String> m = new HashMap<>();
        m.put(89, "HUY");
        m.put(943, "yotpryy");
        System.out.println(m.keyContains(943));
        System.out.println(m.get(943));
        m.put(null, "popo[po");
        m.put(null, "timtim");
        System.out.println(m.getEntries());
    }

    private static void startAbstractTreeTesting() {
        AbstractTree<String> t = new AbstractTree<>("987743");
        t.addChild(new Node<>("-100"));
        t.addChild(new Node<>("***"));
        t.getChild(1).addChild(new Node<>("999"));
        t.getChild(1).getChild(0).addChild(new Node<>("pippop"));
        System.out.println(t);
        AbstractTree<String> t1 = t.getChild(1).subtree();
        System.out.println(t1);
        System.out.println(t.find("999").subtree());
        System.out.println(t.toList());
        System.out.println(t.find("pippop").path());
    }
}
