package lab2;

import lab1.dataStructures.ArrayList;
import lab1.dataStructures.interfaces.List;

public class ListUtils {
    public static List merge(List a, List b) {
        if (a.size() + b.size() > Integer.MAX_VALUE - 16) {
            return null;
        }
        List result = new ArrayList(a.size() + b.size());
        int i = 0,j = 0;
        for (; i < a.size(); ++i) {
            result.set(i, a.get(i));
        }
        for (;j < b.size(); ++j) {
            result.set(i + j, b.get(j));
        }
        return result;
    }
}
