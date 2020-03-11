/*
    * 출처 : https://ko.wikipedia.org/wiki/%ED%85%9C%ED%94%8C%EB%A6%BF_%EB%A9%94%EC%86%8C%EB%93%9C_%ED%8C%A8%ED%84%B4
            https://refactoring.guru/design-patterns/template-method/java/example

    * 역할
    AbstractClass : List

    TemplateMethod : replaceAll
        - operation : listIterator

    ConcreteClass : LinkedList, ArrayList
        - impl
            : LinkedList
            public ListIterator<E> listIterator(int index) {
                checkPositionIndex(index);
                return new ListItr(index);
            }

            : ArrayList
            public ListIterator<E> listIterator(int index) {
                if (index < 0 || index > size)
                    throw new IndexOutOfBoundsException("Index: "+index);
                return new ListItr(index);
            }

     * 추가적으로 궁금한것
       - InputStream을 상속받은 FilterInputStream의 skip method는 왜 @override annotation이 없지?
       - https://www.tutorialspoint.com/importance-of-override-annotation-in-java
*/

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TemplateMethod {

    public static void main(String[] args) {
        
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        linkedList.replaceAll(integer -> integer + 1);

        arrayList.replaceAll(integer -> integer + 1);


    }
}


