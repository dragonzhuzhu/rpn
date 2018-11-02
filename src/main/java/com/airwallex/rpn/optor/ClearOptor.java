/**
 * @author joe
 * @date 2018/11/2
 */
package com.airwallex.rpn.optor;


import com.airwallex.rpn.Constants;
import com.airwallex.rpn.OprException;

public class ClearOptor extends Optor {

    public ClearOptor(String value){
        this.setOptor(value);
    }
    public void op() throws OprException {

    }
    public static boolean isOptor(String str){
        return str.equals(Constants.clear);
    }
}
