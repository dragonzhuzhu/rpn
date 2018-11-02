/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn;

public class Utils {

    public static String format(String s, String str,int num){
        return s.replace("%s",str).replace("%d",String.valueOf(num));
    }


    public static boolean isLong(double optor){
        return Math.round(optor)-optor==0;
    }

    public static boolean isClearOptor(String str){
        return str.equals(Constants.clear);
    }

    public static boolean isFourOptor(String str){
        return str.equals(Constants.add) || str.equals(Constants.sub) ||str.equals(Constants.multiply) ||str.equals(Constants.divide);
    }

    public static boolean isSingleOptor(String str){
        return str.equals(Constants.sqrt);
    }

    public static boolean isUndoOptor(String str) {
        return str.equals(Constants.undo);
    }
}
