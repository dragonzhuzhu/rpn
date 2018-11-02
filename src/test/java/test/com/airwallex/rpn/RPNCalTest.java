/**
 * @author joe
 * @date 2018/11/2
 */

package test.com.airwallex.rpn;

import com.airwallex.rpn.OprException;
import com.airwallex.rpn.RPNCal;

public class RPNCalTest {


    public static void main(String[] args) throws OprException {
        //System.out.println("+-*/".indexOf("-")) ;
        RPNCal rpn = new RPNCal();
        //example 1
        System.out.println("-----example 1----");
        rpn.clear();
        rpn.evalRPN("5 2");

        //example 2
        System.out.println("-----example 2----");
        rpn.clear();
        rpn.evalRPN("2 sqrt");
        rpn.evalRPN("clear 9 sqrt");

        //example 3
        System.out.println("-----example 3----");
        rpn.clear();
        rpn.evalRPN("5 2 -");
        rpn.evalRPN("3 -");
        rpn.evalRPN("clear");

        //example 4
        System.out.println("-----example 4----");
        rpn.clear();
        rpn.evalRPN("5 4 3 2");
        rpn.evalRPN("undo undo *");
        rpn.evalRPN("5 *");
        rpn.evalRPN("undo");


        //example 5
        System.out.println("-----example 5----");
        rpn.clear();
        rpn.evalRPN("7 12 2 /");
        rpn.evalRPN("*");
        rpn.evalRPN("4 /");


        //example 6
        System.out.println("-----example 6----");
        rpn.clear();
        rpn.evalRPN("1 2 3 4 5");
        rpn.evalRPN("*");
        rpn.evalRPN("clear 3 4 -");


        //example 7
        System.out.println("-----example 7----");
        rpn.clear();
        rpn.evalRPN("1 2 3 4 5");
        rpn.evalRPN("* * * *");


        //example 8
        System.out.println("-----example 8----");
        rpn.clear();
        rpn.evalRPN("1 2 3 * 5 + * * 6 5");


        //example 9:test more spaces and exception for sqrt
        System.out.println("-----example 9----");
        rpn.clear();
        rpn.evalRPN("1 2 3  * 5 + * clear sqrt 6 5");

        //example 10:other than '+-*/|sqrt|clear|undo'
        System.out.println("-----example 10----");
        rpn.clear();
        rpn.evalRPN("1 2 3   test hello");
        rpn.evalRPN("1 2 3   & %");
    }
}
