/*
    * 출처 : https://ko.wikipedia.org/wiki/%ED%8C%A9%ED%86%A0%EB%A6%AC_%EB%A9%94%EC%84%9C%EB%93%9C_%ED%8C%A8%ED%84%B4
            https://refactoring.guru/design-patterns/factory-method/java/example
            https://gmlwjd9405.github.io/2018/08/07/factory-method-pattern.html

    * 역할
    Creator : java.util.Calendar#getInstance()

    Product : Calendar

    ConcreteProduct : BuddhistCalendar, JapaneseImperialCalendar, GregorianCalendar

    FactoryMethod : createCalendar

    주로 java core등 에서 locale 관련 instance 를 생성할때 사용함
    number format, calendar, charset, resource builder 등
*/


import java.util.Calendar;
import java.util.Locale;

public class FactoryMethod {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //GregorianCalendar
        System.out.println(calendar.get(Calendar.YEAR));

        Locale locale = new Locale("ja", "JP", "JP");
        //JapaneseImperialCalendar
        Calendar now = Calendar.getInstance(locale);

        System.out.println(now.get(Calendar.YEAR));
    }
}


