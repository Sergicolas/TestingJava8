package TestingJava8.Utils;

import java.util.function.Consumer;

public class InLinePrint implements Consumer<String> {


    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
