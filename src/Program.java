import lab1.dataStructures.AbstractTree;
import lab1.dataStructures.ArrayList;
import lab1.dataStructures.HashMap;
import lab1.dataStructures.Node;
import lab1.dataStructures.interfaces.List;
import lab1.dataStructures.interfaces.Map;
import lab2.ListUtils;
import lab2.TreeUtils;

import java.util.Scanner;

public class Program {

    public static void main (String[] args){
        int choice = menu();
        switch (choice) {
            case 1:
                solveTask1();
                break;
            case 2:
                solveTask2();
                break;
            case 3:
                startTesting();
                break;
            default:
        }
    }

    private static void solveTask1() {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
        String s = input.nextLine();
        String[] words = s.split(" ");
        for (String word : words) {
            if (hashMap.keyContains(word)) {
                Integer preValue = hashMap.get(word);
                hashMap.put(word, preValue + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = hashMap.getEntries();
        for (int i = 0; i < entries.size(); ++i) {
            System.out.print(entries.get(i).key + ":" + entries.get(i).value + " ");
        }
    }

    private static void solveTask2() {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
        String s = input.nextLine();
        String[] words = s.split(" ");
        List<String> resultWords = new ArrayList<>();
        for (String word : words) {
            if (hashMap.keyContains(word)) {
                Integer preValue = hashMap.get(word);
                hashMap.put(word, preValue + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        for (String word : words) {
            if (hashMap.get(word) == 1) {
                resultWords.add(word);
                System.out.print(word + " ");
            }
        }
    }

    private static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Solve Task 1");
        System.out.println("2 - Solve Task 2");
        System.out.println("3 - Run Testing");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;
    }

    private static void startTesting() {
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
