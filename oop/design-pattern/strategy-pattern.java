
/*
    * 출처 : https://softwaredevelopmentstuff.com/2016/09/11/strategy-pattern-5-examples-from-java-se/
            https://ko.wikipedia.org/wiki/%EC%A0%84%EB%9E%B5_%ED%8C%A8%ED%84%B4

    * 역할
    context : Main
    Strategy : public interface Comparator<T>
    ConcreteStrategies : StrategyAComparator, StrategyBComparator


    * 추가적으로 공부한것
    @FunctionalInterface

    https://javaplant.tistory.com/32
    https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html
*/

@FunctionalInterface
interface Comparator<T> {
    int compare(T o1, T o2);
}

class StrategyAComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

class StrategyBComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

public class Main {

    public static void main(String[] args) {
        String[] stringArray = {"GoF", "Strategy", "Design pattern"};

        //aggregation
        sort(stringArray, new StrategyAComparator());

        //aggregation
        sort(stringArray, new StrategyBComparator());

        //aggregation, method reference
        sort(stringArray, String::compareTo);

        //aggregation, lambda
        sort(stringArray, (String o1, String o2) -> Integer.compare(o1.length(), o2.length()));

    }

    private static <T> void sort(T[] array, Comparator<? super T> c) {
        int size = array.length;

        for(int i=0; i < size-1; i++) {
            for(int j=0; j < size -1 -i; j++) {
                if(c.compare(array[j], array[j+1]) > 0)
                    swap(array, j, j+1);
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
