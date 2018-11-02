/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn;

public class Constants {

    public static String add = "+";
    public static String sub = "-";
    public static String multiply = "*";
    public static String divide = "/";
    public static String sqrt = "sqrt";
    public static String clear = "clear";
    public static String undo = "undo";

    //message
    public static String msgInput = "pls input strings containing lists of numbers and operators: ";
    public static String msgStack ="stack: ";
    public static String msgLong ="%d ";
    public static String msgDouble ="%.10f ";
    public static String msgLine ="\r\n";
    //exception
    public static String exDivide = "The divisor can't be zero";
    public static String exSqrt = "Square root can't be less than zero";
    public static String exParam = "Operator %s (position:%d): insufficient parameters";
    public static String exFourOptor = "Operator not supported";
    public static String unExpOptor ="current calculator just support the chars in '+-*/|sqrt|clear|undo'";
    public static String exFormat ="Operator %s (position:%d): can't be formatted as number";
    //regex
    public static String regOptor ="([\\d+(\\.\\d+)?|\\+|\\-|\\*|\\/|sqrt|clear|undo]\\s*)*";
    public static String regSplit =" ";
}