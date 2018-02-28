import java.util.Optional;

public class MyClass {
    public static void main(String args[]) {
        
        class TestClass {
            String getStr() {
                return "Hello";
            }
        }
    
        TestClass t = null;
        
        String str = "not null";
        
        //String result = Optional.ofNullable(str).orElse(t.getStr());
        // NPE
        
        String result = Optional.ofNullable(str).orElseGet(() -> t.getStr());
        //No NPE
        
        /*
          orElse와 orElseGet의 차이가 아니라
          Eager evaluation와 Lazy evaluation의 차이
          function argument가 call-by-value로 전달될때 evaluation을 하기때문에 NPE 발생
          참고 : https://blog.rapid7.com/2017/01/13/java-8-lazy-argument-evaluation/
                http://mussebio.blogspot.kr/2012/05/java-call-by-valuereference.html
        */
        
        System.out.println(result);
    }
}
