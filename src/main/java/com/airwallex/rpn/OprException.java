/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn;

public class OprException extends Exception {
    public int charNumber;
    public String input;
    public OprException()
    {

    }
    public OprException(String str,String message,int number)
    {
        //super(message.replace("%s",str).replace("%d",String.valueOf(number)));
        this.input=str;
        this.charNumber=number;
    }
    public OprException(String message)
    {
        super(message);
    }
}

