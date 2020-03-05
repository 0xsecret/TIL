/*
    * 출처 : https://refactoring.guru/design-patterns/adapter/java/example
            https://en.wikipedia.org/wiki/Adapter_pattern
            https://github.com/iluwatar/java-design-patterns/issues/628

    “Convert the interface of a class into another interface clients expect.
    Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.”


    * 역할
    Client : main

    Target : List
    Adapter : asList method
    Adaptee : T...

    Target : java.io.Reader
    Adapter : InputStreamReader
    Adaptee : System.in
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Adapter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
